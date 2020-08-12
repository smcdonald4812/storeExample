package com.mcdonald.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Item implements Serializable{
	private static final long serialVersionUID = -5609891497513783329L;
	@Id
	private String id;
	private float price;
	private String title;
	private String type;
	private String description;
	private String imgURL;
	private String altText;
	public Item(String title, String description, float price, String type, String imgURL, String altText) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.type = type;
		this.imgURL = imgURL;
		this.altText = altText;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getImgURL() {
		return imgURL;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", title=" + title + ", type=" + type + ", description="
				+ description + ", imgURL=" + imgURL + "]";
	}
	public String getAltText() {
		return altText;
	}
}
