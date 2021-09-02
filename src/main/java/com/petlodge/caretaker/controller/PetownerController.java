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

import com.petlodge.caretaker.entity.Petowner;
import com.petlodge.caretaker.service.PetownerService;

@RestController
@CrossOrigin(origins = "*")
public class PetownerController {

	@Autowired
	private PetownerService service;
	
	@PostMapping("/addpetowner")
	public Petowner addPetowner(@RequestBody Petowner petowner) throws Exception {
		String tempEid = petowner.getId();
		if(tempEid != null && !"".equals(tempEid)) {
			Petowner existpetowner = service.getPetownerById(tempEid);
			if(existpetowner != null) {
				throw new Exception("Petowner id "+tempEid+" already exisists");
			}
			else {
				return service.savePetowner(petowner);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@GetMapping("/getpetowner")
	public List<Petowner> getPetowners(){
		return service.getPetowners();
	
	}
	
	@GetMapping("/getpetowner/{id}")
	public Petowner getPetowner(@PathVariable String id) {
		return service.getPetownerById(id);
	}
	
	@DeleteMapping("deletepetowner/{id}")
	public String deletePetowner(@PathVariable String id) {
		return service.deletePetowner(id);
	}
	
	@PutMapping("/updatepetowner")
	public Petowner updatePetowner(@RequestBody Petowner petowner) {
		return service.updatePetowner(petowner);
	}
	
}
