package com.shop.ServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exceptions.LoginException;
import com.shop.Model.Admin;
import com.shop.Model.CurrentUserSession;
import com.shop.Model.Customer;
import com.shop.Model.Login;
import com.shop.Model.Seller;
import com.shop.Repository.AdminRepo;
import com.shop.Repository.CurrentUserSessionRepo;
import com.shop.Repository.CustomerRepo;
import com.shop.Repository.sellerRepo;
import com.shop.Services.LoginServices;

import org.apache.commons.lang3.RandomStringUtils;


@Service
public class LoginServiceImpl implements LoginServices {

	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private sellerRepo sRepo;

	@Autowired
	private CurrentUserSessionRepo cusr;
	
	@Autowired
	private AdminRepo arepo;

	@Override
	public CurrentUserSession customerlogin(Login log) throws LoginException {

		Customer customer = crepo.findByEmail(log.getEmail());

		if (customer == null) {
			throw new LoginException("No Customer Found With this Email");
		}

		Optional<CurrentUserSession> opt = cusr.findById(customer.getCustomerId());

		if (opt.isPresent())
			throw new LoginException("User Already Logged In....");

		String uuid = RandomStringUtils.random(6);

		CurrentUserSession cus = new CurrentUserSession(customer.getCustomerId(), LocalDate.now(), uuid);
		cusr.save(cus);
		return cus;
	}

	@Override
	public CurrentUserSession sellerlogin(Login log) throws LoginException {
		Seller seller = sRepo.findByEmail(log.getEmail());

		if (seller == null) {
			throw new LoginException("No Seller Found With this Email");
		}

		Optional<CurrentUserSession> opt = cusr.findById(seller.getSellerId());

		if (opt.isPresent())
			throw new LoginException("seller Already Logged In....");

		String uuid = RandomStringUtils.random(6);

		CurrentUserSession cus = new CurrentUserSession(seller.getSellerId(), LocalDate.now(), uuid);
		cusr.save(cus);
		return cus;
	}

	@Override
	public String Logout(Integer id,String uuid) throws LoginException {
		
		CurrentUserSession cus= cusr.findByUuid(uuid);
		
		if(cus==null) throw new LoginException("Invalid Uuid....");
		
		if(id!=cus.getUserId()) throw new LoginException("Invalid Credentials");
		
		cusr.delete(cus);
		return "Logged Out";
	}

	@Override
	public CurrentUserSession adminlogin(Login log) throws LoginException {
		Admin admin = arepo.findByUserName(log.getEmail());
		
		if(admin==null) throw new LoginException("Admin Not found with email: "+log.getEmail());
		
		Optional<CurrentUserSession> opt = cusr.findById(admin.getAdminId());

		if (opt.isPresent())
			throw new LoginException("Admin Already Logged In....");
		
		String uuid = RandomStringUtils.random(6);
		
		CurrentUserSession cus = new CurrentUserSession(admin.getAdminId(), LocalDate.now(), uuid);
		cusr.save(cus);
		return cus;
	}

}
