package com.demo.couponmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.couponmanagement.dao.CartDaoInt;
import com.demo.couponmanagement.entity.Cart;
import com.demo.couponmanagement.entity.Coupon;
import com.demo.couponmanagement.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/save_cart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart=cartService.createCart(cart);
        return  ResponseEntity.ok(createdCart);
    }
	
	
	 @GetMapping("/get_allcart")
	    public  ResponseEntity<List<Cart>> getAllCarts() {
	        List<Cart> carts = cartService.getAllCarts();
	        return ResponseEntity.ok(carts);
	    }

	    @GetMapping("/get_cart_byId/{id}")
	    public  ResponseEntity<Cart> getCouponById(@PathVariable Long id) {
	        Cart cart = cartService.getCartById(id);
	        return ResponseEntity.ok(cart);
	    }
	    
	   

	    @DeleteMapping("/delete_coupons/{id}")
	    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
	        cartService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	
	
}
