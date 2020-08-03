package com.mcdonald.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.model.Item;
import com.mcdonald.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository repository;
	
	public Item createItem(Item i) {
		return repository.save(i);
	}
	public List<Item> getItems() {
		return repository.findAll();
	}
	public List<Item> getItemsByType(String type) {
		return repository.findByType(type);
	}
	public Item getByTitle(String title) {
		return repository.findByTitle(title);
	}
	public Item findById(int id) {
		return repository.findById(id);
	}
}
