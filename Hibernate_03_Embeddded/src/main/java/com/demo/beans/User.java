package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user3_a")
public class User 
{
	@Id
	@GeneratedValue
	private int uid;
	private String uname;
	private String email;
	
	@Embedded
	private Address addr;
	
	
	public User() {
		super();
	}


	public User(int uid, String uname, String email, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.addr = addr;
	}


	public User(String uname, String email, Address addr) {
		super();
		this.uname = uname;
		this.email = email;
		this.addr = addr;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Address getAddr() {
		return addr;
	}


	public void setAddr(Address addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email + ", addr=" + addr + "]";
	}
	
	
	
}
