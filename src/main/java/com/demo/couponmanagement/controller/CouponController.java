package com.demo.couponmanagement.controller;

import java.util.List;

import java.util.Optional;

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

import com.demo.couponmanagement.entity.Coupon;
import com.demo.couponmanagement.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	CouponService couponService;
	
	
	@PostMapping("/save_coupon")
	public ResponseEntity<Coupon> saveCoupon(Coupon coupon)
	{
		Coupon savedCoupon = couponService.saveCoupon(coupon);
        return ResponseEntity.ok(savedCoupon);
	}

	
	 @GetMapping("/get_allcoupons")
	    public  ResponseEntity<List<Coupon>> getAllCoupons() {
	        List<Coupon> coupons = couponService.getAllCoupons();
	        return ResponseEntity.ok(coupons);
	    }

	    @GetMapping("/get_coupon_byId/{id}")
	    public  ResponseEntity<Coupon> getCouponById(@PathVariable Long id) {
	        Coupon coupon = couponService.getCouponById(id);
	        return ResponseEntity.ok(coupon);
	    }
	    
	    @PutMapping("/update_coupons_byId/{id}")
	    public ResponseEntity<Coupon> updateCoupon(@PathVariable Long id, @RequestBody Coupon couponDetails) {
	        Coupon updatedCoupon = couponService.updateCoupon(id, couponDetails);
	        return ResponseEntity.ok(updatedCoupon);
	    }

	    @DeleteMapping("/delete_coupons/{id}")
	    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
	        couponService.deleteCoupon(id);
	        return ResponseEntity.noContent().build();
	    }
}
