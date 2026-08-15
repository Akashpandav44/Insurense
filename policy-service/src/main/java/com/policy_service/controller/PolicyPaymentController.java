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

import com.policy_service.dto.PaymentRequestDto;
import com.policy_service.dto.PaymentResponse;
import com.policy_service.entity.PolicyPayment;
import com.policy_service.service.PolicyPaymentServiceImp;

@RestController
@RequestMapping("/payment")
public class PolicyPaymentController {

	private final PolicyPaymentServiceImp service;

	public PolicyPaymentController(PolicyPaymentServiceImp service) {
		this.service = service;
	}

	@PostMapping("/{policyId}")
	public ResponseEntity<PolicyPayment> create(@RequestBody PaymentRequestDto dto, @PathVariable String policyId) {

		PolicyPayment payment = service.created(dto, policyId);

		return ResponseEntity.ok(payment);
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentResponse> findpayment(@PathVariable String paymentId) {

		PaymentResponse policyPayment = service.findData(paymentId);

		return ResponseEntity.ok(policyPayment);
	}

	@PutMapping("/{paymentId}")
	public ResponseEntity<PolicyPayment> update(@PathVariable String paymentId, @RequestBody PaymentResponse dto) {

		PolicyPayment payment = service.update(paymentId, dto);

		return ResponseEntity.ok(payment);
	}

	@DeleteMapping("/{paymentId}")
	public ResponseEntity<PolicyPayment> delete(@PathVariable String paymentId) {

		PolicyPayment payment = service.delete(paymentId);

		return ResponseEntity.ok(payment);
	}

}
