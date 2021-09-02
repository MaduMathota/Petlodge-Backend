package com.petlodge.caretaker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AppointmentPet")
public class AppointmentPet {
	
	@Id
	@GeneratedValue
	@Column(name = "appointmentpetid")
	private Long appointmentpetid;
	
	private String petownercontact;
	private String petname;
	private String petownername;
	private String type;
	private String breed;
	private String medicalhistory;
	private String color;
	private String eyecolor;
	
	@OneToOne(mappedBy = "appointmentPet")
	private Appointment appointment;
	
	
	
	
	
	
	
	
	
	
	
	public Long getAppointmentpetid() {
		return appointmentpetid;
	}
	public void setAppointmentpetid(Long appointmentpetid) {
		this.appointmentpetid = appointmentpetid;
	}
	public String getPetownercontact() {
		return petownercontact;
	}
	public void setPetownercontact(String petownercontact) {
		this.petownercontact = petownercontact;
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
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
}
