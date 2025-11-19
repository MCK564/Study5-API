package com.mck.study5.learning_service.configs;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableAutoConfiguration
@ComponentScan
public class WebSecurityConfig2 {
    private final SecurityRequestHeaderFilter securityRequestHeaderFilter;
    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req
                        .requestMatchers("/actuator/**")
                                .permitAll()
                                .anyRequest().authenticated()
                ).addFilterBefore(securityRequestHeaderFilter, UsernamePasswordAuthenticationFilter.class)
               return http.build();
    }
}
