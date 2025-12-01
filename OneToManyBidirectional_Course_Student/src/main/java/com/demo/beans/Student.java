package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students1")
public class Student 
{
	@Id
	private int sid;
	private String sname;
	private int srank;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private Course course;

	public Student() {
		super();
	}

	public Student(int sid, String sname, int srank, Course course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.srank = srank;
		this.course = course;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getRank() {
		return srank;
	}

	public void setRank(int srank) {
		this.srank = srank;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", srank=" + srank + "]";
	}
	
	
}
