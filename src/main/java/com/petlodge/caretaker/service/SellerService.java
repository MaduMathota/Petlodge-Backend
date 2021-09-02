package com.petlodge.caretaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petlodge.caretaker.entity.Seller;
import com.petlodge.caretaker.entity.Veterinarian;
import com.petlodge.caretaker.repository.SellerRepository;



@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
/////////post method///////////////////////////////////////////
	public Seller saveSeller(Seller seller) {
		
		String encodepassword = passwordEncoder.encode(seller.getSellerPassword());
		seller.setSellerPassword(encodepassword);
		
		
		return repository.save(seller);
	}
	

	
/////////get method///////////////////////////////////////////

	public List<Seller> getSellers(){
		return repository.findAll();
	}

	public Seller getSellerById(String sellerId){
		return repository.findById(sellerId).orElse(null);
	}
	
	public Seller getSellerByIdandPassword(String sellerId,String sellerPassword) {
		
		Seller existingSeller = null;
		Seller chekingSeller = repository.findById(sellerId).orElse(null);
		if(chekingSeller != null) {
			if(passwordEncoder.matches(sellerPassword, chekingSeller.getSellerPassword())) {
				existingSeller = chekingSeller;
			}
			else {
				existingSeller = null;
			}
		}
		return existingSeller;
		                      
	}
	
//	public Seller getSellerByName(String sellerName){
//		return repository.findByName(sellerName);
//	}
	
	
/////////delete method////////////////////////////////////////
	
	public String deleteSeller(String sellerId) {
		repository.deleteById(sellerId);
		return "succesfully deleted id :"+sellerId;
	}
	
////////put(update) method///////////////////////////////////
	
	public Seller updateSeller(Seller seller) {
		Seller existedSeller = repository.findById(seller.getSellerId()).orElse(null);
		existedSeller.setSellerAddress(seller.getSellerAddress());
		existedSeller.setSellerContactNo(seller.getSellerContactNo());
		existedSeller.setSellerEmail(seller.getSellerEmail());
		existedSeller.setSellerName(seller.getSellerName());
		existedSeller.setSellerStatus(seller.getSellerStatus());
		
		return repository.save(existedSeller);
	}	
	
	public Seller updateSellerpw(Seller seller) {
		Seller exsistingSeller = repository.findById(seller.getSellerId()).orElse(null);

		exsistingSeller.setSellerPassword(passwordEncoder.encode(seller.getSellerPassword()));

		return repository.save(exsistingSeller);
	}
	
}