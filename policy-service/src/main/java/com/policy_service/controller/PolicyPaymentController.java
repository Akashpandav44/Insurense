package com.policy_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy_service.dto.PaymentRequest;
import com.policy_service.entity.PolicyPayment;
import com.policy_service.service.PolicyPaymentServiceImp;

@RestController
@RequestMapping("/payment")
public class PolicyPaymentController {
	
	private final PolicyPaymentServiceImp service;
	
	public PolicyPaymentController(PolicyPaymentServiceImp service) {
		this.service=service;
	}
	
	@PostMapping("/{policyId}")
	public ResponseEntity<PolicyPayment> create(@RequestBody PaymentRequest dto, @PathVariable String policyId){
		
		PolicyPayment payment=service.created(dto, policyId);
		
		return ResponseEntity.ok(payment);
	}

}
