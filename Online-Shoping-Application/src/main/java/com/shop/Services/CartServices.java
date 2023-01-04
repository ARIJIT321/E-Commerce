package com.shop.Services;

import java.util.List;

import com.shop.Exceptions.CartException;
import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.ProductException;
import com.shop.Model.Cart;
import com.shop.Model.Products;

public interface CartServices {

	public Cart AddProductToCart(Integer productId,String key,Integer customerId)
			throws LoginException,CustomerException,ProductException;
	
	public Cart descreaseQuantityOfProduct(Integer productId,String key,Integer customerId,Integer Quantity)
			throws LoginException,CustomerException,ProductException,CartException;
	
	public Cart removeProductFromCart(Integer productId,String Key,Integer customerId)
			throws LoginException,CustomerException,ProductException,CartException;
	
	public Cart emptycart(String key,Integer customerId)
			throws LoginException,CustomerException,CartException;
	
	public List<Products> getAllProductInCart(Integer customerId,String key)
			throws LoginException,CustomerException,CartException;
	
	public Integer getCartValue(Integer customerId,String key)
			throws LoginException,CustomerException;
	
	
}
