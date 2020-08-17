package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.models.Users;
import com.mcdonald.repositories.UserRepository;

@Service
public class UserService{
	@Autowired
	UserRepository ur;
	public Optional<Users> read(int id) {
		return ur.findById(id);
	}
	public List<Users> readAll() {
		return ur.findAll();
	}
	public void create(Users t) {
		ur.saveAndFlush(t);
	}
	public void update(Users t) {
		ur.saveAndFlush(t);
	}
	public void delete(int id) {
		ur.deleteById(id);
	}
	public Users readByUsername(String username) {
		return ur.findByUsername(username);
	}
	public List<Users> readByAge(int i) {
		return ur.findByAge(i);
	}
	public List<Users> readByCreated(Date date) {
		return ur.findByCreated(date);
	}
	public Users readByMobile(String mobile) {
		return ur.findByMobile(mobile);
	}
	public List<Users> readByCountry(String country) {
		return ur.findByCountry(country);
	}
	public List<Users> readByRegion(String region) {
		return ur.findByRegion(region);
	}
}
