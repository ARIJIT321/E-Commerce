package com.shop.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	private double orderAmount;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="Order_table_Product",joinColumns = @JoinColumn(name="Order_table_Id"))
//	@Column(name="Quantity")
//	@MapKeyJoinColumn(name="Product_Id",referencedColumnName = "seller_ProductId")
//	@JsonIgnore
//	private Map<Products, Integer> products;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProductDTO> productList;
	
	@OneToOne
	@JsonIgnore
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Payment payment;
	
}
