package com.shop.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.SellerException;
import com.shop.Model.CurrentUserSession;
import com.shop.Model.Seller;
import com.shop.Repository.CurrentUserSessionRepo;
import com.shop.Repository.sellerRepo;
import com.shop.Services.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private sellerRepo sRepo;// Seller Repo 

	@Autowired
	private CurrentUserSessionRepo cusRepo; //login repo
	
	
	@Override
	public Seller insertSeller(Seller seller) throws SellerException {
		Seller existingSeller = sRepo.findByEmail(seller.getEmail());

		if (existingSeller != null) {
			throw new SellerException("Seller with this Email already Exist");
		}

		Seller newSeller = sRepo.save(seller);

		return newSeller;
	}

	@Override
	public String deleteSeller(int sid, String Key) throws SellerException, LoginException {
		// Checking If Seller Exist...
				Optional<Seller> opt = sRepo.findById(sid);
				if (opt == null)
					throw new SellerException("Invalid Credentials...!");

				Seller seller = opt.get();

				// checking if Seller is logged in..
				CurrentUserSession cus = cusRepo.findByUuid(Key);

				if (cus.getUserId() == sid) {
					throw new LoginException("Please Login First");
				}

				// Deleting Seller...
				sRepo.delete(seller);

				return "We hope you enjoy our service "+seller.getSellerName();
	}

	@Override
	public Seller updateName(int sid, String key, String sellerName) throws SellerException, LoginException {
		// Checking If Seller Exist...
				Optional<Seller> opt = sRepo.findById(sid);
				if (opt == null)
					throw new SellerException("Invalid Credentials...!");

				Seller seller = opt.get();

				// checking if Seller is logged in..
				CurrentUserSession cus = cusRepo.findByUuid(key);

				if (cus.getUserId() != sid) {
					throw new LoginException("Please Login First");
				}
				
				seller.setSellerName(sellerName);
				sRepo.save(seller);
				
				
				return seller;
	}

	
}
