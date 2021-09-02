package com.petlodge.caretaker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	private String startDate;
	
	private String endDate;
	
	private String caretakersId;
	
	private String petid;
	
	private String kennelid;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "knlid",referencedColumnName = "id")
	@JsonIgnore
	private Kennel kennel;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Caretaker caretaker;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCaretakersId() {
		return caretakersId;
	}

	public void setCaretakersId(String caretakersId) {
		this.caretakersId = caretakersId;
	}

	public String getPetid() {
		return petid;
	}

	public void setPetid(String petid) {
		this.petid = petid;
	}

	public String getKennelid() {
		return kennelid;
	}

	public void setKennelid(String kennelid) {
		this.kennelid = kennelid;
	}

	 public Kennel getKennel() {
		return kennel;
	}

	public void setKennel(Kennel kennel) {
		this.kennel = kennel;
	} 

	public Caretaker getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}
	
}
