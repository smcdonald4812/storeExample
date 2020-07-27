package com.mcdonald.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
	@GeneratedValue
	@Id
	int id;
	@NotNull
	@NotBlank
	int sellerId;
	@NotNull
	@NotBlank
	int buyerId;
	@NotNull
	@NotBlank
	int itemId;
	@NotNull
	@NotBlank
	String itemName;
	@GeneratedValue
	@NotNull
	@NotBlank
	Date timestamp;
}
