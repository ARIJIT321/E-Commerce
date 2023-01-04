package com.shop.Controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.SellerException;
import com.shop.Model.Seller;
import com.shop.Services.SellerService;

@RestController
public class SellerController {

	@Autowired
	private  SellerService sService;
	
	@PostMapping("/AddSeller")
	public ResponseEntity<Seller> AddSellerHandler(@Valid @RequestBody Seller seller) throws SellerException{
		
		Seller resultSeller= sService.insertSeller(seller);
		
		return new ResponseEntity<Seller>(resultSeller,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateName")
	public ResponseEntity<Seller> updateNameHandler(@RequestParam Integer sellerId,@RequestParam String key,@RequestParam String SellerName) throws SellerException, LoginException{
		
		Seller sell= sService.updateName(sellerId, key, SellerName);
		
		return new ResponseEntity<Seller>(sell,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSeller")
	public ResponseEntity<String> deleteSellerHandler(@RequestParam Integer sellerId,@RequestParam String key) throws SellerException, LoginException{
		String message= sService.deleteSeller(sellerId, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	} 
	
	
}
