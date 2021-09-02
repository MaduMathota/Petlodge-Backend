package com.petlodge.caretaker.controller;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.jar.JarException;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.petlodge.caretaker.entity.Medicine;
import com.petlodge.caretaker.service.MedicineService;

@RestController
@CrossOrigin(origins = "*")
public class MedicineController {


	@Autowired
	private MedicineService service;
	
	@PostMapping("/addmedicine")
	public Medicine addMedicine(@RequestBody Medicine medicine) throws Exception {
		String tempEid = medicine.getId();
		if(tempEid != null && !"".equals(tempEid)) {
			Medicine existmedicine = service.getMedicineById(tempEid);
			if(existmedicine != null) {
				throw new Exception("Medicine id "+tempEid+" already exisists");
			}
			else {
				return service.saveMedicine(medicine);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@GetMapping("/getmedicine")
	public List<Medicine> getMedicines(){
		return service.getMedicines();
	
	}
	
	@GetMapping("/getmedicine/{id}")
	public Medicine getMedicine(@PathVariable String id) {
		return service.getMedicineById(id);
	}
	
	@GetMapping("/MedicineReport/{format}")
	  public String genarateReport(@PathVariable String format) throws FileNotFoundException, JarException, JRException {
	    return service.exportReport(format);

	  }
	
	@DeleteMapping("deletemedicine/{id}")
	public String deleteMedicine(@PathVariable String id) {
		return service.deleteMedicine(id);
	}
	
	@PutMapping("/updatemedicine")
	public Medicine updateMedicine(@RequestBody Medicine food) {
		return service.updateMedicine(food);
	}
	
}
