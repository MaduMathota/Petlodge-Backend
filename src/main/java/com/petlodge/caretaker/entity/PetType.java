package com.petlodge.caretaker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pettypetable")
public class PetType {
	
	@Id
	private String typeid;
	private String typename;
	
	
	@OneToMany(mappedBy = "pettypes",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<PetBreed> breeds;
	
	@OneToMany(mappedBy = "pettype",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<Pet> pets;
	

	
	
	

	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public List<PetBreed> getBreeds() {
		return breeds;
	}
	public void setBreeds(List<PetBreed> breeds) {
		this.breeds = breeds;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
