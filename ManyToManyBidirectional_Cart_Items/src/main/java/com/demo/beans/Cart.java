package com.demo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Cart 
{
	@Id
	@GeneratedValue
	private int cartid;
	private String cname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="itemid")
	private List<Items> items;
	
	public Cart() {
		super();
	}

	public Cart(int cartid, String cname, List<Items> items) {
		super();
		this.cartid = cartid;
		this.cname = cname;
		this.items = items;
	}

	public Cart(int cartid, String cname) {
		super();
		this.cartid = cartid;
		this.cname = cname;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", cname=" + cname + ", items=" + items + "]";
	}
	
	
}
