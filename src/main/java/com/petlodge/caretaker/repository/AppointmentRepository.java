package com.petlodge.caretaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByVetid(String vetid);
	
	void deleteByVetid(String vetid);
	
}
