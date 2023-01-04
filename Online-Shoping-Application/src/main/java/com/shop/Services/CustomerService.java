package com.shop.Services;

import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Model.Address;
import com.shop.Model.Customer;

public interface CustomerService {

	public Customer AddCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(String key,Customer customer)throws CustomerException,LoginException;
	
	public Address AddAddress(Address address,String key,Integer CustomerId)throws CustomerException,LoginException;
	
	public String deleteCustomer(Integer customerId, String key)throws CustomerException,LoginException;
	
}
