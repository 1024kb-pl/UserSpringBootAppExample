package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger("UserExample");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

