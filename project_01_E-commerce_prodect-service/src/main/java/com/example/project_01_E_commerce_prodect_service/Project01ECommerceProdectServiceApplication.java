package com.example.project_01_E_commerce_prodect_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class Project01ECommerceProdectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project01ECommerceProdectServiceApplication.class, args);
	}

}
