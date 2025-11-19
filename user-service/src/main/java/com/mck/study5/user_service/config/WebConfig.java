package com.mck.study5.user_service.config;


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
public class WebConfig {
    private final SecurityRequestHeaderFilter SecurityRequestHeaderFilter;

    @Bean
    SecurityFilterChain security(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(reg -> reg
                        .requestMatchers(
                                "/users/**",
                                "/actuator/**")
                        .permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(SecurityRequestHeaderFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}
