package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE username=?1")
	public User findByUsername(String username);
	@Query("SELECT u FROM User u WHERE age=?1")
	public List<User> findByAge(int i);
	@Query("SELECT u FROM User u WHERE accountCreation=?1")
	public List<User> findByCreated(Date date);
	@Query("SELECT u FROM User u WHERE mobile=?1")
	public User findByMobile(String mobile);
	@Query("SELECT u FROM User u WHERE country=?1")
	public List<User> findByCountry(String country);
	@Query("SELECT u FROM User u WHERE region=?1")
	public List<User> findByRegion(String region);
}
