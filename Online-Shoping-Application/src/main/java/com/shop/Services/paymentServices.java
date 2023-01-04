package com.shop.Services;

import java.util.List;

import com.shop.Exceptions.CardException;
import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.OrderException;
import com.shop.Exceptions.PaymentException;
import com.shop.Model.Payment;

public interface paymentServices {

	public Payment makePayment(Integer orderId,Integer cardId,Integer customerId,String key) 
			throws LoginException,CustomerException,OrderException,PaymentException,CardException;
	
	public Payment viewPaymentDetailsById(Integer paymentId,Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
	
	public List<Payment> getAllPaymentByCustomer(Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
	
	public String cancelPayment(Integer payId,Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
}
