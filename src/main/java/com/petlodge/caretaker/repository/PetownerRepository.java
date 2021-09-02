package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Petowner;

public interface PetownerRepository extends JpaRepository<Petowner, String> {
	
}
