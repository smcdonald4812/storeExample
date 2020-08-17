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
	private int userid;
	@NotNull
	private STATUS status;
	@Size(max=250)
	private String imgurl;
	@NotBlank
	@NotNull
	private boolean isactive;
	@NotBlank
	@NotNull
	private Date datecreated;
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userid;
	}
	public STATUS getStatus() {
		return status;
	}
	public String getImgURL() {
		return imgurl;
	}
	public boolean isActive() {
		return isactive;
	}
	public Date getDateCreated() {
		return datecreated;
	}
}
