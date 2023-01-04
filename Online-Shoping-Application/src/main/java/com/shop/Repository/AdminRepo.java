package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByUserName(String userName);
}
