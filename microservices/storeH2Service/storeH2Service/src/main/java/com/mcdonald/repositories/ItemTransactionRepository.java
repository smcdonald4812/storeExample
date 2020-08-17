package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.ItemTransaction;

public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Integer> {
	@Query("SELECT a FROM ItemTransaction a WHERE sellerid=?1")
	public List<ItemTransaction> findBySellerId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE buyerid=?1")
	public List<ItemTransaction> findByBuyerId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE itemid=?1")
	public List<ItemTransaction> findByItemId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE itemname=?1")
	public List<ItemTransaction> findByItemName(String name);
	@Query("SELECT a FROM ItemTransaction a WHERE stamp=?1")
	public List<ItemTransaction> findByTimestamp(Date date);
}
