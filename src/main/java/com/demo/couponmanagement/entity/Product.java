package com.demo.couponmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	private Long quantity;
	
    private Double price;
    
    @ManyToOne
    @JoinColumn (name= "cart_id")
    private Cart cart;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String productName, Long quantity, Double price, Cart cart) {
		super();
		this.id = id;
		this.productName=productName;
		this.quantity = quantity;
		this.price = price;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ",productName="+productName+", quantity=" + quantity + ", price=" + price
				+ ", cart=" + cart + "]";
	}

	

	

	
    
}
