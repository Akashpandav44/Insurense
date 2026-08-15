package com.claim_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(ClaimIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(ClaimIdNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerIdNotFound(CustomerIdNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	@ExceptionHandler(PolicyIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePolicyIdNotFound(PolicyIdNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
