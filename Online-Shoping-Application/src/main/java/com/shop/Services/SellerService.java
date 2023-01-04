package com.shop.Services;

import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.SellerException;
import com.shop.Model.Seller;

public interface SellerService {

	public Seller insertSeller(Seller seller) throws SellerException;

	public String deleteSeller(int sid, String Key) throws SellerException, LoginException;

	public Seller updateName(int sid, String key, String sellerName) throws SellerException, LoginException;
}
