package com.petlodge.caretaker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foodtable")
public class Food {
	
	@Id
	private String id;
	
	private String name;
	
	private String type;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
