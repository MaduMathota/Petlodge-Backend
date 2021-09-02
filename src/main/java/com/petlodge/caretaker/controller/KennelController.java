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

import com.petlodge.caretaker.entity.Kennel;
import com.petlodge.caretaker.service.KennelService;

@RestController
@CrossOrigin(origins = "*")
public class KennelController {

	@Autowired
	private KennelService service;
	
	@PostMapping("/addkennel")
	public Kennel addKennel(@RequestBody Kennel kennel) throws Exception {
		String tempEid = kennel.getId();
		if(tempEid != null && !"".equals(tempEid)) {
			Kennel existkennel = service.getKennelById(tempEid);
			if(existkennel != null) {
				throw new Exception("Kennel id "+tempEid+" already exisists");
			}
			else {
				return service.saveKennel(kennel);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@GetMapping("/getkennel")
	public List<Kennel> getKennels(){
		return service.getKennels();
	
	}
	
	@GetMapping("/getkennel/{id}")
	public Kennel getKennel(@PathVariable String id) {
		return service.getKennelById(id);
	}
	
	@DeleteMapping("deletekennel/{id}")
	public String deleteKennel(@PathVariable String id) {
		return service.deleteKennel(id);
	}
	
	@PutMapping("/updatekennel")
	public Kennel updateKennel(@RequestBody Kennel kennel) {
		return service.updateKennel(kennel);
	}
	
}
