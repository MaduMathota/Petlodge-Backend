package com.petlodge.caretaker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	private String date;
	
	private String time;
	
	private String vetid;
	
	private Long appointpetid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointmentid", referencedColumnName = "appointmentpetid")
	@JsonIgnore
	private AppointmentPet appointmentPet;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Veterinarian veterinarian;
	
	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public AppointmentPet getAppointmentPet() {
		return appointmentPet;
	}

	public void setAppointmentPet(AppointmentPet appointmentPet) {
		this.appointmentPet = appointmentPet;
	}

	public String getVetid() {
		return vetid;
	}

	public void setVetid(String vetid) {
		this.vetid = vetid;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}

	public Long getAppointPetid() {
		return appointpetid;
	}

	public void setAppointPetid(Long appointpetid) {
		this.appointpetid = appointpetid;
	}
	
}
