package com.mcdonald.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.model.Item;
import com.mcdonald.repository.ItemStoreRepository;

@Service
public class ItemService {
	@Autowired
	ItemStoreRepository repository;
	
	public Item createItem(Item item) {
		return repository.save(item);
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
	public Optional<Item> findById(String id) {
		return repository.findById(id);
	}
	public void deleteItem(String id) {
		repository.deleteById(id);
	}
	public void updateItem(Item item) {
		repository.save(item);
	}
}
