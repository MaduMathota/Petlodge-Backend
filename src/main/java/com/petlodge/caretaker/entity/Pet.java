package com.petlodge.caretaker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Pettable")
public class Pet {
@Id
private String petid;
private String petownerid;
private String petname;
private String petownername;
private String type;
private String breed;
private String medicalhistory;
private String schedule;
private String personalnote;
private String color;
private String eyecolor;

@ManyToOne
@JoinColumn(name = "typeid")
@JsonIgnore
private PetType pettype;

public String getPetid() {
	return petid;
}
public void setPetid(String petid) {
	this.petid = petid;
}
public String getPetownerid() {
	return petownerid;
}
public void setPetownerid(String petownerid) {
	this.petownerid = petownerid;
}
public String getPetname() {
	return petname;
}
public void setPetname(String petname) {
	this.petname = petname;
}
public String getPetownername() {
	return petownername;
}
public void setPetownername(String petownername) {
	this.petownername = petownername;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public String getMedicalhistory() {
	return medicalhistory;
}
public void setMedicalhistory(String medicalhistory) {
	this.medicalhistory = medicalhistory;
}
public String getSchedule() {
	return schedule;
}
public void setSchedule(String schedule) {
	this.schedule = schedule;
}
public String getPersonalnote() {
	return personalnote;
}
public void setPersonalnote(String personalnote) {
	this.personalnote = personalnote;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getEyecolor() {
	return eyecolor;
}
public void setEyecolor(String eyecolor) {
	this.eyecolor = eyecolor;
}
public PetType getPettype() {
	return pettype;
}
public void setPettype(PetType pettype) {
	this.pettype = pettype;
}


}
