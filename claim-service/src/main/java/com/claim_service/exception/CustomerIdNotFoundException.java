package com.claim_service.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	
	public CustomerIdNotFoundException(String message) {
		super(message);
	}

}
