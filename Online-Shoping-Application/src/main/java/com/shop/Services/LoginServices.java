package com.shop.Services;

import com.shop.Exceptions.LoginException;
import com.shop.Model.CurrentUserSession;
import com.shop.Model.Login;

public interface LoginServices {

	public CurrentUserSession customerlogin(Login log) throws LoginException;
	
	public CurrentUserSession sellerlogin(Login log) throws LoginException;

	public String Logout(Integer id , String uuid) throws LoginException;
	
	public CurrentUserSession adminlogin(Login log) throws LoginException;
}
