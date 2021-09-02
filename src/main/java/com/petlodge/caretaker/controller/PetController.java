package com.petlodge.caretaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petlodge.caretaker.entity.Pet;
import com.petlodge.caretaker.service.PetService;

@RestController
@CrossOrigin(origins = "*")
public class PetController {

	@Autowired
 private PetService petservice;
 
 @PostMapping("/addpet")
 public Pet addPet (@RequestBody Pet pet) throws Exception {
		String tempEid = pet.getPetid();
		if(tempEid != null && !"".equals(tempEid)) {
			Pet existpet = petservice.getPetById(tempEid);
			if(existpet != null) {
				throw new Exception("Pet id "+tempEid+" already exisists");
			}
			else {
			return petservice.savePet(pet);
			}
				
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
			
		}
 
 @GetMapping("/getpet")
 public List<Pet> getPets(){
	 return petservice.getPets();
	
 }
 
 @GetMapping("/getpet/{petid}")
 public Pet getPet(@PathVariable String petid){
	 return petservice.getPetById(petid);
	
 }
 
 
 @DeleteMapping("/deletepet/{petid}")
 public String deletePet(@PathVariable String petid) {
	 return petservice.deletePet(petid);
	 
 }
 
 @PutMapping("/updatepet")
 public Pet updatePet(@RequestBody Pet pet) {
	 return petservice.updatePet(pet);
	 
 }
	
}
