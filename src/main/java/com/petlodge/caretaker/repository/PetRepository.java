package com.petlodge.caretaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petlodge.caretaker.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, String>{


}
