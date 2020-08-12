package com.mcdonald.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.model.Cart;
import com.mcdonald.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cs;
	
	@GetMapping("/{username}")
	public Cart getCart(@Valid @PathVariable String username) {
		return cs.getCart(username);
	}
	@PostMapping("/create")
	public void createCart(@Valid @RequestBody Cart c) {
		cs.createCart(c);
	}
	@PutMapping("/update")
	public void updateCart(@Valid @RequestBody Cart c) {
		cs.updateCart(c);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCart(@Valid @PathVariable String id) {
		cs.deleteCart(id);
	}
}
