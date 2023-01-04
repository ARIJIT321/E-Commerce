package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

	
}
