package com.shop.Services;

import com.shop.Exceptions.AdminException;
import com.shop.Exceptions.LoginException;
import com.shop.Model.Admin;

public interface AdminServices {

	public Admin addadmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key) throws LoginException,AdminException;
	
	public String deleteAdmin(Integer adminId,String key)
			throws LoginException,AdminException;
	
	public Admin getAdminById(Integer adminId,String key)
			throws LoginException,AdminException;
}
