package com.rk.springboot.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//The @ControllerAdvice is an annotation, to handle the exceptions globally.
@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<Object> exception(ProductNotfoundException exception)
	{
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
}
