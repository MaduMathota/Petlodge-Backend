package com.petlodge.caretaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findByCaretakersId(String caretakersId);

}
