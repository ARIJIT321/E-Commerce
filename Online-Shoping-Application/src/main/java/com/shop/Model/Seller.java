package com.shop.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	
	private String sellerName;
	
	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;
	
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Enter valid Password")
	private String password;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
	private List<Products> list=new ArrayList<>();
}
