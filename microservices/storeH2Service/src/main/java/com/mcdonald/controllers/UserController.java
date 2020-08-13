package com.mcdonald.controllers;

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

import com.mcdonald.models.User;
import com.mcdonald.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService us;
	@GetMapping("/{username}/{pass}")
	public User get(@Valid @PathVariable String username, @Valid @PathVariable String pass) {
		User u = us.readByUsername(username);
		if(u.getUsername().equals(username)&u.getPassword().equals(pass)) return u;
		return null;
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody User u) {
		us.create(u);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody User u) {
		us.update(u);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		us.delete(id);
	}
}
