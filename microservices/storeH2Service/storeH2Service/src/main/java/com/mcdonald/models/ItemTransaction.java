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
	private int sellerid;
	@NotNull
	@NotBlank
	private int buyerid;
	@NotNull
	@NotBlank
	private String itemid;
	@NotNull
	@NotBlank
	private String itemname;
	@NotNull
	@NotBlank
	private float amount;
	@NotNull
	@NotBlank
	Date stamp;
	public int getId() {
		return id;
	}
	public int getSellerId() {
		return sellerid;
	}
	public int getBuyerId() {
		return buyerid;
	}
	public String getItemId() {
		return itemid;
	}
	public String getItemName() {
		return itemname;
	}
	public float getAmount() {
		return amount;
	}
	public Date getTimestamp() {
		return stamp;
	}
}
