package com.petlodge.caretaker.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByImagefilename(String imagefilename);
	
	List<Item> findBySellerid(String sellerid);
	
	List<Item> findByCategory(String category);

	
	
}
