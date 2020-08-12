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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.model.Item;
import com.mcdonald.services.ItemService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/mongo")
public class ItemController {
	@Autowired
	ItemService is;
	
	@GetMapping("/")
	public List<Item> getItems() {
		return is.getItems();
	}
	@GetMapping("/readType/{type}") 
	public List<Item> getItemsByType(@PathVariable String type) {
		return is.getItemsByType(type);
	}
	@GetMapping("/readId/{id}") 
	public Optional<Item> getItemsById(@PathVariable String id) {
		return is.findById(id);
	}
	@GetMapping("/readTitle/{title}") 
	public Item getItemsByTitle(@PathVariable String title) {
		return is.getByTitle(title);
	}
	@PostMapping("/item/create")
	public void putItem(@RequestBody Item i) {
		is.createItem(i);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteItem(@PathVariable String id) {
		is.deleteItem(id);
	}
	@PutMapping("/item/update")
	public void updateItem(@RequestBody Item item) {
		is.updateItem(item);
	}
}
