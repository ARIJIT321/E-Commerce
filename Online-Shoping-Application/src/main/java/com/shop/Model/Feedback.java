package com.shop.Model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@Min(1)
	@Max(5)
	private Integer productRating;
	
	@Min(1)
	@Max(5)
	private Integer serviceRating;
	
	@Min(1)
	@Max(5)
	private Integer overAllRating;
	
	@NotBlank(message = "Message Cannot be Blank")
	@NotNull(message = "Message Cannot be Null")
	private String Message;
	
	private LocalDate localdate;
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	@OneToOne
	@JsonIgnore
	private Order order;
}
