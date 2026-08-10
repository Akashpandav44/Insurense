package com.policy_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.entity.PolicyEntity;
import com.policy_service.service.PolicyServiceImp;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	private PolicyServiceImp service;
	
	public PolicyController(PolicyServiceImp service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<PolicyEntity> policy( 
			@RequestBody PolicyRequestDto dto) {
		
		PolicyEntity policy=service.create(dto);
		
		return ResponseEntity.ok(policy);
	}

}
