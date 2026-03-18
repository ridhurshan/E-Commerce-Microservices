package com.example.project_01_E_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class Project01ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project01ECommerceApplication.class, args);
	}

}
