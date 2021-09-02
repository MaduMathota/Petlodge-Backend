package com.petlodge.caretaker.service;

import java.util.List;
import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petlodge.caretaker.entity.Food;
import com.petlodge.caretaker.repository.FoodRepository;
import java.io.File;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.util.ResourceUtils;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repository; 
	
	
	////////create/////////////////////////////////
	public Food saveFood(Food food) {
		return repository.save(food);
		
	}
	
	////////get///////////////////////////////////
	public List<Food> getFoods() {
		return repository.findAll();
		
	}
	
	public Food getFoodById(String id) {
		return repository.findById(id).orElse(null);
		
	}
	
	/////////delete//////////////////////////////////
	public String deleteFood(String id) {
		repository.deleteById(id);
		return "delete successfully";
	
	}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	    String path="F:\\project\\ReportFood";
	    List<Food> foods = repository.findAll();
	    File file = ResourceUtils.getFile("classpath:Foods.jrxml");
	    JasperReport jasperrReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(foods);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createBy", "maduRox");
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperrReport, parameters, dataSource);
	    if (reportFormat.equalsIgnoreCase("html")) {

	      JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\foods.html");
	    }
	    if (reportFormat.equalsIgnoreCase("pdf")) {

	      JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\foods.pdf");
	    }
	    return "report genarated in path :"+path;
	  }
	
	////////update//////////////////////////////////
	public Food updateFood(Food food) {
		
		Food exsistingFood = repository.findById(food.getId()).orElse(null);
		
		exsistingFood.setId(food.getId());
		exsistingFood.setName(food.getName());
		exsistingFood.setQuantity(food.getQuantity());
		exsistingFood.setTowhom(food.getTowhom());
		exsistingFood.setType(food.getType());
		
		return repository.save(exsistingFood);
		
	}
	
}
