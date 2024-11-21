package com.demo.couponmanagement.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long couponId;
	
	
	private String couponType;
	
	@Lob
	private String details;
	private Date exDate;
	
	
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Coupon(Long couponId, String couponType, String details, Date exDate) {
		super();
		this.couponId = couponId;
		this.couponType = couponType;
		this.details = details;
		this.exDate =exDate;
	}


	public Long getCouponId() {
		return couponId;
	}


	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}


	public String getCouponType() {
		return couponType;
	}


	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public Date getExDate() {
		return exDate;
	}


	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}


	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponType=" + couponType + ", details=" + details + ", exDate="
				+ exDate + "]";
	}
	
	
	
	
}