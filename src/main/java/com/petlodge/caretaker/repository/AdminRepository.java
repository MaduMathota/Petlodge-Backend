package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	Admin findByAdminIdAndPassword(String adminid,String password);
}
