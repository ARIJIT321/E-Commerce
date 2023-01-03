package com.shop.Model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	private boolean paymentStatus;
	
	private Integer paymentAmount;
	
	private LocalDate localDate;
	
	@JsonIgnore
	@OneToOne
	private CardDetails card;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	
}
