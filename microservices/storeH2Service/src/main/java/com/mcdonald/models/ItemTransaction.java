package com.mcdonald.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ItemTransaction {
	@GeneratedValue
	@Id
	private int id;
	@NotNull
	@NotBlank
	private int sellerId;
	@NotNull
	@NotBlank
	private int buyerId;
	@NotNull
	@NotBlank
	private String itemId;
	@NotNull
	@NotBlank
	private String itemName;
	@NotNull
	@NotBlank
	private float amount;
	@GeneratedValue
	@NotNull
	@NotBlank
	Date timestamp;
	public int getId() {
		return id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public String getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public float getAmount() {
		return amount;
	}
	public Date getTimestamp() {
		return timestamp;
	}
}
