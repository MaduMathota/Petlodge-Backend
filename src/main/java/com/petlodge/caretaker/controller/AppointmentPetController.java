package com.petlodge.caretaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petlodge.caretaker.entity.AppointmentPet;
import com.petlodge.caretaker.service.ApointmentPetService;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentPetController {

@Autowired
 private ApointmentPetService petservice;
 
 @PostMapping("/addappointmentpet")
 public AppointmentPet addPet (@RequestBody AppointmentPet pet) throws Exception {
	 
	 return petservice.saveAppointmentPet(pet);
//		Long tempEid = pet.getAppointmentpetid();
//		if(tempEid != null && !"".equals(tempEid)) {
//			AppointmentPet existpet = petservice.getAppointmentPetById(tempEid);
//			if(existpet != null) {
//				throw new Exception("AppointmentPet id "+tempEid+" already exisists");
//			}
//			else {
//			return petservice.saveAppointmentPet(pet);
//			}
//				
//			}
//		else {
//			throw new Exception("null or empty insert.check again");
//		}
			
		}
 
 @GetMapping("/getappointmentpet")
 public List<AppointmentPet> getAppointmentPets(){
	 return petservice.getAppointmentPets();
	
 }
 
 @GetMapping("/getappointmentpet/{petid}")
 public AppointmentPet getAppointmentPet(@PathVariable Long petid){
	 return petservice.getAppointmentPetById(petid);
	
 }
 
 @DeleteMapping("/deleteappointmentpet/{petid}")
 public String deletePet(@PathVariable Long petid) {
	 return petservice.deleteAppointmentPet(petid);
	 
 }
 
 @PutMapping("/updateappointmentpet")
 public AppointmentPet updateAppointmentPet(@RequestBody AppointmentPet pet) {
	 return petservice.updateAppointmentPet(pet);
	 
 }
	
}
