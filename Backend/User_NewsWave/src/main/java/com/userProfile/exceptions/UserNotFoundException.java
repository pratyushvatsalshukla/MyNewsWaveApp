package com.userProfile.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserNotFoundException extends RuntimeException {

	String fieldName ;
	
	public UserNotFoundException() {
		
	}
	
	public UserNotFoundException(String fieldName) {
		super(String.format("User with Id : %s Not Found or Password Entered is Incorrect", fieldName)) ;
		this.fieldName=fieldName ;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
