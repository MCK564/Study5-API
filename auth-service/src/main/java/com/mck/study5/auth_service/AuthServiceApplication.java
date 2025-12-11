package com.mck.study5.auth_service;

import com.mck.study5.auth_service.props.GoogleProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.mck.study5")
@EntityScan(basePackages = "com.mck.study5.auth_service.models")
//@EnableJpaRepositories(basePackages = "com.mck.study5.auth_service.repositories")
public class AuthServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}
