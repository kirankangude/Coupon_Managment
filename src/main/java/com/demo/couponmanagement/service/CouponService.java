package com.demo.couponmanagement.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.couponmanagement.dao.CouponDaoInt;
import com.demo.couponmanagement.entity.Coupon;
import com.demo.couponmanagement.exception.CouponNotFountException;

@Service
public class CouponService {
	
	
	@Autowired
	private CouponDaoInt couponDaoInt;
	public Coupon saveCoupon(Coupon coupon)
	{
		return couponDaoInt.save(coupon);
	}
	
	
	public List<Coupon> getAllCoupons() {
        return couponDaoInt.findAll();
    }

    public Coupon getCouponById(Long id) {
        return couponDaoInt.findById(id).orElseThrow(() -> new CouponNotFountException("Coupon not found"));
    }

    public Coupon updateCoupon(Long id, Coupon couponDetails) {
       Coupon coupon= couponDaoInt.findById(id).orElseThrow(() -> new CouponNotFountException("Coupon not found"));
        		
        
        coupon.setCouponType(couponDetails.getCouponType());
        coupon.setDetails(couponDetails.getDetails());
        return couponDaoInt.save(coupon);
        

    }

    public void deleteCoupon(Long id) {
    	Coupon coupon = couponDaoInt.findById(id).orElseThrow(() -> new CouponNotFountException("Coupon not found"));
        couponDaoInt.delete(coupon);
    }

}
