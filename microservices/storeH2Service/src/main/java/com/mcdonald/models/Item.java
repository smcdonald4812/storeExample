package com.mcdonald.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {
	@GeneratedValue
	@Id
	int id;
	@NotNull
	@NotBlank
	int sellerId;
	@NotNull
	@NotBlank
	float price;
	@NotNull
	@NotBlank
	@Size(min=5,max=100,message="image url can't be larger than 100 characters")
	String imgUrl;
	@NotNull
	@NotBlank
	@Size(min=5,max=100,message="item can't be larger than 100 characters")
	String itemName;
	@NotNull
	@NotBlank
	@Size(min=50,max=500,message="item description can't be shorter than 50 characters or larger than 500 characters")
	String description;
}
