package com.shop.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CardId;
	
	@CreditCardNumber(message="Invalid Card Number")
	private String CardNumber;
	
//	@Size(min = 3,max = 3, message = "Invalid Cvv")
	@Transient
	@JsonIgnore
	private Integer cvv;
	
	@DateTimeFormat(pattern = "mm/yy")
	private LocalDate validFrom;
	
	@DateTimeFormat(pattern = "mm/yy")
	private LocalDate validTo;
	
	
	
}
