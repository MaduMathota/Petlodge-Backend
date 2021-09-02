package com.petlodge.caretaker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminTable")
public class Admin extends User {
	
	@Id
	@Column(name = "ID",nullable = false)
	private String adminId;
	@Column(name = "Name",nullable = false)
	private String adminName;
	@Column(name = "Password",nullable = false)
	private String password;
	@Column(name = "HomeAdress",nullable = false)
	private String address;
	@Column(name = "ContactNo",nullable = false)
	private String contactNo;
	@Column(name = "Email",nullable = false)
	private String email;
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
