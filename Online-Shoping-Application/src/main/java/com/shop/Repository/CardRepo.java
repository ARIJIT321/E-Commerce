package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.Model.CardDetails;

public interface CardRepo extends JpaRepository<CardDetails, Integer>{

}
