package com.mcdonald.models;

import java.util.Date;

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
	@NotNull
	@NotBlank
	@Size(min=10,max=50,message="User name must be between 10 and 50 characters long!")
	String username;
	@NotNull
	@NotBlank
	@Size(min=8,max=25,message="Password must be between 8 and 25 characters long!")
	String password;
	@NotNull
	@NotBlank
	private int age;
	@NotNull
	@NotBlank
	private Date accountCreation;
	@NotNull
	@NotBlank
	private Date dateOfBirth;
	@NotNull
	@NotBlank
	@Size(min=2,max=75)
	private String firstName;
	//as string may be more than one middle name, intials work as well/not required
	@Size(min=1,max=110)
	private String middleName;
	@NotNull
	@NotBlank
	@Size(min=2,max=75)
	private String lastName;
	//string so it can be stored with extentions, parenthesis, dashes, etc
	@NotNull
	@NotBlank
	@Size(min=10,max=20)
	private String mobile;
	//3 letter country code
	@NotNull
	@NotBlank
	@Size(min=3,max=3)
	private String country;
	//state, province, region, etc.
	@NotNull
	@NotBlank
	@Size(min=2,max=75)
	private String region;
	@NotNull
	@NotBlank
	@Size(min=2,max=75)
	private String town;
	//if applicable not required
	@Size(min=5,max=5)
	private String zip;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getAge() {
		return age;
	}
	public Date getAccountCreation() {
		return accountCreation;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public String getCountry() {
		return country;
	}
	public String getRegion() {
		return region;
	}
	public String getTown() {
		return town;
	}
	public String getZip() {
		return zip;
	}
}
