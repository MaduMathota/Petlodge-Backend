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

import com.petlodge.caretaker.entity.Job;
import com.petlodge.caretaker.service.JobService;

@RestController
@CrossOrigin(origins = "*")
public class JobController {

	@Autowired
	private JobService service;
	
	@PostMapping("/addjob")
	public Job addJob(@RequestBody Job job) throws Exception {
		
		return service.saveJob(job);
	
	}
	
	@GetMapping("/getjob")
	public List<Job> getJobs(){
		return service.getJobs();
	
	}
	
	@GetMapping("/getjob/{id}")
	public Job getJob(@PathVariable Long id) {
		return service.getJobById(id);
	}
	
	@GetMapping("/getjobbycaretakerid/{id}")
	public List<Job> getJobBycaretakerId(@PathVariable String id) {
		return service.getJobByCaretakersId(id);
	}
	
	@DeleteMapping("deletejob/{id}")
	public String deleteJob(@PathVariable Long id) {
		return service.deleteJob(id);
	}
	
	@PutMapping("/updatejob")
	public Job updateJob(@RequestBody Job job) {
		return service.updateJob(job);
	}
	
}
