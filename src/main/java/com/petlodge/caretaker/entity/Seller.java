package com.petlodge.caretaker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "SellerTable")
public class Seller extends User {

	@Id
	@Column(name = "ID")
	private String sellerId;
	
	@Column(name = "Name")
	private String sellerName;
	
	@Column(name = "Address")
	private String sellerAddress;
	
	@Column(name = "ContactNo")
	private String sellerContactNo;
	
	@Column(name = "Email")
	private String sellerEmail;
	
	@Column(name = "Password")
	private String sellerPassword;
	
	@Column(name = "Status")
	private String sellerStatus;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.MERGE,fetch = FetchType.LAZY) //used merge.otherwise it not add job to caretaker
	private List<Item> items;
	
	
	
	public Seller() {}
	
	public Seller(String sellerId, String sellerName, String sellerAddress, String sellerContactNo, String sellerEmail,
			String sellerPassword, String sellerStatus) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerContactNo = sellerContactNo;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
		this.sellerStatus = sellerStatus;
	}
	//getter and setter
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getSellerContactNo() {
		return sellerContactNo;
	}
	public void setSellerContactNo(String sellerContactNo) {
		this.sellerContactNo = sellerContactNo;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	public String getSellerStatus() {
		return sellerStatus;
	}
	public void setSellerStatus(String sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}

