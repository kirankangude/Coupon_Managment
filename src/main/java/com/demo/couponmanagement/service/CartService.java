package com.demo.couponmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.couponmanagement.dao.CartDaoInt;
import com.demo.couponmanagement.entity.Cart;
import com.demo.couponmanagement.entity.Coupon;
import com.demo.couponmanagement.exception.CartNotFoundException;
import com.demo.couponmanagement.exception.CouponNotFountException;

@Service
public class CartService {

	
	@Autowired
	private CartDaoInt cartDaoInt;
	
	public Cart createCart(Cart cart) {
        return cartDaoInt.save(cart);
    }
	
	public List<Cart> getAllCarts() {
        return cartDaoInt.findAll();
    }


	public Cart getCartById(Long id) {
        return cartDaoInt.findById(id).orElseThrow(() -> new CartNotFoundException("Cart not found"));
    }
	
	
	

    public void deleteById(Long id) {
    	Cart cart = cartDaoInt.findById(id).orElseThrow(() -> new CouponNotFountException("Cart not found"));
        cartDaoInt.delete(cart);
    }
	
}
