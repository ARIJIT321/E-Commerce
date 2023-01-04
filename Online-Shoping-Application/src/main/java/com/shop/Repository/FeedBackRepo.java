package com.shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.Customer;
import com.shop.Model.Feedback;
import com.shop.Model.Order;

@Repository
public interface FeedBackRepo extends JpaRepository<Feedback, Integer>{

	public List<Feedback> findByCustomer(Customer customer);
	
	public List<Feedback> findByOrder(Order order);
	
}
