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

import com.mcdonald.models.Account;
import com.mcdonald.services.AccountService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/storeexample/account")
public class AccountController {
	@Autowired
	AccountService as;
	@GetMapping("/get/{id}")
	public List<Account> get(@Valid @PathVariable int id) {
		return as.readByUserId(id);
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody Account a) {
		as.create(a);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody Account a) {
		as.update(a);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		as.delete(id);
	}
}
