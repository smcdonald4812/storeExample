package com.mcdonald.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Cart implements Serializable{
	private static final long serialVersionUID = 1225188512342339393L;
	@Id
	private String id;
	private String userid;
	private String username;
	private List<Item> itemlist;
	public Cart() {
		super();
	}
	public Cart(String userid, String username, List<Item> itemlist) {
		this();
		this.userid = userid;
		this.username = username;
		this.itemlist = itemlist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public String getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public List<Item> getItemlist() {
		return itemlist;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", username=" + username + ", itemlist=" + itemlist + "]";
	}
}
