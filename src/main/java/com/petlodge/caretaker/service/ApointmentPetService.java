package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.AppointmentPet;
import com.petlodge.caretaker.repository.AppointmentPetRepository;

@Service
public class ApointmentPetService {
	
	@Autowired
	private AppointmentPetRepository petrepository;
	
	
	public AppointmentPet saveAppointmentPet(AppointmentPet pet) {
		
		return petrepository.save(pet);
	}
	

	
 public List<AppointmentPet> getAppointmentPets() {
		
		return petrepository.findAll();
	}

 
 public AppointmentPet getAppointmentPetById(Long id) {
		return petrepository.findById(id).orElse(null);
		
	}

 
 public String deleteAppointmentPet(Long petid) {
	 petrepository.deleteById(petid);
	 return "delete complete";
	 
 }
 
 //update
 public AppointmentPet updateAppointmentPet(AppointmentPet pet) {
	 
	 AppointmentPet existingPet = petrepository.findById(pet.getAppointmentpetid()).orElse(null);
	 
	 existingPet.setAppointmentpetid(pet.getAppointmentpetid());
	 existingPet.setBreed(pet.getBreed());
	 existingPet.setColor(pet.getColor());
	 existingPet.setEyecolor(pet.getEyecolor());
	 existingPet.setMedicalhistory(pet.getMedicalhistory());
	 existingPet.setPetname(pet.getPetname());
	 existingPet.setPetownercontact(pet.getPetownercontact());
	 existingPet.setPetownername(pet.getPetownername());
	 existingPet.setType(pet.getType());
	 existingPet.setAppointment(pet.getAppointment());
	 
	 return petrepository.save(existingPet);
 }
 
	

}
