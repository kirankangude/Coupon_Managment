package com.demo.couponmanagement.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;
	
	
	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Cart(Long cartId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}




	public Long getcartId() {
		return cartId;
	}




	public void setId(Long cartId) {
		this.cartId = cartId;
	}




	public List<Product> getProducts() {
		return products;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}




	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}




	
	

}
