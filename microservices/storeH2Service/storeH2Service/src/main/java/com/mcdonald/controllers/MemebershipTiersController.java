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

import com.mcdonald.models.MembershipTiers;
import com.mcdonald.services.MembershipTiersService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/storeexample/membershiptiers")
public class MemebershipTiersController {
	@Autowired
	MembershipTiersService mts;
	@GetMapping("/getall")
	public List<MembershipTiers> getAll() {
		return mts.readAll();
	}
	@PostMapping("/create")
	public void create(@Valid @RequestBody MembershipTiers t) {
		mts.create(t);
	}
	@PutMapping("/update")
	public void update(@Valid @RequestBody MembershipTiers t) {
		mts.update(t);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@Valid @PathVariable int id) {
		mts.delete(id);
	}
}
