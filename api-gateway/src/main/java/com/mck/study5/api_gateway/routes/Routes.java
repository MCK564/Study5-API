package com.mck.study5.api_gateway.routes;

import com.mck.study5.api_gateway.filter.JwtHeaderFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Routes {
    private final JwtHeaderFilter jwtHeaderFilter;

    @Value("${jwt.secretKey}")
    private String key;

    @Value("${api.prefix}")
    private String apiPrefix;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        JwtHeaderFilter.Config config = new JwtHeaderFilter.Config();
        config.setSecretKey(key);

        return builder.routes()
                .route("notification-service",r->r.path(apiPrefix+"/notifications/**")
                        .filters(f -> f.filter(jwtHeaderFilter.apply(config)))
                        .uri("http://localhost:8082"))
                .route("product-service",r->r.path(apiPrefix+"/products/**")
                        .filters(f -> f.filter(jwtHeaderFilter.apply(config)))
                        .uri("http://localhost:8083"))
                .route("payment-service",r->r.path(apiPrefix+"/payments/**")
                        .filters(f -> f.filter(jwtHeaderFilter.apply(config)))
                        .uri("http://localhost:8084"))
                .route("upload-service",r->r.path(apiPrefix+"/upload/**")
                        .filters(f -> f.filter(jwtHeaderFilter.apply(config)))
                        .uri("http://localhost:8085"))
                .route("user-service", r->r.path(apiPrefix+"/users/**")
                        .filters(f -> f.filter(jwtHeaderFilter.apply(config))
                                .circuitBreaker(c -> c
                                        .setName("userServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback-response")))
                        .uri("http://localhost:8086"))
                .build();

    }
}
