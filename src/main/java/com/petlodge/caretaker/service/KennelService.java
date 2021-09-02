package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Kennel;
import com.petlodge.caretaker.repository.KennelRepository;

@Service
public class KennelService {

	@Autowired
	private KennelRepository repository; 
	
	
	////////create/////////////////////////////////
	public Kennel saveKennel(Kennel kennel) {
		return repository.save(kennel);
		
	}
	
	////////get///////////////////////////////////
	public List<Kennel> getKennels() {
		return repository.findAll();
		
	}
	
	public Kennel getKennelById(String id) {
		return repository.findById(id).orElse(null);
		
	}
	
	/////////delete//////////////////////////////////
	public String deleteKennel(String id) {
		repository.deleteById(id);
		return "delete successfully";
	
	}
	
	////////update//////////////////////////////////
	public Kennel updateKennel(Kennel kennel) {
		
		Kennel exsistingKennel = repository.findById(kennel.getId()).orElse(null);
		exsistingKennel.setId(kennel.getId());
		exsistingKennel.setKennelcondition(kennel.getKennelcondition());
		exsistingKennel.setAssignedpet(kennel.getAssignedpet());
		
		return repository.save(exsistingKennel);
		
	}
	
}
