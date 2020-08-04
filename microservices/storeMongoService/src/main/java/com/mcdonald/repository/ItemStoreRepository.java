package com.mcdonald.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcdonald.model.Item;

@Repository
public interface ItemStoreRepository extends MongoRepository<Item, String>{
	public Item findByTitle(String title);
	public Optional<Item> findById(String id);
	public void deleteById(String id);
	public List<Item> findByType(String type);
}
