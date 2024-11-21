package com.demo.couponmanagement.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return map;
	
	}
	
	
	 @ExceptionHandler(CouponNotFountException.class)
	    public ResponseEntity<?> handleResourceNotFoundException(CouponNotFountException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 

	 @ExceptionHandler(CartNotFoundException.class)
	    public ResponseEntity<?> handleCartNotFoundException(CouponNotFountException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	
	 @ExceptionHandler(InvalidInputException.class)
	    public ResponseEntity<?> handleInvalidInputException(CouponNotFountException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	
}
