package com.demo.couponmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.couponmanagement.entity.Product;


@Repository
public interface ProductDaoInt extends JpaRepository<Product, Long>{

}
