package com.mck.study5.api_gateway.filter;


import constants.MessageKeys;
import io.jsonwebtoken.security.SignatureException;
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
            String header = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if(header != null && header.startsWith("Bearer ")){
                String token = header.substring(7);
                try{
                    Claims claims  = Jwts.parser()
                            .setSigningKey(config.getSecretKey().getBytes())
                            .build().parseSignedClaims(token).getPayload();

                    String userId = claims.get("userId").toString();

                    ServerWebExchange mutated = exchange.mutate().request(
                            builder->builder.header("X-User-Id", userId)).build();

                    return chain.filter(mutated);
                }catch(SignatureException e){
                    return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, MessageKeys.INVALID_JWT_SIGNATURE));
                }catch (Exception e){
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,MessageKeys.TOKEN_INVALID));
                }

            }
            return chain.filter(exchange);
        };
    }
}
