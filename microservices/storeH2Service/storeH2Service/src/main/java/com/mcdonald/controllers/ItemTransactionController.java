package com.mcdonald.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.mcdonald.models.ItemTransaction;
import com.mcdonald.services.ItemTransactionService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/storeexample/itemtransaction")
public class ItemTransactionController {
	@Autowired
	ItemTransactionService its;
	@GetMapping("/get/seller/{id}")
	public List<ItemTransaction> getBySeller(@Valid @PathVariable int id) {
		return its.readBySellerId(id);
	}
	@GetMapping("/get/buyer/{id}")
	public List<ItemTransaction> getByBuyer(@Valid @PathVariable int id) {
		return its.readByBuyerId(id);
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody ItemTransaction i) {
		its.create(i);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody ItemTransaction i) {
		its.update(i);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		its.delete(id);
	}
}
