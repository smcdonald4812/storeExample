package com.mcdonald;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mcdonald.config.URIConfig;
import com.mcdonald.routes.RouteBuilder;

//the api gateway
@SpringBootApplication
@EnableConfigurationProperties(URIConfig.class)
public class BookstoreGatewayApplication implements CommandLineRunner{
	@Autowired
	RouteBuilder rb;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreGatewayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rb.bookStoreRoutes();
	}

}
