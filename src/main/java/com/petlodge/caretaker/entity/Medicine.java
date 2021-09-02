package com.petlodge.caretaker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicinetable")
public class Medicine {

	@Id
	private String id;
	
	private String name;
	
	private String discription;
	
	private String towhom;
	
	private String quantity;

	
	
	
	
	
	
	
	
	
	
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getTowhom() {
		return towhom;
	}

	public void setTowhom(String towhom) {
		this.towhom = towhom;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
