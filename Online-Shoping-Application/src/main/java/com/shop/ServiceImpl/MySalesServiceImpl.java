package com.shop.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exceptions.AdminException;
import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.OrderException;
import com.shop.Model.Admin;
import com.shop.Model.CurrentUserSession;
import com.shop.Model.Customer;
import com.shop.Model.Order;
import com.shop.Repository.AdminRepo;
import com.shop.Repository.CurrentUserSessionRepo;
import com.shop.Repository.OrderRepo;
import com.shop.Services.MySalesServices;

@Service
public class MySalesServiceImpl implements MySalesServices{

	@Autowired
	private AdminRepo arepo;
	
	@Autowired
	private CurrentUserSessionRepo cusRepo;
	
	@Autowired
	private OrderRepo orepo;
	
	@Override
	public List<Order> SalesForToday(Integer AdminId,String key) throws AdminException, LoginException, OrderException  {
		
		 checkLogin(key, AdminId);
		
		List<Order> olist = orepo.findByOrderDate(LocalDate.now());
		
		if(olist.size()==0) throw new OrderException("No Order placed Today");
		
		return olist;
	}

	@Override
	public List<Order> SalesForWeek(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusWeeks(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForMonth(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusMonths(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForYear(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusYears(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Year");
			
		return olist;
	}

	@Override
	public List<Order> SalesBetweenDates(LocalDate l1, LocalDate l2, Integer AdminId, String key)
			throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(l1, l2);
			
			if(olist.size()==0) throw new OrderException("No Order placed between "+l1+" and "+l2);
			
		return olist;
	}

	public Admin checkLogin(String key, Integer AdminId) throws LoginException, AdminException {
		Optional<Admin> opt = arepo.findById(AdminId);
		if (opt.isEmpty())
			throw new AdminException("No Admin Found with id:- " + AdminId);

		Admin admin = opt.get();
		CurrentUserSession cus = cusRepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != admin.getAdminId())
			throw new LoginException("Please Login first.....");

		return admin;

	}
	
	
}
