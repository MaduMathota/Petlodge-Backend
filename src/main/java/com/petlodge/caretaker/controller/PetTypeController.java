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


import com.petlodge.caretaker.entity.PetType;
import com.petlodge.caretaker.service.PetTypeService;

@RestController
@CrossOrigin(origins = "*")
public class PetTypeController {

	@Autowired
 private PetTypeService typeservice;
	
	 @PostMapping("/addtype")
	 public PetType addPetttype (@RequestBody PetType pettype) throws Exception {
			String tempEid = pettype.getTypeid();
			if(tempEid != null && !"".equals(tempEid)) {
				PetType existpet = typeservice.getPetTypeById(tempEid);
				if(existpet != null) {
					throw new Exception("PetType id "+tempEid+" already exisists");
				}
				else {
				return typeservice.savePetType(pettype);
				}
					
				}
			else {
				throw new Exception("null or empty insert.check again");
			}
				
			}
	 
	 @GetMapping("/gettype")
	 public List<PetType> getPetTypes(){
		 return typeservice.getPetTypes();
		
	 }
	 
	 @GetMapping("/getpettype/{pettypeid}")
	 public PetType getPetType(@PathVariable String pettypeid){
		 return typeservice.getPetTypeById(pettypeid);
		
	 }

	 
	 @DeleteMapping("/deletepettype/{petid}")
	 public String deleteType(@PathVariable String pettypeid) {
		 return typeservice.deleteType(pettypeid);
		 
	 }
	 
	
	
}
