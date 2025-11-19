package com.mck.study5.learning_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mck.study5"})

public class LearningServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearningServiceApplication.class, args);
	}
}
