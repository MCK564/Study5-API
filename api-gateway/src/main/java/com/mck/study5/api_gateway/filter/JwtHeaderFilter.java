package com.mck.study5.api_gateway.filter;



import com.mck.study5.api_gateway.constants.MessageKeys;
import io.jsonwebtoken.JwtException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class JwtHeaderFilter extends AbstractGatewayFilterFactory<JwtHeaderFilter.Config> {

    @Getter
    @Setter
    public static class Config{
        @Value("${jwt.secretKey}")
        private String secretKey;
    }
    public JwtHeaderFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange,chain) ->{

            String header = exchange.getRequest()
                    .getHeaders()
                    .getFirst(HttpHeaders.AUTHORIZATION);

            if(header != null && header.startsWith("Bearer ")){
                String token = header.substring(7);
                try{
                    Claims claims  = Jwts.parser()
                            .setSigningKey(config.getSecretKey().getBytes())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();

                    String userId = claims.get("id").toString();
                    String role = claims.get("role").toString();

                    ServerWebExchange mutated = exchange.mutate().request(
                            b->b.headers(h->{
                                h.remove("X-User-Id");
                                h.remove("X-User-Role");
                                h.add("X-User-Id", userId);
                                h.add("X-User-Role", role);
                            })
                            ).build();

                    return chain.filter(mutated);

                }catch(JwtException je){
                    return unauthorized(exchange);
                } catch (Exception e){
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,MessageKeys.TOKEN_INVALID));
                }

            }
            return chain.filter(exchange);
        };
    }


    private Mono<Void>  unauthorized(ServerWebExchange exchange){
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        var buf = exchange.getResponse().bufferFactory().wrap(MessageKeys.INVALID_JWT_ACCESS_TOKEN.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buf));
    }
}
