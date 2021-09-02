package com.petlodge.caretaker.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.PetBreed;
import com.petlodge.caretaker.entity.PetType;
import com.petlodge.caretaker.repository.PetBreedRepository;
import com.petlodge.caretaker.repository.PetTypeRepository;




@Service
public class PetBreedService {

	
	@Autowired
	private PetBreedRepository repository;
	
	@Autowired
	private PetTypeRepository pettypeRepository;
	
	
////////create/////////////////////////////////
public PetBreed savePetBreed(PetBreed petbreed) {
	PetType pettypenew = pettypeRepository.findByTypename(petbreed.getType());
	petbreed.setPettypes(pettypenew);
	pettypenew.getBreeds().add(petbreed);
	
	return repository.save(petbreed);
	
}

////////get///////////////////////////////////
public List<PetBreed> getPetBreeds() {
	return repository.findAll();
	
}

public PetBreed getPetBreedById(String id) {
	return repository.findById(id).orElse(null);
	
}

public List<PetBreed> getPetBreedByType(String type) {
	return repository.findByType(type);
	
}

public String deletebreed(String petbreedid) {
	repository.deleteById(petbreedid);
	return "delete successfully";

}
	
}
