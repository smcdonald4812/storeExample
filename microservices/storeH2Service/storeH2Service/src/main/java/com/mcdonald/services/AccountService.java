package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.models.Account;
import com.mcdonald.models.STATUS;
import com.mcdonald.repositories.AccountRepository;

@Service
public class AccountService{
	@Autowired
	AccountRepository sr;
	public Optional<Account> read(int id) {
		return sr.findById(id);
	}
	public List<Account> readAll() {
		return sr.findAll();
	}
	public List<Account> readyByStatus(STATUS s) {
		return sr.findByStatus(s);
	}
	public List<Account> readByTimestamp(Date date) {
		return sr.findByTimestamp(date);
	}
	public List<Account> readByActive(Boolean bool) {
		return sr.findByActive(bool);
	}
	public List<Account> readByUserId(int id) {
		return sr.findByUserId(id);
	}
	public void create(Account t) {
		sr.saveAndFlush(t);
	}
	public void update(Account t) {
		sr.saveAndFlush(t);
	}
	public void delete(int id) {
		sr.deleteById(id);
	}
}
