package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Kennel;

public interface KennelRepository extends JpaRepository<Kennel, String> {

}
