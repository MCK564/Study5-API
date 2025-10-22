package com.mck.study5.api_gateway.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

public class JwtExceptionHandler implements ServerAuthenticationEntryPoint {
    @Override
    public reactor.core.publisher.Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        String body = "{\"code\":401,\"message\":\"Unauthorized: Invalid or expired token\",\"success\":false}";
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return exchange.getResponse().writeWith(
                Mono.just(exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8)))
        );
    }
}
