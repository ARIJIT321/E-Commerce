package com.shop.ServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.SellerException;
import com.shop.Exceptions.ProductException;
import com.shop.Model.Cart;
import com.shop.Model.CurrentUserSession;
import com.shop.Model.Seller;
import com.shop.Model.Products;
import com.shop.Repository.CartRepo;
import com.shop.Repository.CurrentUserSessionRepo;
import com.shop.Repository.Productrepo;
import com.shop.Repository.sellerRepo;
import com.shop.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private sellerRepo sRepo;
	
	@Autowired
	private Productrepo sProRepo;
	
	@Autowired
	private CartRepo cRepo;
	
	@Autowired
	private CurrentUserSessionRepo cusrepo;
	
	@Override
	public Products AddProduct(Products sproduct, String key, Integer sellerId)
			throws LoginException, SellerException {
		
		    Seller seller= CheckLogin(sellerId, key);
		    
		    seller.getList().add(sproduct);
		    
		    sproduct.setSeller(seller);
		    
		    Products sp= sProRepo.save(sproduct);
		      return sp;
	}

	@Override
	public List<Products> viewAllProductById(Integer sellerId,String key) throws ProductException, SellerException, LoginException {
		
		Seller seller= CheckLogin(sellerId, key);
		
	    List<Products> splist=seller.getList();
	    
	    if(splist.size()==0) throw new ProductException("No Product Added By this Seller...");
		
		return splist;
	}

	@Override
	public Products viewProductById(Integer sProdcutId,String key,Integer sellerId) throws ProductException, SellerException, LoginException {
		
		 CheckLogin(sellerId, key);
		
		Optional<Products> opt= sProRepo.findById(sProdcutId);
		
		if(opt.isEmpty()) throw new ProductException("No Product Found With Id:- "+sProdcutId);
		return opt.get();
	}

	@Override
	public List<Products> viewByCategory(String Category,String key,Integer sellerId) throws ProductException, SellerException, LoginException {
		   
		 CheckLogin(sellerId, key);
		
		List<Products> splist=sProRepo.findByCategory(Category);
		
		if(splist.size()==0) throw new ProductException("No Product Found With Category:- "+Category);
		
		return splist;
	}

	@Override
	public String removeSellerProduct(Integer sproductId, String key, Integer sellerId)
			throws LoginException, SellerException, ProductException {
		    
		  CheckLogin(sellerId, key);
		
		Optional<Products> proOpt= sProRepo.findById(sproductId);
		if(proOpt.isEmpty()) throw new ProductException("No Product Found With Id:- "+sproductId);
		
		Products product = proOpt.get();
		DeleteFromCart(product);
		sProRepo.delete(product);
		
		return "Product Deleted....";
	}

	@Override
	public Products updateProduct(Integer sellerId, String key, Products sProduct)
			throws LoginException, SellerException, ProductException {
		
		  CheckLogin(sellerId, key);
		
		Optional<Products> proOpt= sProRepo.findById(sProduct.getSeller_ProductId());
		if(proOpt.isEmpty()) throw new ProductException("No Product Found With Id:- "+sProduct.getSeller_ProductId());
		Products ExistingProduct=proOpt.get();
		
		sProduct.setSeller_ProductId(ExistingProduct.getSeller_ProductId());
		sProduct.setSeller(ExistingProduct.getSeller());
		
		sProRepo.save(sProduct);
		
		return sProduct;
	}

	public Seller CheckLogin(Integer sellerId,String key) throws SellerException, LoginException {
		
		Optional<Seller> opt= sRepo.findById(sellerId);
	    if(opt.isEmpty()) throw new SellerException("Invalid SellerId");
	    
	    CurrentUserSession cusr = cusrepo.findByUuid(key);
	    
	    if(cusr==null) throw new LoginException("Invalid Uuid");
	    Seller seller= opt.get();
	    if(seller.getSellerId()!=cusr.getUserId())
	    	throw new LoginException("Please Login first");
	    
	    return seller;
		
	}
	
	public void DeleteFromCart(Products product) {
		
		List<Cart> list= cRepo.findAll();
		
		for(Cart cart:list) {
			Map<Products, Integer> CartproList= cart.getProducts();
			
			if(CartproList.containsKey(product)) {
				int quan=CartproList.get(product);
				CartproList.remove(product);
				cart.setCartValue(cart.getCartValue()-(product.getPrice()*quan));
				cRepo.save(cart);
			}
		}
		
	}
	
}
