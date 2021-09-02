package com.petlodge.caretaker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Veterinarian extends User{
	
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	private String contactno;
	
	private String address;
	
	private String VCSLregistrationno;
	
	private String email;
	
	private String status;
	
	@OneToMany(mappedBy = "veterinarian", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<Appointment> appointments;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVCSLregistrationno() {
		return VCSLregistrationno;
	}

	public void setVCSLregistrationno(String vCSLregistrationno) {
		VCSLregistrationno = vCSLregistrationno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	

}
