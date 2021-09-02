package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.AppointmentPet;
import com.petlodge.caretaker.entity.Caretaker;
import com.petlodge.caretaker.entity.Job;
import com.petlodge.caretaker.entity.Kennel;
import com.petlodge.caretaker.repository.Caretakerrepository;
import com.petlodge.caretaker.repository.JobRepository;
import com.petlodge.caretaker.repository.KennelRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository repository;
	
	@Autowired
	private Caretakerrepository caretakerrepository;
	
	@Autowired
	private KennelRepository kennelrepository;
	
	
	////////create/////////////////////////////////
	public Job saveJob(Job job) {
		
		Caretaker caretakerone = caretakerrepository.findById(job.getCaretakersId()).orElse(null);
		job.setCaretaker(caretakerone);
		caretakerone.getJobs().add(job);
		
		Kennel existingKennel = kennelrepository.findById(job.getKennelid()).orElse(null);
		existingKennel.setAssignedpet(job.getPetid());
		job.setKennel(existingKennel);
		existingKennel.setJob(job);
		
		return repository.save(job);
		
	}
	
	////////get///////////////////////////////////
	public Job getJobById(Long id) {
		return repository.findById(id).orElse(null);
		
	}
	
	public List<Job> getJobs() {
		return repository.findAll();
		
	}
	
	public List<Job> getJobByCaretakersId(String id) {
		return repository.findByCaretakersId(id);
		
	}
	
	/////////delete//////////////////////////////////
	public String deleteJob(Long id) {
		repository.deleteById(id);
		return "delete successfully";
	
	}
	
	////////update//////////////////////////////////
	public Job updateJob(Job job) {
		
		Job exsistingJob = repository.findById(job.getId()).orElse(null);
		
		Kennel oldkennel = kennelrepository.findById(exsistingJob.getKennelid()).orElse(null);
		oldkennel.setAssignedpet(null);
		oldkennel.setJob(null);
		kennelrepository.save(oldkennel);
		
		Caretaker newcaretaker = caretakerrepository.findById(job.getCaretakersId()).orElse(null);
		Kennel existingKennel = kennelrepository.findById(job.getKennelid()).orElse(null);
		
		exsistingJob.setId(job.getId());
		
		exsistingJob.setCaretakersId(job.getCaretakersId());
		exsistingJob.setCaretaker(newcaretaker);
		
		
		exsistingJob.setEndDate(job.getEndDate());
		
		exsistingJob.setKennelid(job.getKennelid());
		exsistingJob.setKennel(existingKennel);
		
		
		exsistingJob.setPetid(job.getPetid());
		exsistingJob.setStartDate(job.getStartDate());
		
		existingKennel.setAssignedpet(job.getPetid());
		existingKennel.setJob(exsistingJob);
		
		
		newcaretaker.getJobs().add(exsistingJob);
		
		return repository.save(exsistingJob);
		
	}

}
