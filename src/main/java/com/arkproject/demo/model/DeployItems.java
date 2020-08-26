package com.arkproject.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="available_items")
public class DeployItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Item name is compulsory")
	@Column(name = "iname")
	private String iname;
	
	@NotNull(message="Item category name is compulsory")
	@Column(name = "icat")
	private String icat;
	
	@NotNull(message="Item serial nos is compulsory")
	@Column(name = "isn")
	private String isn;
	
	@NotNull(message="Item quantity is compulsory")
	@Column(name = "iqntys")
	private String iqntys;
	
	@NotNull(message="Item quantity is compulsory")
	@Column(name = "iqnty")
	private String iqnty;
	
	@NotNull(message="Item quantity is compulsory")
	@Column(name = "iqntyr")
	private String iqntyr;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getIcat() {
		return icat;
	}

	public void setIcat(String icat) {
		this.icat = icat;
	}

	public String getIsn() {
		return isn;
	}

	public void setIsn(String isn) {
		this.isn = isn;
	}

	public String getIqntys() {
		return iqntys;
	}

	public void setIqntys(String iqntys) {
		this.iqntys = iqntys;
	}

	public String getIqnty() {
		return iqnty;
	}

	public void setIqnty(String iqnty) {
		this.iqnty = iqnty;
	}
	
	
	public String getIqntyr() {
		return iqntyr;
	}

	public void setIqntyr(String iqntyr) {
		this.iqntyr = iqntyr;
	}



	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRcvd() {
		return rcvd;
	}

	public void setRcvd(String rcvd) {
		this.rcvd = rcvd;
	}

	public DeployItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@NotNull(message="Date  nos is compulsory")
	@Column(name = "date")
	private String date;
	
	
	@NotNull(message="Department  nos is compulsory")
	@Column(name = "dept")
	private String dept;
	
	@NotNull(message="recieved name is compulsory")
	@Column(name = "rcvd")
	private String rcvd;

	
	
	
	
	

	
}
