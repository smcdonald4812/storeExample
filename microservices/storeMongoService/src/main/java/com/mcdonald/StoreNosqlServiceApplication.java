package com.mcdonald;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.mcdonald.model.Item;
import com.mcdonald.repository.ItemRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreNosqlServiceApplication implements CommandLineRunner{
	
	@Autowired
	private ItemRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreNosqlServiceApplication.class, args);
	}
	
	@Override
	  public void run(String... args) throws Exception {

	    repository.deleteAll();

	    // save a couple of items need to do 12
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));
	    repository.save(new Item("title", "description", 14.99f, "type", "imgURL"));

	    // fetch all items
	    System.out.println("Items found with findAll():");
	    System.out.println("-------------------------------");
	    repository.getAll().forEach(x -> {x.toString(); System.out.println(x);});
	    System.out.println();

	    

	  }
}
