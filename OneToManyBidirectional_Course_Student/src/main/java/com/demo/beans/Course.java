package com.demo.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses1")
public class Course 
{
	@Id
	private int cid;
	private String cname;
	private String cduration;
	private String startdate;

	@OneToMany(mappedBy = "course")
	List<Student> slist;
	
	
	public Course() {
		super();
	}


	public Course(int cid, String cname, String cduration, String startdate, List<Student> slist) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cduration = cduration;
		this.startdate = startdate;
		this.slist = slist;
	}


	public Course(int cid, String cname, String cduration, String startdate) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cduration = cduration;
		this.startdate = startdate;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCduration() {
		return cduration;
	}


	public void setCduration(String cduration) {
		this.cduration = cduration;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public List<Student> getSlist() {
		return slist;
	}


	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}


	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cduration=" + cduration + ", startdate=" + startdate
				+ ", slist=" + slist + "]";
	}

}
