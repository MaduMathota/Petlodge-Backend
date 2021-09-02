package com.petlodge.caretaker.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.PetType;


public interface PetTypeRepository extends JpaRepository<PetType, String> {


	PetType findByTypename(String id);

}
