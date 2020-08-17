package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.Account;
import com.mcdonald.models.STATUS;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("SELECT a FROM Account a WHERE a.userid=?1")
	public List<Account> findByUserId(int id);
	@Query("SELECT a FROM Account a WHERE a.status=?1")
	public List<Account> findByStatus(STATUS s);
	@Query("SELECT a FROM Account a WHERE a.isactive=?1")
	public List<Account> findByActive(boolean bool);
	@Query("SELECT a FROM Account a WHERE a.datecreated=?1")
	public List<Account> findByTimestamp(Date date);
}
