package com.mcdonald.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcdonald.models.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	@Query("SELECT u FROM Users u WHERE username=?1")
	public Users findByUsername(String username);
	@Query("SELECT u FROM Users u WHERE age=?1")
	public List<Users> findByAge(int i);
	@Query("SELECT u FROM Users u WHERE accountcreation=?1")
	public List<Users> findByCreated(Date date);
	@Query("SELECT u FROM Users u WHERE mobile=?1")
	public Users findByMobile(String mobile);
	@Query("SELECT u FROM Users u WHERE country=?1")
	public List<Users> findByCountry(String country);
	@Query("SELECT u FROM Users u WHERE region=?1")
	public List<Users> findByRegion(String region);
}
