package com.shop.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.Exceptions.AdminException;
import com.shop.Exceptions.LoginException;
import com.shop.Model.Admin;
import com.shop.Model.CurrentUserSession;
import com.shop.Repository.AdminRepo;
import com.shop.Repository.CurrentUserSessionRepo;
import com.shop.Services.AdminServices;

@Service
public class AdminServicesImpl implements AdminServices{

	@Autowired
	private AdminRepo arepo;
	
	@Autowired
	private CurrentUserSessionRepo cusrepo;
	
	
	@Override
	public Admin addadmin(Admin admin) throws AdminException {
		
		Admin ad1 = arepo.findByUserName(admin.getUserName());
		if(ad1!=null) {
			throw new AdminException("Admin already exist with username "+admin.getUserName());
		}
		Admin ad = arepo.save(admin);
		return ad;
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws LoginException, AdminException {
		checkLogin(key, admin.getAdminId());
		
		arepo.save(admin);
		
		return admin;
	}

	@Override
	public String deleteAdmin(Integer adminId, String key) throws LoginException, AdminException {
		Admin admin = checkLogin(key, adminId);
		
		arepo.delete(admin);
		cusrepo.delete(cusrepo.findByUuid(key));
		
		return "Admin Deleted Sucessfully";
	}

	@Override
	public Admin getAdminById(Integer adminId, String key) throws LoginException, AdminException {
		Admin admin = checkLogin(key, adminId);
		return admin;
	}

	public Admin checkLogin(String key, Integer AdminId) throws LoginException, AdminException {
		Optional<Admin> opt = arepo.findById(AdminId);
		if (opt.isEmpty())
			throw new AdminException("No Admin Found with id:- " + AdminId);

		Admin admin = opt.get();
		CurrentUserSession cus = cusrepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != admin.getAdminId())
			throw new LoginException("Please Login first.....");

		return admin;

	}
}
