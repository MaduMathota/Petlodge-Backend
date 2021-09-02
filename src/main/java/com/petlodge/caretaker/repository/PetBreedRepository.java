package com.petlodge.caretaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.PetBreed;


public interface PetBreedRepository extends JpaRepository<PetBreed, String> {
	
	List<PetBreed> findByType(String type);
	

}
