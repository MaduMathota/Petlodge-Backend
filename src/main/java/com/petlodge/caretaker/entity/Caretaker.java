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
@Table(name="Caretaker")
public class Caretaker extends User {
@Id
@Column(name = "ID",nullable = false)
private String caretakerId;
@Column(name = "Name",nullable = false)
private String caretakerName;
@Column(name = "Salary",nullable = true)
private double salary;
@Column(name = "HomeAddress",nullable = false)
private String address;
@Column(name = "ContactNo",nullable = false)
private String contactNo;
@Column(name = "Password",nullable = false)
private String carePassword;

@OneToMany(mappedBy = "caretaker",cascade = CascadeType.MERGE,fetch = FetchType.LAZY) //used merge.otherwise it not add job to caretaker
private List<Job> jobs;







public String getCaretakerId() {
	return caretakerId;
}
public void setCaretakerId(String caretakerId) {
	this.caretakerId = caretakerId;
}
public String getCaretakerName() {
	return caretakerName;
}
public void setCaretakerName(String caretakerName) {
	this.caretakerName = caretakerName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
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
public String getCarePassword() {
	return carePassword;
}
public void setCarePassword(String carePassword) {
	this.carePassword = carePassword;
}
public List<Job> getJobs() {
	return jobs;
}
public void setJobs(List<Job> jobs) {
	this.jobs = jobs;
}



}
