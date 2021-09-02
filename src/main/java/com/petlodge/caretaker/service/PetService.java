package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.petlodge.caretaker.entity.Pet;
import com.petlodge.caretaker.entity.PetType;
import com.petlodge.caretaker.repository.PetRepository;
import com.petlodge.caretaker.repository.PetTypeRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petrepository;
	
	@Autowired
	private PetTypeRepository pettyperepository;

	public Pet savePet(Pet pet) {
		
		PetType existedPetType = pettyperepository.findByTypename(pet.getType());
		pet.setPettype(existedPetType);
		existedPetType.getPets().add(pet);
		
		return petrepository.save(pet);
	}

	public List<Pet> getPets() {

		return petrepository.findAll();
	}

	public Pet getPetById(String id) {
		return petrepository.findById(id).orElse(null);

	}


	public String deletePet(String petid) {
		petrepository.deleteById(petid);
		return "delete complete";

	}

	public Pet updatePet(Pet pet) {

		Pet existingPet = petrepository.findById(pet.getPetid()).orElse(null);

		existingPet.setBreed(pet.getBreed());
		existingPet.setColor(pet.getColor());
		existingPet.setEyecolor(pet.getEyecolor());
		existingPet.setMedicalhistory(pet.getMedicalhistory());
		existingPet.setPersonalnote(pet.getPersonalnote());
		existingPet.setPetid(pet.getPetid());
		existingPet.setPetname(pet.getPetname());
		existingPet.setPetownerid(pet.getPetownerid());
		existingPet.setPetownername(pet.getPetownername());
		existingPet.setSchedule(pet.getSchedule());
		existingPet.setType(pet.getType());

		return petrepository.save(existingPet);
	}

}
