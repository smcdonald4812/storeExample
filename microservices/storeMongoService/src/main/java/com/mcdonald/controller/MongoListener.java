package com.mcdonald.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.model.Item;
import com.mcdonald.services.ItemService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
public class MongoListener {
	@Autowired
	ItemService is;
	
	@GetMapping("/mongo")
	public List<Item> getItems() {
		return is.getItems();
	}
	@GetMapping("/mongo/type/{type}") 
	public List<Item> getItemsByType(@PathVariable String type) {
		return is.getItemsByType(type);
	}
	@GetMapping("/mongo/id/{id}") 
	public Optional<Item> getItemsById(@PathVariable String id) {
		return is.findById(id);
	}
	@GetMapping("/mongo/title/{title}") 
	public Item getItemsByTitle(@PathVariable String title) {
		return is.getByTitle(title);
	}
	@PutMapping("/mongo")
	public void putItem(@RequestBody Item i) {
		is.createItem(i);
	}
	@DeleteMapping("/mongo/item/{id}")
	public void deleteItem(@PathVariable String id) {
		is.deleteItem(id);
	}
	@PostMapping("/mongo/item/{item}")
	public void updateItem(@RequestBody Item item) {
		is.updateItem(item);
	}
}
