package com.petlodge.caretaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petlodge.caretaker.entity.PetBreed;

import com.petlodge.caretaker.service.PetBreedService;


@RestController
@CrossOrigin(origins = "*")
public class PetBreedController {


		@Autowired
	 private PetBreedService breedservice;
		
		 @PostMapping("/addbreed")
		 public PetBreed addPettbreed (@RequestBody PetBreed petbreed) throws Exception {
				String tempEid = petbreed.getId();
				if(tempEid != null && !"".equals(tempEid)) {
					PetBreed existpet = breedservice.getPetBreedById(tempEid);
					if(existpet != null) {
						throw new Exception("PetBreed id "+tempEid+" already exisists");
					}
					else {
					return breedservice.savePetBreed(petbreed);
					}
						
					}
				else {
					throw new Exception("null or empty insert.check again");
				}
					
				}
		 
		 @GetMapping("/getbreed")
		 public List<PetBreed> getPetBreeds(){
			 return breedservice.getPetBreeds();
			
		 }
		 
		 @GetMapping("/getpetbreed/{petbreedtype}")
		 public List<PetBreed> getPetBreed(@PathVariable String petbreedtype){
			 return breedservice.getPetBreedByType(petbreedtype);
			
		 }
		 
		 @GetMapping("/getpetbreedbyid/{petid}")
		 public PetBreed getPetBreedById(@PathVariable String petid){
			 return breedservice.getPetBreedById(petid);
			
		 }

		 
		 @DeleteMapping("/deletepetbreed/{petid}")
		 public String deleteBreed(@PathVariable String petid) {
			 return breedservice.deletebreed(petid);
			 
		 }
	
}
