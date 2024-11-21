package com.demo.couponmanagement.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.couponmanagement.entity.Coupon;
@Repository

public interface CouponDaoInt extends JpaRepository<Coupon, Long>{
}
