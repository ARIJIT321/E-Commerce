package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

	
}
