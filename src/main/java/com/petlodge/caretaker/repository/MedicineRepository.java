package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

}
