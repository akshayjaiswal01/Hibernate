package com.demo.beans;

import java.util.List;

public class Items 
{
	private int itemid;
	private String iname;
	private double price;
	private List<Cart> carts;
	
	public Items() {
		super();
	}

	public Items(int itemid, String iname, double price, List<Cart> carts) {
		super();
		this.itemid = itemid;
		this.iname = iname;
		this.price = price;
		this.carts = carts;
	}

	public Items(int itemid, String iname, double price) {
		super();
		this.itemid = itemid;
		this.iname = iname;
		this.price = price;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", iname=" + iname + ", price=" + price + ", carts=" + carts + "]";
	}
	
	
	
}
