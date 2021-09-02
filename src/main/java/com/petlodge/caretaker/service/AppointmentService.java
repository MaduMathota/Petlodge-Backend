package com.petlodge.caretaker.service;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Appointment;
import com.petlodge.caretaker.entity.AppointmentPet;
import com.petlodge.caretaker.entity.Veterinarian;
import com.petlodge.caretaker.repository.AppointmentPetRepository;
import com.petlodge.caretaker.repository.AppointmentRepository;
import com.petlodge.caretaker.repository.VeterinarianRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repository;
	
	@Autowired
	private VeterinarianRepository vetrepository;
	
	@Autowired
	private AppointmentPetRepository appointmentPetrepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	public Appointment saveAppointment(Appointment appointment) {
		
		Veterinarian existingVet = vetrepository.findById(appointment.getVetid()).orElse(null);
		appointment.setVeterinarian(existingVet);
		existingVet.getAppointments().add(appointment);
		
		AppointmentPet existingPet = appointmentPetrepository.findById(appointment.getAppointPetid()).orElse(null);
		appointment.setAppointmentPet(existingPet);
		existingPet.setAppointment(appointment);
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("petlodgeservice@gmail.com");
//		message.setTo(existingVet.getEmail());
//		message.setText("You have new Appointment.please check out your petlodge account to get more information about the appointment.thank you!");
//		message.setSubject("New PetLodge Appointment");
//		
//		emailSender.send(message);
		
		return repository.save(appointment);
	}
	
 public List<Appointment> getAppointments() {
		
		return repository.findAll();
	}
 
 public List<Appointment> getAppointmentsByVetId(String vetid) {
		
		return repository.findByVetid(vetid);
	}
 
 public Appointment getAppointmentById(Long id) {
		return repository.findById(id).orElse(null);
		
	}

 
 public String deleteAppointment(Long id) {
	 repository.deleteById(id);
	 return "delete complete";
	 
 }
 
 @Transactional
 public String deleteAppointmentsByVetId(String id) {
	 repository.deleteByVetid(id);
	 return "delete complete";
	 
 }

}
