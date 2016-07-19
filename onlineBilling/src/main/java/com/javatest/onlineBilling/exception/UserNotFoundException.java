package com.javatest.onlineBilling.exception;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -937718312850272621L;

	public UserNotFoundException(String message){
		super(message);
	}

}
