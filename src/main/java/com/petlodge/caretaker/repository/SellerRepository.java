package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Seller;



public interface SellerRepository extends JpaRepository < Seller,String>{

	Seller findBySellerIdAndSellerPassword(String sellerId, String sellerPassword);



		
}