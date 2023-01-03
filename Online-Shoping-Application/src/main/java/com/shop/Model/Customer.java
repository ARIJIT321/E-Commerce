package com.shop.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@Size(min = 2, max = 20, message = "FirstName should have 2 to 20 characters")
	private String firstName;
	
	@Size(min = 2, max = 20, message = "FirstName should have 2 to 20 characters")
	private String lastName;
	
	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Enter valid Password")
	private String password;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<CardDetails> card;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer") 
	private List<Order> orderList;
}
