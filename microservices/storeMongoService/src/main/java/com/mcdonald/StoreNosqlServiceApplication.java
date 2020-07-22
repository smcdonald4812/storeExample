package com.mcdonald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreNosqlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreNosqlServiceApplication.class, args);
	}

}
