package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Veterinarian;
import com.petlodge.caretaker.repository.VeterinarianRepository;

@Service
public class VeterinarianService {

	@Autowired
	private VeterinarianRepository repository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	//////// create/////////////////////////////////
	public Veterinarian saveVeterinarian(Veterinarian veterinarian) {

		String encodepassword = passwordEncoder.encode(veterinarian.getPassword());
		veterinarian.setPassword(encodepassword);

		return repository.save(veterinarian);

	}

	//////// get///////////////////////////////////
	public List<Veterinarian> getVeterinarians() {
		return repository.findAll();

	}

	public Veterinarian getVeterinarianById(String id) {
		return repository.findById(id).orElse(null);

	}

	public Veterinarian getVeterinarianByIdAndPassword(String id, String password) {

		Veterinarian existingVeterinarian = null;
		Veterinarian chekingVeterinarian = repository.findById(id).orElse(null);
		if(chekingVeterinarian != null) {
			if(passwordEncoder.matches(password, chekingVeterinarian.getPassword())) {
				existingVeterinarian = chekingVeterinarian;
			}
			else {
				existingVeterinarian = null;
			}
		}
		return existingVeterinarian;

	}
	


	///////// delete//////////////////////////////////
	public String deleteVeterinarian(String id) {
		repository.deleteById(id);
		return "delete successfully";

	}

	//////// update//////////////////////////////////
	public Veterinarian updateVeterinarian(Veterinarian veterinarian) {

		Veterinarian exsistingVeterinarian = repository.findById(veterinarian.getId()).orElse(null);
		exsistingVeterinarian.setId(veterinarian.getId());
		exsistingVeterinarian.setName(veterinarian.getName());
		exsistingVeterinarian.setAddress(veterinarian.getAddress());
		exsistingVeterinarian.setContactno(veterinarian.getContactno());
		exsistingVeterinarian.setEmail(veterinarian.getEmail());
		exsistingVeterinarian.setVCSLregistrationno(veterinarian.getVCSLregistrationno());
		exsistingVeterinarian.setStatus(veterinarian.getStatus());

		return repository.save(exsistingVeterinarian);

	}
	

	public Veterinarian updateVeterinarianPsw(Veterinarian veterinarian) {

		Veterinarian exsistingVeterinarian = repository.findById(veterinarian.getId()).orElse(null);

		exsistingVeterinarian.setPassword(passwordEncoder.encode(veterinarian.getPassword()));

		return repository.save(exsistingVeterinarian);

	}

}
