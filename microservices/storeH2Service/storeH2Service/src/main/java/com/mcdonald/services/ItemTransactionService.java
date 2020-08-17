package com.mcdonald.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.models.ItemTransaction;
import com.mcdonald.repositories.ItemTransactionRepository;

@Service
public class ItemTransactionService{
	@Autowired
	ItemTransactionRepository itr;
	public Optional<ItemTransaction> read(int id) {
		return itr.findById(id);
	}
	public List<ItemTransaction> readAll() {
		return itr.findAll();
	}
	public void create(ItemTransaction t) {
		itr.saveAndFlush(t);
	}
	public void update(ItemTransaction t) {
		itr.saveAndFlush(t);
	}
	public void delete(int id) {
		itr.deleteById(id);
	}
	public List<ItemTransaction> readBySellerId(int id) {
		return itr.findBySellerId(id);
	}
	public List<ItemTransaction> readByBuyerId(int id) {
		return itr.findByBuyerId(id);
	}
	public List<ItemTransaction> readByItemId(int id) {
		return itr.findByItemId(id);
	}
	public List<ItemTransaction> readByItemName(String name) {
		return itr.findByItemName(name);
	}
	public List<ItemTransaction> readByTimestamp(Date date) {
		return itr.findByTimestamp(date);
	}
}
