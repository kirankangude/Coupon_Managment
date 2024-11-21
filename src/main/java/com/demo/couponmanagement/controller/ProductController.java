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

import com.demo.couponmanagement.entity.Coupon;
import com.demo.couponmanagement.entity.Product;
import com.demo.couponmanagement.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/save_product")
	public ResponseEntity<Product> saveCoupon(Product product)
	{
		Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
	}
	
	
	 @GetMapping("/get_allproduct")
	    public  ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> product = productService.getAllProducts();
	        return ResponseEntity.ok(product);
	    }

	    @GetMapping("/get_product_byId/{id}")
	    public  ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }
	    
	    @PutMapping("/update_product_byId/{id}")
	    public ResponseEntity<Product> updateCoupon(@PathVariable Long id, @RequestBody Product productDetails) {
	        Product updatedProduct = productService.updateProduct(id, productDetails);
	        return ResponseEntity.ok(updatedProduct);
	    }

	    @DeleteMapping("/delete_product/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }

}
