package com.mcdonald.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mcdonald.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {
	@Query("{ 'username' : ?0 }")
	public Cart getByUsername(String username);
}
