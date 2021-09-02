package com.petlodge.caretaker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petlodge.caretaker.entity.Item;
import com.petlodge.caretaker.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/additem")
	public Item addItemS(@RequestBody Item item) {
		
				return itemService.saveItem(item);
			
	}
	
	@PostMapping("/uploadimage")
	public String uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		itemService.updateItemImage(file);
		return "image upload success";
	}
	
	@GetMapping("/getitem")
	public List<Item> getItems(){
		return itemService.getItems();
	
	}
	
	@GetMapping("/getitem/{itemid}")
	public Item getItem(@PathVariable Long itemid) {
		return itemService.getItemByItemId(itemid);
	}
	
	@GetMapping("/getitembyseller/{sellerid}")
	public List<Item> getItemBySellerid(@PathVariable String sellerid) {
		return itemService.getItemBySellerid(sellerid);
	}
	
	
	@GetMapping("/getitemfromimage/{imagename}")
	public Item getItemByImageName(@PathVariable String imagename) {
		return itemService.getItemByImagefilename(imagename);
	}
	
	@GetMapping("/getitembyctgry/{category}")
	public List<Item> getItemByCtgry(@PathVariable String category) {
		return itemService.getItemByCtgry(category);
	}
	
	@DeleteMapping("deleteitem/{itemid}")
	public String deleteItem(@PathVariable Long itemid) {
		return itemService.deleteItem(itemid);
	}
	
	@PutMapping("/updateitem")
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}

}
