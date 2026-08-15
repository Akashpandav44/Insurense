package com.policy_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex) {

		ErrorResponse error = new ErrorResponse();

		error.setMessage(ex.getMessage());
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setLocalDate(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(PaymentDetailsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePaymentDetailsNotFound(PaymentDetailsNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setLocalDate(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setMessage(ex.getMessage());
		error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setLocalDate(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}
