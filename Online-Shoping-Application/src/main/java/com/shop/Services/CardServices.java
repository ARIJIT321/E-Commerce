package com.shop.Services;

import java.util.List;

import com.shop.Exceptions.CardException;
import com.shop.Exceptions.CustomerException;
import com.shop.Exceptions.LoginException;
import com.shop.Model.CardDetails;

public interface CardServices {

	public CardDetails addcard(CardDetails card,String key,Integer customerId) 
			throws CardException,LoginException,CustomerException;
	
	public String deleteCard(Integer cardId,String Key,Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public CardDetails getCardByCardId(Integer cardId,String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public List<CardDetails> getAllCardByCustomerId(String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
	
}
