package com.demo.couponmanagement.util;

import java.util.Map;

import com.demo.couponmanagement.entity.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CouponUtil {
	
	
	 private static final ObjectMapper objectMapper = new ObjectMapper();
	 
	 
	 //productwise Discount
	 public static double productWiseDiscount(Cart cart, Map<String, Object> details) {
	        String productName = (details.get("productName")).toString();
	        double discount = (double) details.get("discount");
	        return cart.getProducts().stream()
	                .filter(product -> product.getProductName().equals(productName))
	                .mapToDouble(product -> product.getQuantity() *product.getPrice() * (discount / 100))
	                .sum();
	    }
	 
	 
	 //Cartwise Discount

	    public static double cartWiseDiscount(Cart cart, Map<String, Object> details) {
	        double total = cart.getProducts().stream().mapToDouble(product -> product.getQuantity() * product.getPrice()).sum();
	        double threshold = (double) details.get("threshold");
	        double discount = (double) details.get("discount");
	        return total > threshold ? total * (discount / 100) : 0;
	    }

	   
//
	    public static double discountByBxGy(Cart cart, Map<String, Object> details) {
	        Map<String, Integer> buyProducts = (Map<String, Integer>) details.get("buyProducts");
	        Map<String, Integer> getProducts = (Map<String, Integer>) details.get("getProducts");
	        int repetitionLimit = (int) details.get("repetitionLimit");

	        Long buyCount = cart.getProducts().stream()
	                .filter(product -> buyProducts.containsKey(product.getProductName().toString()))
	                .mapToLong(product -> product.getQuantity())
	                .sum();

        Long getCount = Math.min(buyCount / buyProducts.values().stream().mapToInt(Integer::intValue).sum(), repetitionLimit) *
               getProducts.values().stream().mapToInt(Integer::intValue).sum();

	        double discount = cart.getProducts().stream()
	                .filter(product -> getProducts.containsKey(product.getProductName().toString()))
	                .mapToDouble(product -> Math.min(getCount, product.getQuantity()) * product.getPrice())
	                .sum();

	        return discount;
	    }
	}


