package com.mcdonald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreEurekaServerApplication.class, args);
	}

}
