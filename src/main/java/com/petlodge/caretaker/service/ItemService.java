package com.petlodge.caretaker.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.petlodge.caretaker.entity.Caretaker;
import com.petlodge.caretaker.entity.Item;
import com.petlodge.caretaker.entity.Seller;
import com.petlodge.caretaker.repository.ItemRepository;
import com.petlodge.caretaker.repository.SellerRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemrepository;
	
	@Autowired
	private SellerRepository sellerrepository;

	//////// create/////////////////////////////////
	public Item saveItem(Item item) {
		
		Seller sellernew = sellerrepository.findById(item.getSellerid()).orElse(null);
		item.setSeller(sellernew);
		sellernew.getItems().add(item);
		
		return itemrepository.save(item);

	}

	//////// get///////////////////////////////////
	public List<Item> getItems() {
		return itemrepository.findAll();

	}
	
	public Item getItemByItemId(Long id) {
		return itemrepository.findById(id).orElse(null);

	}
	
	public List<Item> getItemBySellerid(String id) {
		return itemrepository.findBySellerid(id);

	}
	
	public List<Item> getItemByCtgry(String category) {
		return itemrepository.findByCategory(category);
	}


	public Item getItemByImagefilename(String imagefilename) {

		return itemrepository.findByImagefilename(imagefilename);

	}

	///////// delete//////////////////////////////////
	public String deleteItem(Long itemid) {
		itemrepository.deleteById(itemid);
		return "delete successfully";

	}

	//////// update//////////////////////////////////
	public Item updateItem(Item item) {

		Item exsistingItem = itemrepository.findByImagefilename(item.getImagefilename());

		exsistingItem.setCategory(item.getCategory());
		exsistingItem.setDescription(item.getDescription());
		exsistingItem.setId(item.getId());
		exsistingItem.setImagefilename(item.getImagefilename());
		exsistingItem.setName(item.getName());
		exsistingItem.setSellerid(item.getSellerid());
		exsistingItem.setPicByte(item.getPicByte());
		exsistingItem.setPrice(item.getPrice());
		exsistingItem.setQuantity(item.getQuantity());

		return itemrepository.save(exsistingItem);

	}

	public Item updateItemImage(MultipartFile item) throws IOException {

		Item exsistingItem = itemrepository.findByImagefilename(item.getOriginalFilename());

		exsistingItem.setPicByte(item.getBytes());

		return itemrepository.save(exsistingItem);

	}

	
}
