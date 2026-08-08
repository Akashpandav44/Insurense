package com.customer_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex) {
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(InvalidPercentageException.class)
	public ResponseEntity<ErrorResponse> handleInvalidPercentage(InvalidPercentageException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
				
	}
	@ExceptionHandler(NomineePercentageExceededException.class)
	public ResponseEntity<ErrorResponse> handleNomineePercentageExceeded(NomineePercentageExceededException ex){
		
		ErrorResponse error=new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	@ExceptionHandler(NomineeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNomineeNotFound(NomineeNotFoundException ex){
		
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
