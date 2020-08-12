package com.mcdonald;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.mcdonald.model.Item;
import com.mcdonald.repository.ItemStoreRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreNosqlServiceApplication implements CommandLineRunner {

	@Autowired
	private ItemStoreRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StoreNosqlServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		
		// save a couple of items need to do 12 src\imgs\shoes.png
		repository.save(new Item("foots", "These go on your feet...", 59.99f, "shoes", "./imgs/shoes.png", "random CC0 image of shoes"));
		repository.save(new Item("shirt Ts", "A t shirt from shirt Ts!", 14.99f, "shirts", "./imgs/tshirt.png", "random CC0 image of tshirt"));
		repository.save(new Item("some book", "this is for reading", 9.99f, "book", "./imgs/someBook.png", "random CC0 image of a book"));
		repository.save(new Item("cellular phone", "touch it, use it, drop it... oops", 899.99f, "mobile",
				"./imgs/cellphone.png", "random CC0 image of a smart phone"));
		repository.save(new Item("RAM", "get your DDR4's here!", 99.99f, "electronic", "./imgs/ram.png", "random CC0 image of a RAM card"));
		repository.save(new Item("laptop", "computing on the go", 849.99f, "electronic", "./imgs/laptop.png", "random CC0 image of a laptop"));
		repository.save(new Item("lipstick", "this one is red!", 4.99f, "makeup", "./imgs/lipstick.png", "random CC0 image of a lipstick"));
		repository
				.save(new Item("eye liner", "lines the eyes, the black one", 2.99f, "makeup", "./imgs/eyeLiner.png", "random CC0 image of an eye liner"));
		repository.save(new Item("chocolate", "yummy and sweet", 1.99f, "candy", "./imgs/chocolate.png", "random CC0 image of chocolate"));
		repository.save(new Item("balloons", "multicolored! DO NOT USE AS FLOTATION DEVICE!!!", 3.99f, "party",
				"./imgs/balloons.png", "random CC0 image of ballons"));
		repository.save(new Item("plates", "useful for food", 8.99f, "kitchenware", "./imgs/plates.png","random CC0 image of a plate"));
		repository.save(
				new Item("spoons", "coffee or ice cream these do the job!", 2.99f, "kitchenware", "./imgs/spoons.png", "random CC0 image of spoons"));

		// fetch all items
		System.out.println("Items found with findAll():");
		System.out.println("-------------------------------");
		repository.findAll().forEach(x -> {
			x.toString();
			System.out.println(x);
		});
		System.out.println();

	}
}
