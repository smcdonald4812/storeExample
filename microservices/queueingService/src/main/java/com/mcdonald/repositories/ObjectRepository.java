package com.mcdonald.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ObjectRepository extends JpaRepository<Object, Integer> {
	List<Object> findAll();
	
	@Query("select o from Object o where o.name=?1")
	Object findByName(String name);
	@Query("select o from Object o where o.id=?1")
	Object findById(int id);
}
