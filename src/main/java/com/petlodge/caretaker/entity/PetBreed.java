package com.petlodge.caretaker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="Petbreedtable")
	public class PetBreed { 
		
		@Id
		private String id;
		private String breedname;
		private String type;
		@Lob
		private String description;
		
		@ManyToOne
		@JoinColumn(name = "pettypeid")
		@JsonIgnore
		private PetType pettypes;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getBreedname() {
			return breedname;
		}

		public void setBreedname(String breedname) {
			this.breedname = breedname;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public PetType getPettypes() {
			return pettypes;
		}

		public void setPettypes(PetType pettypes) {
			this.pettypes = pettypes;
		}

		

	

		
		
		
}		
