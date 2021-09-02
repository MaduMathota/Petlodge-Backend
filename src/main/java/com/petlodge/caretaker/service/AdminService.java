package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Admin;
import com.petlodge.caretaker.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminrepository; 
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	////////create/////////////////////////////////
	public Admin saveAdmin(Admin admin) {
		
		String encodepassword = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(encodepassword);
		
		return adminrepository.save(admin);
		
	}
	
	////////get///////////////////////////////////
	public List<Admin> getAdmins() {
		return adminrepository.findAll();
		
	}
	
	public Admin getAdminByAdminId(String id) {
		return adminrepository.findById(id).orElse(null);
		
	}
	
	public Admin getAdminByIdAndPassword(String adminid,String password) {
		
		Admin existingAdmin = null;
		Admin chekingAdmin = adminrepository.findById(adminid).orElse(null);
		if(chekingAdmin != null) {
			if(passwordEncoder.matches(password, chekingAdmin.getPassword())) {
				existingAdmin = chekingAdmin;
			}
			else {
				existingAdmin = null;
			}
		}
		return existingAdmin;
		
	}
	
	/////////delete//////////////////////////////////
	public String deleteAdmin(String adminid) {
		adminrepository.deleteById(adminid);
		return "delete successfully";
	
	}
	
	////////update//////////////////////////////////
	public Admin updateAdmin(Admin admin) {
		
		Admin exsistingAdmin = adminrepository.findById(admin.getAdminId()).orElse(null);
		
		exsistingAdmin.setAddress(admin.getAddress());
		exsistingAdmin.setAdminId(admin.getAdminId());
		exsistingAdmin.setAdminName(admin.getAdminName());
		exsistingAdmin.setContactNo(admin.getContactNo());
		exsistingAdmin.setEmail(admin.getEmail());
		exsistingAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));
		
		return adminrepository.save(exsistingAdmin);
		
	}
	
	
	

}
