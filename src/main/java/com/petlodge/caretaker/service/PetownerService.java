package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Petowner;
import com.petlodge.caretaker.repository.PetownerRepository;


@Service
public class PetownerService {

	@Autowired
	private PetownerRepository repository; 
	
	
	////////create/////////////////////////////////
	public Petowner savePetowner(Petowner petowner) {
		return repository.save(petowner);
		
	}
	
	////////get///////////////////////////////////
	public List<Petowner> getPetowners() {
		return repository.findAll();
		
	}
	
	public Petowner getPetownerById(String id) {
		return repository.findById(id).orElse(null);
		
	}
	
	/////////delete//////////////////////////////////
	public String deletePetowner(String id) {
		repository.deleteById(id);
		return "delete successfully";
	
	}
	
	////////update//////////////////////////////////
	public Petowner updatePetowner(Petowner petowner) {
		
		Petowner exsistingVeterinarian = repository.findById(petowner.getId()).orElse(null);
		exsistingVeterinarian.setAddress(petowner.getAddress());
		exsistingVeterinarian.setContactno(petowner.getContactno());
		exsistingVeterinarian.setEmail(petowner.getEmail());
		exsistingVeterinarian.setId(petowner.getId());
		exsistingVeterinarian.setName(petowner.getName());
		exsistingVeterinarian.setPaymentstatus(petowner.getPaymentstatus());
		
	
		
		return repository.save(exsistingVeterinarian);
		
	}

	
}
