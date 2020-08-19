package com.mcdonald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//the api gateway on 8080 routes requests to proper microservices hard coded for now
@SpringBootApplication
public class StoreGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreGatewayApplication.class, args);
	}
}
