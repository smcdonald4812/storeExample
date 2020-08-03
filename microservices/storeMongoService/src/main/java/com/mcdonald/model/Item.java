package com.mcdonald.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
public class Item {
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	@NotNull
	private float price;
	@NotBlank
	@NotNull
	@Size(min=10,max=50,message="Title must be between 10 and 50 characters!")
	private String title;
	@NotBlank
	@NotNull
	@Size(min=3,max=40,message="Type must be between 3 and 40 characters!")
	private String type;
	@NotBlank
	@NotNull
	@Size(min=50,max=500,message="Description must be between 50 and 500 characters!")
	private String description;
	@NotBlank
	@NotNull
	@Size(max=500,message="Image url is more than 500 characters!")
	private String imgURL;
	public Item(String title, String description, float price, String type, String imgURL) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.type = type;
		this.imgURL = imgURL;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", title=" + title + ", type=" + type + ", description="
				+ description + ", imgURL=" + imgURL + "]";
	}
}
