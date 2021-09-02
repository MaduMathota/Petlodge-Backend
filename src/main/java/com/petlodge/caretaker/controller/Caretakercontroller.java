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

import com.petlodge.caretaker.dto.CaretakerDTO;
import com.petlodge.caretaker.entity.Caretaker;
import com.petlodge.caretaker.service.Caretakerservice;


@RestController
@CrossOrigin(origins = "*")
public class Caretakercontroller {
	
	@Autowired
	public Caretakerservice service;
	
	@PostMapping("/addcaretaker")
	public Caretaker addCaretaker(@RequestBody Caretaker caretaker) throws Exception{
		String tempEId = caretaker.getCaretakerId();
		if(tempEId != null && !"".equals(tempEId)) {
			Caretaker caretake = service.getCaretakerById(tempEId);
			if(caretake != null) {
				throw new Exception("Caretaker id "+tempEId+" already exists");
			}
			else {
				return service.saveCaretaker(caretaker);
			}
		}
		else {
			throw new Exception("null or empty inserted!check again");
		}
		
	}
	
	@PostMapping("/caretakerlogin")
	public Caretaker caretakerlogin (@RequestBody Caretaker caretaker) throws Exception {
		String userid = caretaker.getCaretakerId();
		String passw = caretaker.getCarePassword();
		Caretaker logCaretaker= null;
		if(userid != null && passw != null) {
			logCaretaker = service.getCaretakerByIdandPassword(userid, passw);
		}
		if(logCaretaker == null) {
			String messageone = "wrong password or Id number! please check again.";
			throw new Exception(messageone);
		}
		return logCaretaker;
	}
	
	
	@GetMapping("/getcaretaker")
	public List<Caretaker> getCaretakers() {
		return service.getCaretakers();
	}
	
	@GetMapping("/getcaretaker/{id}")
	public Caretaker getCaretaker(@PathVariable String id) {
		return service.getCaretakerById(id);
	}
	
	@GetMapping("/getcaretakerdtolist")
	public List<CaretakerDTO> getCaretakerdtolist() {
		return service.getcaretakerlist();
	}
	
	@PutMapping("/updatecaretaker")
	public Caretaker updateCaretaker(@RequestBody Caretaker caretaker) {
		return service.updateCaretaker(caretaker);
	}
	
	@PutMapping("/updatecaretakerpsw")
	public Caretaker updateCaretakerpsw(@RequestBody Caretaker caretaker) {
		return service.updateCaretakerpsw(caretaker);
	}
	
	@DeleteMapping("/deletecaretaker/{id}")
	public String deleteCaretaker(@PathVariable String id) {
		return service.deleteCaretaker(id);
	}
	
}
