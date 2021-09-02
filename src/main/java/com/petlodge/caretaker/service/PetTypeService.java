package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.PetBreed;
import com.petlodge.caretaker.entity.PetType;
import com.petlodge.caretaker.entity.Seller;
import com.petlodge.caretaker.repository.PetBreedRepository;
import com.petlodge.caretaker.repository.PetTypeRepository;



@Service
public class PetTypeService {

	@Autowired
	private PetTypeRepository typerepository; 
		
	
	////////create/////////////////////////////////
	public PetType savePetType(PetType pettype) {
		
		
		return typerepository.save(pettype);
		
	}
	
	////////get///////////////////////////////////
	public List<PetType> getPetTypes() {
		return typerepository.findAll();
		
	}
	
	public PetType getPetTypeById(String id) {
		return typerepository.findById(id).orElse(null);
		
	}
	
	public String deleteType(String pettypeid) {
		typerepository.deleteById(pettypeid);
		return "delete successfully";

	}

	
}
