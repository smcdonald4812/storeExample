package com.mcdonald.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mcdonald.model.Item;

public interface ItemRepository extends MongoRepository<Item, Integer>{
	public Item findByTitle(String title);
	public Item findById(int id);
	public List<Item> getAll();
	public List<Item> findByType(String type);
}
