package com.blog.app.exceptionhandler;

public class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
		
	}

	public ApiException() {
		super();
		
	}
	
	
	
}
