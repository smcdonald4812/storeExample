package com.mcdonald.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class URIConfig {
	private String bookStore = new String("storeexample.com");
	public String getBookStore() {
		return bookStore;
	}
}
