package com.arkproject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="add_item")
@SecondaryTable(name="available_items")
public class AddItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Item name is compulsory")
	@Column(name = "iname",table="available_items")
	private String iname;
	
	@NotNull(message="Item category name is compulsory")
	@Column(name = "icat",table="available_items")
	private String icat;
	
	@NotNull(message="Item serial nos is compulsory")
	@Column(name = "isn",table="available_items")
	private String isn;
	
	@NotNull(message="Item quantity is compulsory")
	@Column(name = "iqnty",table="available_items")	
	private String iqnty;
	
	@NotNull(message="Item serial nos is compulsory")
	@Column(name = "date")
	private String date;
	

	
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
	@Column(table="available_items")
	public String getIqnty() {
		return iqnty;
	}

	public void setIqnty(String iqnty) {
		this.iqnty = iqnty;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 


	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVadd() {
		return vadd;
	}

	public void setVadd(String vadd) {
		this.vadd = vadd;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getVphone() {
		return vphone;
	}

	public void setVphone(String vphone) {
		this.vphone = vphone;
	}

	public String getRby() {
		return Rby;
	}

	public void setRby(String rby) {
		Rby = rby;
	}

	public AddItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull(message="Vendor name is compulsory")
	@Column(name = "vname")
	private String vname;
	
	@NotNull(message="Vendor address is compulsory")
	@Column(name = "vadd")
	private String vadd;
	
	@NotNull(message="Vendor email is compulsory")
	@Column(name = "vemail")
	private String vemail;
	
	@NotNull(message="Vendor phone  nos is compulsory")
	@Column(name = "vphone")
	private String vphone;
	
	@NotNull(message="Recieved by is compulsory")
	@Column(name = "Rby")
	private String Rby;
	
	
	
	

}