package com.petlodge.caretaker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "kenneltable")
public class Kennel {
	
	@Id
	@Column(name = "id")
	private String id;
	
	private String kennelcondition;
	
	private String assignedpet;

	@OneToOne(mappedBy = "kennel")
	private Job job;
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKennelcondition() {
		return kennelcondition;
	}

	public void setKennelcondition(String kennelcondition) {
		this.kennelcondition = kennelcondition;
	}

	public String getAssignedpet() {
		return assignedpet;
	}

	public void setAssignedpet(String assignedpet) {
		this.assignedpet = assignedpet;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}


}
