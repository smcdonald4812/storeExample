package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {
	@Query("SELECT a FROM AccountTransaction a WHERE accountId=?1")
	public List<AccountTransaction> findByAccountId(int id);
	@Query("SELECT a FROM AccountTransaction a WHERE timestamp=?1")
	public List<AccountTransaction> findByTimestamp(Date date);
}
