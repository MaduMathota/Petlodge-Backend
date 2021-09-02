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

import com.petlodge.caretaker.entity.Veterinarian;

import com.petlodge.caretaker.service.VeterinarianService;

@RestController
@CrossOrigin(origins = "*")
public class VeterinarianController {
	
	@Autowired
	private VeterinarianService service;
	
	@PostMapping("/addveterinarian")
	public Veterinarian addveterinarian(@RequestBody Veterinarian veterinarian) throws Exception {
		String tempEid = veterinarian.getId();
		if(tempEid != null && !"".equals(tempEid)) {
			Veterinarian existveterinarian = service.getVeterinarianById(tempEid);
			if(existveterinarian != null) {
				throw new Exception("Veterinarian id "+tempEid+" already exisists");
			}
			else {
				return service.saveVeterinarian(veterinarian);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@PostMapping("/veterinarianlogin")
	public Veterinarian veterinarianlogin (@RequestBody Veterinarian veterinarian) throws Exception {
		String userid = veterinarian.getId();
		String passw = veterinarian.getPassword();
		Veterinarian logveterinarian = null;
		if(userid != null && passw != null) {
			logveterinarian = service.getVeterinarianByIdAndPassword(userid, passw);
		}
		if(logveterinarian == null) {
			String messageone = "wrong password or Id number! please check again them.";
			throw new Exception(messageone);
		}
		return logveterinarian;
	}
	
	@GetMapping("/getveterinarian")
	public List<Veterinarian> getveterinarians(){
		return service.getVeterinarians();
	
	}
	
	@GetMapping("/getveterinarian/{id}")
	public Veterinarian getveterinarian(@PathVariable String id) {
		return service.getVeterinarianById(id);
	}
	
	@DeleteMapping("deleteveterinarian/{id}")
	public String deleteveterinarian(@PathVariable String id) {
		return service.deleteVeterinarian(id);
	}
	
	@PutMapping("/updateveterinarian")
	public Veterinarian updateveterinarian(@RequestBody Veterinarian veterinarian) {
		return service.updateVeterinarian(veterinarian);
	}
	
	@PutMapping("/updateveterinarianpsw")
	public Veterinarian updateveterinarianpsw(@RequestBody Veterinarian veterinarian) {
		return service.updateVeterinarianPsw(veterinarian);
	}
	
	

}
