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

import com.mcdonald.models.AccountTransaction;
import com.mcdonald.services.AccountTransactionService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/storeexample/accounttransaction")
public class AccountTransactionController {
	@Autowired
	AccountTransactionService ats;
	@GetMapping("/get/{id}")
	public List<AccountTransaction> get(@Valid @PathVariable int id) {
		return ats.readByAccountId(id);
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody AccountTransaction a) {
		ats.create(a);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody AccountTransaction a) {
		ats.update(a);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		ats.delete(id);
	}
}
