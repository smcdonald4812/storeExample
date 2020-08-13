package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcdonald.models.User;
import com.mcdonald.repositories.UserRepository;

public class UserService implements Service<User>{
	@Autowired
	UserRepository ur;
	@Override
	public Optional<User> read(int id) {
		return ur.findById(id);
	}
	@Override
	public List<User> readAll() {
		return ur.findAll();
	}
	@Override
	public void create(User t) {
		ur.saveAndFlush(t);
	}
	@Override
	public void update(User t) {
		ur.saveAndFlush(t);
	}
	@Override
	public void delete(int id) {
		ur.deleteById(id);
	}
	public User readByUsername(String username) {
		return ur.findByUsername(username);
	}
	public List<User> readByAge(int i) {
		return ur.findByAge(i);
	}
	public List<User> readByCreated(Date date) {
		return ur.findByCreated(date);
	}
	public User readByMobile(String mobile) {
		return ur.findByMobile(mobile);
	}
	public List<User> readByCountry(String country) {
		return ur.findByCountry(country);
	}
	public List<User> readByRegion(String region) {
		return ur.findByRegion(region);
	}
}
