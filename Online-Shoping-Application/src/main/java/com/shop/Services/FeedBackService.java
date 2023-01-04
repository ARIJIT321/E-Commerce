package com.shop.Services;

import java.util.List;

import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.FeedBackException;
import com.shop.Exceptions.LoginException;
import com.shop.Exceptions.OrderException;
import com.shop.Model.Feedback;

public interface FeedBackService {

	public Feedback AddFeedBack(Feedback feedback,Integer orderId,Integer customerId,String key)
	throws LoginException,CustomerException,OrderException,FeedBackException;
	
	public Feedback updateFeedback(Feedback feedback,Integer customerId,String key) 
			throws LoginException,CustomerException,FeedBackException;
	
	public String deletefeedback(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	public List<Feedback> viewAllFeedback(Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	public Feedback viewFeedBackById(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	
}
