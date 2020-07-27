package com.mcdonald.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class User {
	@GeneratedValue
	@Id
	int id;
	int sellerId;
	@NotNull
	@NotBlank
	@Size(min=10,max=50,message="User name must be between 10 and 50 characters long!")
	String username;
	@NotNull
	@NotBlank
	@Size(min=8,max=25,message="Password must be between 8 and 25 characters long!")
	String password;
}
