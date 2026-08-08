package com.customer_service.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_service.dto.NomineeDto;
import com.customer_service.dto.NomineeResponseDto;
import com.customer_service.entity.Customer;
import com.customer_service.entity.Nominee;
import com.customer_service.service.NomineeServiceImp;

@RestController
@RequestMapping("/nominee")
public class NomineeController {
	
	@Autowired
	private NomineeServiceImp service;
	
	@PostMapping("/{customerId}")
	public ResponseEntity<Nominee> nominee(@PathVariable String customerId,
			@RequestBody NomineeDto dto){
		
		Nominee nominee=service.create(customerId, dto);
		
		return ResponseEntity.ok(nominee);
	}
	@GetMapping("/{customerId}/id/{id}")
	public ResponseEntity<NomineeResponseDto> find(@PathVariable String customerId ,  @PathVariable Long id ){
		
		NomineeResponseDto nominee=service.finddata(customerId, id);
		
		return ResponseEntity.ok(nominee);
	}

}
