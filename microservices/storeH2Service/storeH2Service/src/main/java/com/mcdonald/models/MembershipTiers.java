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
	private int freesales;
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
	private Date stamp;
	public MembershipTiers() {
		super();
	}
	public MembershipTiers(@NotBlank @NotNull float price, @NotBlank @NotNull int freeSales,
			@NotBlank @NotNull float percentage, @NotBlank @NotNull TIMELENGTH length, @NotNull STATUS status,
			@NotNull @NotBlank Date timestamp) {
		this();
		this.price = price;
		this.freesales = freeSales;
		this.percentage = percentage;
		this.length = length;
		this.status = status;
		this.stamp = timestamp;
	}

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
		return stamp;
	}
	public int getFreeSales() {
		return freesales;
	}
	public float getPercentage() {
		return percentage;
	}
}
