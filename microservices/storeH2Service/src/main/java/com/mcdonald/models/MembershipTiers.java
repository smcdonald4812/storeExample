package com.mcdonald.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class MembershipTiers {
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	@NotNull
	private float price;
	@NotBlank
	@NotNull
	private int freeSales;
	@NotBlank
	@NotNull
	private float percentage;
	@NotBlank
	@NotNull
	private TIMELENGTH length;
	@NotNull
	private STATUS status;
	@NotNull
	@NotBlank
	private Date timestamp;
	public int getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	public TIMELENGTH getLength() {
		return length;
	}
	public STATUS getStatus() {
		return status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public int getFreeSales() {
		return freeSales;
	}
	public float getPercentage() {
		return percentage;
	}
}
