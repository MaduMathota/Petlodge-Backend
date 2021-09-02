package com.petlodge.caretaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petlodge.caretaker.entity.Appointment;
import com.petlodge.caretaker.service.AppointmentService;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController {
	
	@Autowired
	 private AppointmentService appointmentservice;
	 
	 @PostMapping("/addappointment")
	 public Appointment addAppointment (@RequestBody Appointment appoinment) throws Exception {
		 
		 return appointmentservice.saveAppointment(appoinment);
//			Long tempEid = appoinment.getId();
//			if(tempEid != null && !"".equals(tempEid)) {
//				Appointment existappoinment = appointmentservice.getAppointmentById(tempEid);
//				if(existappoinment != null) {
//					throw new Exception("Appointment id "+tempEid+" already exisists");
//				}
//				else {
//				return appointmentservice.saveAppointment(appoinment);
//				}
//					
//				}
//			else {
//				throw new Exception("null or empty insert.check again");
//			}
				
			}
	 
	 @GetMapping("/getappointment")
	 public List<Appointment> getAppointments(){
		 return appointmentservice.getAppointments();
		
	 }
	 
	 @GetMapping("/getappointment/{id}")
	 public Appointment getAppointmentPet(@PathVariable Long id){
		 return appointmentservice.getAppointmentById(id);
		
	 }
	 
	 @GetMapping("/getappointmentbyvetid/{vetid}")
	 public List<Appointment> getAppointmentByVetid(@PathVariable String vetid){
		 return appointmentservice.getAppointmentsByVetId(vetid);
	 }
	 
	 @DeleteMapping("/deleteappointment/{id}")
	 public String deleteAppointment(@PathVariable Long id) {
		 return appointmentservice.deleteAppointment(id);
		 
	 }
	 
	 @DeleteMapping("/deleteappointmentbyvetid/{id}")
	 public String deleteAppointment(@PathVariable String id) {
		 return appointmentservice.deleteAppointmentsByVetId(id);
		 
	 }

}
