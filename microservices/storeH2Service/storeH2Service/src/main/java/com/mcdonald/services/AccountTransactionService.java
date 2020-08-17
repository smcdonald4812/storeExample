package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.models.AccountTransaction;
import com.mcdonald.repositories.AccountTransactionRepository;

@Service
public class AccountTransactionService{
	@Autowired
	AccountTransactionRepository atr;
	public Optional<AccountTransaction> read(int id) {
		return atr.findById(id);
	}
	public List<AccountTransaction> readAll() {
		return atr.findAll();
	}
	public List<AccountTransaction> readByAccountId(int id) {
		return atr.findByAccountId(id);
	}
	public List<AccountTransaction> readByTimestamp(Date date) {
		return atr.findByTimestamp(date);
	}
	public void create(AccountTransaction t) {
		atr.saveAndFlush(t);
	}
	public void update(AccountTransaction t) {
		atr.saveAndFlush(t);
	}
	public void delete(int id) {
		atr.deleteById(id);
	}
}
