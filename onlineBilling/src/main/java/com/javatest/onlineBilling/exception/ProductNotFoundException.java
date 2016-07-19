package com.javatest.onlineBilling.exception;

public class ProductNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 6220990311631669980L;

	public ProductNotFoundException(){
		super("Product not found");
		
	}
}
