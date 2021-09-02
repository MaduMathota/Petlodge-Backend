package com.petlodge.caretaker.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.dto.CaretakerDTO;
import com.petlodge.caretaker.entity.Caretaker;
import com.petlodge.caretaker.repository.Caretakerrepository;


@Service
public class Caretakerservice {

	@Autowired
	private Caretakerrepository caretakerrepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/////////post method///////////////////////////////////////////
	public Caretaker saveCaretaker(Caretaker caretaker) {
		
			String encodepassword = passwordEncoder.encode(caretaker.getCarePassword());
			caretaker.setCarePassword(encodepassword);
		
		return caretakerrepository.save(caretaker);
	}
	
	/////////get method///////////////////////////////////////////
	public List<Caretaker> getCaretakers() {
		return caretakerrepository.findAll();
	}
	
	public Caretaker getCaretakerById(String id) {
		return caretakerrepository.findById(id).orElse(null);
	}
	
	public Caretaker getCaretakerByIdandPassword(String caretakerId,String carePassword) {
		
		Caretaker existingCaretaker = null;
		Caretaker chekingCaretaker = caretakerrepository.findById(caretakerId).orElse(null);
		if(chekingCaretaker != null) {
			if(passwordEncoder.matches(carePassword, chekingCaretaker.getCarePassword())) {
				existingCaretaker = chekingCaretaker;
			}
			else {
				existingCaretaker = null;
			}
		}
		return existingCaretaker;
		
	}
	
	/////////delete method////////////////////////////////////////
	public String deleteCaretaker(String id) {
		caretakerrepository.deleteById(id);
		return "succesfully deleted id :"+id;
	}
	
	////////put(update) method///////////////////////////////////
	public Caretaker updateCaretaker(Caretaker caretaker) {
		
		Caretaker existedCaretaker = caretakerrepository.findById(caretaker.getCaretakerId()).orElse(null);
		existedCaretaker.setAddress(caretaker.getAddress());
		existedCaretaker.setCaretakerId(caretaker.getCaretakerId());
		existedCaretaker.setCaretakerName(caretaker.getCaretakerName());
		existedCaretaker.setContactNo(caretaker.getContactNo());
		existedCaretaker.setSalary(caretaker.getSalary());
		
		return caretakerrepository.save(existedCaretaker);
		
	}
	
public Caretaker updateCaretakerpsw(Caretaker caretaker) {
		
		Caretaker existedCaretaker = caretakerrepository.findById(caretaker.getCaretakerId()).orElse(null);

		existedCaretaker.setCarePassword(passwordEncoder.encode(caretaker.getCarePassword()));

		return caretakerrepository.save(existedCaretaker);
		
	}

public List<CaretakerDTO> getcaretakerlist(){
	
	List<Caretaker> caretakers = caretakerrepository.findAll();
	List<CaretakerDTO> careTakerCountList = new ArrayList<CaretakerDTO>();
	
	for (Caretaker caretaker : caretakers) {
		CaretakerDTO newObj = new CaretakerDTO();
		
		newObj.setCaretakerId(caretaker.getCaretakerId());
		newObj.setCaretakername(caretaker.getCaretakerName());
		newObj.setCount(caretaker.getJobs().size());
		
		careTakerCountList.add(newObj);
	}
	
	return careTakerCountList;
}
	
	
	
}
