package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Medicine;
import com.petlodge.caretaker.repository.MedicineRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.petlodge.caretaker.entity.Food;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;




import org.springframework.util.ResourceUtils;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository repository; 
	
	
	////////create/////////////////////////////////
	public Medicine saveMedicine(Medicine medicine) {
		return repository.save(medicine);
		
	}
	
	////////get///////////////////////////////////
	public List<Medicine> getMedicines() {
		return repository.findAll();
		
	}
	
	public Medicine getMedicineById(String id) {
		return repository.findById(id).orElse(null);
		
	}
	
	/////////delete//////////////////////////////////
	public String deleteMedicine(String id) {
		repository.deleteById(id);
		return "delete successfully";
	
	}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	    String path="F:\\project\\ReportMedicine";
	    List<Medicine> Medicines = repository.findAll();
	    File file = ResourceUtils.getFile("classpath:Medicine.jrxml");
	    JasperReport jasperrReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Medicines);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createBy", "maduRox");
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperrReport, parameters, dataSource);
	    if (reportFormat.equalsIgnoreCase("html")) {

	      JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\Medicines.html");
	    }
	    if (reportFormat.equalsIgnoreCase("pdf")) {

	      JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\Medicines.pdf");
	    }
	    return "report genarated in path :"+path;
	  }
	
	////////update//////////////////////////////////
	public Medicine updateMedicine(Medicine medicine) {
		
		Medicine exsistingMedicine = repository.findById(medicine.getId()).orElse(null);
		exsistingMedicine.setDiscription(medicine.getDiscription());
		exsistingMedicine.setId(medicine.getId());
		exsistingMedicine.setName(medicine.getName());
		exsistingMedicine.setQuantity(medicine.getQuantity());
		exsistingMedicine.setTowhom(medicine.getTowhom());
		
		return repository.save(exsistingMedicine);
		
	}
	
}
