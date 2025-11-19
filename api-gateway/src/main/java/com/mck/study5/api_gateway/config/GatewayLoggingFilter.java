package com.mck.study5.api_gateway.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GatewayLoggingFilter {

    @Bean
    public GlobalFilter accessLoggingFilter() {
        return (exchange, chain) -> {
            var req = exchange.getRequest();
            long t0 = System.currentTimeMillis();
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                var res = exchange.getResponse();
                var path = req.getURI().getRawPath();
                var qs = req.getURI().getRawQuery();
                var full = qs == null ? path : (path + "?" + qs);
                var status = res.getStatusCode() == null ? "-" : res.getStatusCode().toString();
                log.info("[GW] {} {} -> {} {}ms UA={}",
                        req.getMethod(), full, status, (System.currentTimeMillis() - t0),
                        req.getHeaders().getFirst("User-Agent"));
            }));
        };

    }
}
