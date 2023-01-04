package com.shop.Services;

import java.time.LocalDate;
import java.util.List;

import com.shop.Exceptions.AdminException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.OrderException;
import com.shop.Model.Order;

public interface MySalesServices {

	public List<Order> SalesForToday(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForWeek(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForMonth(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForYear(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesBetweenDates(LocalDate l1,LocalDate l2,Integer AdminId,String key)
			throws AdminException,LoginException,OrderException;
}
