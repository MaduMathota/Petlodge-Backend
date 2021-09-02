package com.petlodge.caretaker.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Caretaker;

public interface Caretakerrepository extends JpaRepository<Caretaker, String>{

	Caretaker findByCaretakerIdAndCarePassword(String caretakerId, String carePassword);

}
