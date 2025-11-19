package com.mck.study5.product_service.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RequiredArgsConstructor
public class WebSecurityConfig2 {
    private final SecurityRequestHeaderFilter securityRequestHeaderFilter;

    @Bean
    SecurityFilterChain security(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(reg -> reg
                        .requestMatchers(
                                "/actuator/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityRequestHeaderFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
