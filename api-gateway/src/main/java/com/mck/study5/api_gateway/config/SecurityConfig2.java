package com.mck.study5.api_gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;

import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.util.Map;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SecurityConfig2 {
    @Value("${api.prefix}")
    private String apiPrefix;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(
                                            "/fallback/**",
                                        "/auth/**",
                                            "/users/**",
                                        "/actuator/**",
                                        "/swagger-ui/**", "/v3/api-docs/**",
                                "/uploads/**","/downloads/**",
                                "/products/**","notifications/",
                                "/payments/**", "/learning/**"
                                )
                        .permitAll()
                        .pathMatchers(apiPrefix+"/admin/**").hasRole("ADMIN")
                        .pathMatchers(apiPrefix+"/staff/**").hasRole("STAFF")
                        .anyExchange().authenticated()
                )
//                .oauth2Login(oauth2 -> oauth2.authenticationSuccessHandler(oAuth2SuccessHandler()))
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
                .build();
    }

    @Bean
    public ServerAuthenticationEntryPoint unauthorizedEntryPoint() {
        return (exchange, ex)-> Mono.fromRunnable(()->
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED));
    }

    @Bean
    public ServerAccessDeniedHandler accessDeniedHandler() {
        return (exchange, ex) -> Mono.fromRunnable(()->{
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        });
    }

    @Bean
    public ServerAuthenticationSuccessHandler oAuth2SuccessHandler() {
        return (webFilterExchange, authentication) ->{
            OAuth2User user = (OAuth2User) authentication.getPrincipal();
            String email = user.getAttribute("email");
            String name = user.getAttribute("name");
            String provider = authentication.getAuthorities().toString();

            assert email != null;
            assert name != null;
            Map<String,Object> payload = Map.of(
                    "email",email,
                    "name",name,
                    "provider", provider
            );

           return WebClient.create("http://localhost:8081")
                   .post()
                   .bodyValue(payload)
                   .retrieve()
                   .bodyToMono(Void.class)
                   .then(Mono.fromRunnable(()->{
                       ServerHttpResponse response = (ServerHttpResponse) webFilterExchange.getExchange().getResponse();
                       response.setStatusCode(HttpStatus.FOUND);
                       response.getHeaders().setLocation(URI.create("http://localhost:3000/oauth-success"));
                   }));
        };

    }


}
