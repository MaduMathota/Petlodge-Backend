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

import com.petlodge.caretaker.entity.Food;
import com.petlodge.caretaker.service.FoodService;


@RestController
@CrossOrigin(origins = "*")
public class FoodController {

	@Autowired
	private FoodService service;
	
	@PostMapping("/addfood")
	public Food addFood(@RequestBody Food food) throws Exception {
		String tempEid = food.getId();
		if(tempEid != null && !"".equals(tempEid)) {
			Food existfood = service.getFoodById(tempEid);
			if(existfood != null) {
				throw new Exception("Food id "+tempEid+" already exisists");
			}
			else {
				return service.saveFood(food);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@GetMapping("/getfood")
	public List<Food> getFoods(){
		return service.getFoods();
	
	}
	
	@GetMapping("/getfood/{id}")
	public Food getFood(@PathVariable String id) {
		return service.getFoodById(id);
	}
	
	@GetMapping("/Foodreport/{format}")
	  public String genarateReport(@PathVariable String format) throws FileNotFoundException, JarException, JRException {
	    return service.exportReport(format);

	  }
	
	@DeleteMapping("deletefood/{id}")
	public String deleteFood(@PathVariable String id) {
		return service.deleteFood(id);
	}
	
	@PutMapping("/updatefood")
	public Food updateFood(@RequestBody Food food) {
		return service.updateFood(food);
	}
	
	
}
