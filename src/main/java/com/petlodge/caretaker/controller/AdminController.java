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

import com.petlodge.caretaker.entity.Admin;
import com.petlodge.caretaker.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody Admin admin) throws Exception {
		String tempEid = admin.getAdminId();
		if(tempEid != null && !"".equals(tempEid)) {
			Admin existadmin = adminService.getAdminByAdminId(tempEid);
			if(existadmin != null) {
				throw new Exception("Admin id "+tempEid+" already exisists");
			}
			else {
				return adminService.saveAdmin(admin);
			}
			
			}
		else {
			throw new Exception("null or empty insert.check again");
		}
		
		
	}
	
	@PostMapping("/adminlogin")
	public Admin adminlogin (@RequestBody Admin admin) throws Exception {
		String userid = admin.getAdminId();
		String passw = admin.getPassword();
		Admin logadmin = null;
		if(userid != null && passw != null) {
			logadmin = adminService.getAdminByIdAndPassword(userid, passw);
		}
		if(logadmin == null) {
			String messageone = "wrong password or Id number! please check again.";
			throw new Exception(messageone);
		}
		return logadmin;
	}
	
	@GetMapping("/getadmin")
	public List<Admin> getAdmins(){
		return adminService.getAdmins();
	
	}
	
	@GetMapping("/getadmin/{adminid}")
	public Admin getAdmin(@PathVariable String adminid) {
		return adminService.getAdminByAdminId(adminid);
	}
	
	@DeleteMapping("deleteadmin/{adminid}")
	public String deleteAdmin(@PathVariable String adminid) {
		return adminService.deleteAdmin(adminid);
	}
	
	@PutMapping("/updateadmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	
	
	}
