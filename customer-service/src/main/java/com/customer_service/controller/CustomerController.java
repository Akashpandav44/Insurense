package com.customer_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_service.dto.CustomerRequestDto;
import com.customer_service.dto.CustomerResponseDto;
import com.customer_service.service.CustomerServiceImp;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerServiceImp service;
	
	public CustomerController(CustomerServiceImp service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto dto) {
		
		CustomerResponseDto customer=service.CustomerData(dto);
		
		return  ResponseEntity.ok(customer);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> findData(@PathVariable Long id){
		
		CustomerResponseDto response=service.FindById(id);
		
		return ResponseEntity.ok(response);
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> updateData(@PathVariable Long id, @RequestBody CustomerRequestDto dto) {
		
		CustomerResponseDto response=service.updateData(id,dto);
		
		return ResponseEntity.ok(response);
	}

}
