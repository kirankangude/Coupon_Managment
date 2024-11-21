package com.demo.couponmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.couponmanagement.entity.Cart;

public interface CartDaoInt extends JpaRepository<Cart, Long>{

}
