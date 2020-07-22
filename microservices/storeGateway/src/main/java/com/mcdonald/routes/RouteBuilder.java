package com.mcdonald.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mcdonald.config.URIConfig;

//service for building the routes for the gateway
@Service
public class RouteBuilder {
	@Autowired
	private RouteLocatorBuilder builder;
	
	@Autowired
	private URIConfig conf;
	
	private String uri = conf.getBookStore();
	
	//builds the routes
	@Bean
	public RouteLocator bookStoreRoutes() {
		return builder.routes()
				.route(x -> x.path("/store")
						.uri(uri))
				.route(x -> x.host("*.hystrix.com")
						.filters(f -> f.hystrix(config -> config
								.setName("fallbackCmd")
								.setFallbackUri("forward:/fallback")))
						.uri(uri))
				.build();
	}
}
