package com.mcdonald.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.model.Item;
import com.mcdonald.services.ItemService;

@RestController
public class MongoListener {
	@Autowired
	ItemService is;
	@GetMapping("/mongo")
	List<Item> getItems() {
		return is.getItems();
	}
}
