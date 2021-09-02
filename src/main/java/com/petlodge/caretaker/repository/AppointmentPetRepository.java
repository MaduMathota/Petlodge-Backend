package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.AppointmentPet;

public interface AppointmentPetRepository extends JpaRepository<AppointmentPet, Long> {

}
