package com.mcdonald.controllers;

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

import com.mcdonald.models.Users;
import com.mcdonald.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/storeexample/user")
public class UserController {
	@Autowired
	UserService us;
	@GetMapping("/{username}/{pass}")
	public Users get(@Valid @PathVariable String username, @Valid @PathVariable String pass) {
		Users u = us.readByUsername(username);
		if(u.getUsername().equals(username)&u.getPassword().equals(pass)) return u;
		return null;
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody Users u) {
		us.create(u);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody Users u) {
		us.update(u);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		us.delete(id);
	}
}
