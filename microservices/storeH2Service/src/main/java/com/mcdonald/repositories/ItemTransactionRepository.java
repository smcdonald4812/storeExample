package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.ItemTransaction;

public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Integer> {
	@Query("SELECT a FROM ItemTransaction a WHERE sellerId=?1")
	public List<ItemTransaction> findBySellerId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE buyerId=?1")
	public List<ItemTransaction> findByBuyerId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE itemId=?1")
	public List<ItemTransaction> findByItemId(int id);
	@Query("SELECT a FROM ItemTransaction a WHERE itemName=?1")
	public List<ItemTransaction> findByItemName(String name);
	@Query("SELECT a FROM ItemTransaction a WHERE timestamp=?1")
	public List<ItemTransaction> findByTimestamp(Date date);
}
