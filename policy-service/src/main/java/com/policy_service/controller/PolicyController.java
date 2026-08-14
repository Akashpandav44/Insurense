package com.policy_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.dto.PolicyResponseDto;
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
	
	@GetMapping("/{policyId}")
	public ResponseEntity<PolicyEntity> findData(@PathVariable String policyId){
		
		PolicyEntity dto=service.findData(policyId);
		
		return ResponseEntity.ok(dto);
	}
	@PutMapping("/{policyId}")
	public ResponseEntity<PolicyEntity> updatePolicy(@PathVariable String policyId, @RequestBody PolicyResponseDto dto){
		
		PolicyEntity entity=service.update(policyId, dto);
		
		return ResponseEntity.ok(entity);
	}
	@DeleteMapping("/{policyId}")
	public ResponseEntity<PolicyEntity> deletePolicy(@PathVariable String policyId) {
		
		PolicyEntity dto=service.delete(policyId);
		
		return ResponseEntity.ok(dto);
	}

}
