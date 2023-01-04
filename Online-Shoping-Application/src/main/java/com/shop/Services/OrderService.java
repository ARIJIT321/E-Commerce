package com.shop.Services;

import java.util.List;

import com.shop.Exceptions.AddressException;
import com.shop.Exceptions.CartException;
import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.OrderException;
import com.shop.Model.Order;

public interface OrderService {

	public Order placeOrder(Integer customerId,String key)throws LoginException,CustomerException,OrderException ,CartException,AddressException;
	
	public Order getOrderById(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public List<Order> getAllOrder(Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public String cancelOrder(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public String deleteOrder(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
}
