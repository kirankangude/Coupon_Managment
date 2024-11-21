package com.demo.couponmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.couponmanagement.dao.ProductDaoInt;
import com.demo.couponmanagement.entity.Product;
import com.demo.couponmanagement.exception.ProductNotFountException;

@Service
public class ProductService {
	

	@Autowired
	private ProductDaoInt productDaoInt;
	public Product saveProduct(Product product)
	{
		return productDaoInt.save(product);
	}
	
	
	public List<Product> getAllProducts() {
        return productDaoInt.findAll();
    }

    public Product getProductById(Long id) {
        return productDaoInt.findById(id).orElseThrow(() -> new ProductNotFountException("Product not found"));
    }

    public Product updateProduct(Long id,Product productDetails) {
       Product product= productDaoInt.findById(id).orElseThrow(() -> new ProductNotFountException("Product not found"));
        		
        
        product.setProductName(productDetails.getProductName());
        product.setQuantity(productDetails.getQuantity());
        return productDaoInt.save(product);
        

    }

    public void deleteProduct(Long id) {
    	Product product = productDaoInt.findById(id).orElseThrow(() -> new ProductNotFountException("Product not found"));
        productDaoInt.delete(product);
    }

	
	
}
