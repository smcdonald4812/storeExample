package com.mcdonald.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	@NotNull
	private int userId;
	@NotNull
	private STATUS status;
	@Size(max=250)
	private String imgURL;
	@NotBlank
	@NotNull
	private boolean isActive;
	@NotBlank
	@NotNull
	private Date dateCreated;
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public STATUS getStatus() {
		return status;
	}
	public String getImgURL() {
		return imgURL;
	}
	public boolean isActive() {
		return isActive;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
}
