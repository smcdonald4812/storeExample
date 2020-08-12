package com.mcdonald.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.model.Cart;
import com.mcdonald.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cr;
	
	public Cart getCart(String username) {
		return cr.getByUsername(username);
	}
	public void createCart(Cart c) {
		cr.save(c);
	}
	public void updateCart(Cart c) {
		cr.save(c);
	}
	public void deleteCart(String id) {
		cr.deleteById(id);
	}
}
