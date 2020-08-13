package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcdonald.models.AccountTransaction;
import com.mcdonald.repositories.AccountTransactionRepository;

public class AccountTransactionService implements Service<AccountTransaction>{
	@Autowired
	AccountTransactionRepository atr;
	@Override
	public Optional<AccountTransaction> read(int id) {
		return atr.findById(id);
	}
	@Override
	public List<AccountTransaction> readAll() {
		return atr.findAll();
	}
	public List<AccountTransaction> readByAccountId(int id) {
		return atr.findByAccountId(id);
	}
	public List<AccountTransaction> readByTimestamp(Date date) {
		return atr.findByTimestamp(date);
	}
	@Override
	public void create(AccountTransaction t) {
		atr.saveAndFlush(t);
	}
	@Override
	public void update(AccountTransaction t) {
		atr.saveAndFlush(t);
	}
	@Override
	public void delete(int id) {
		atr.deleteById(id);
	}
}
