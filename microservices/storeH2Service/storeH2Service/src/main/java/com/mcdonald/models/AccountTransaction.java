package com.mcdonald.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class AccountTransaction {
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	@NotNull
	private int accountid;
	@NotBlank
	@NotNull
	private float price;
	@NotBlank
	@NotNull
	private float paid;
	@NotBlank
	@NotNull
	private Date stamp;
	public int getId() {
		return id;
	}
	public int getAccountId() {
		return accountid;
	}
	public float getPrice() {
		return price;
	}
	public float getPaid() {
		return paid;
	}
	public Date getTimestamp() {
		return stamp;
	}
}
