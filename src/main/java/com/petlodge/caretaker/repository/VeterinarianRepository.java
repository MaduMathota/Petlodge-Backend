package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Veterinarian;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, String> {
	Veterinarian findByIdAndPassword(String id,String password);
}
