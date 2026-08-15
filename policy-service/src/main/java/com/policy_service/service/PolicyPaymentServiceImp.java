package com.policy_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.policy_service.dto.PaymentRequestDto;
import com.policy_service.dto.PaymentResponse;
import com.policy_service.entity.PolicyEntity;
import com.policy_service.entity.PolicyPayment;
import com.policy_service.exception.PaymentDetailsNotFoundException;
import com.policy_service.exception.PolicyIdNotFoundException;
import com.policy_service.repository.PolicyPaymentRepository;
import com.policy_service.repository.PolicyRepository;

@Service
public class PolicyPaymentServiceImp implements PolicyPaymentService {

	private final PolicyPaymentRepository repository;
	private final PolicyRepository policyRepository;
	
	public PolicyPaymentServiceImp(PolicyPaymentRepository repository, PolicyRepository policyRepository) {
		this.repository=repository;
		this.policyRepository=policyRepository;
	}
	
	@Override
	public PolicyPayment created(PaymentRequestDto dto, String policyId) {
		
		PolicyEntity entity=policyRepository.findByPolicyId(policyId).orElseThrow(()
				-> new PolicyIdNotFoundException("Policy Id Not available"));
		
		PolicyPayment payment=new PolicyPayment();
		
		payment.setPaymentId(dto.paymentId());
		payment.setPolicy(entity);
		payment.setAmount(dto.amount());
		payment.setPaymentDate(dto.paymentDate());
		payment.setPaymentMode(dto.paymentMode());
		payment.setTransactionId(dto.transactionId());
		payment.setStatus(dto.status());
		payment.setCreatedDate(dto.createdDate());
		payment.setCreatedBy(dto.createdBy());
		payment.setUpdatedDate(dto.updatedDate());
		payment.setUpdatedBy(dto.updatedBy());
		
		return repository.save(payment);
		
	}

	@Override
	public PaymentResponse findData(String paymentId) {
		
		PolicyPayment policy=repository.findByPaymentId(paymentId).orElseThrow(
				() -> new PaymentDetailsNotFoundException("payment details not available"));
		
		  return new PaymentResponse(
		            policy.getPaymentId(),
		            policy.getPolicy().getPolicyId(),
		            policy.getAmount(),
		            policy.getPaymentDate(),
		            policy.getPaymentMode(),
		            policy.getTransactionId(),
		            policy.getStatus(),
		            policy.getCreatedDate(),
		            policy.getCreatedBy(),
		            policy.getUpdatedDate(),
		            policy.getUpdatedBy()
		    );
	}

	@Override
	public PolicyPayment update(String paymentId, PaymentResponse dto) {
		
		PolicyPayment payment=repository.findByPaymentId(paymentId)
				.orElseThrow(() -> new PaymentDetailsNotFoundException("payment details not available"));
		
		payment.setPaymentId(dto.paymentId());
		payment.getPolicy().setPolicyId(dto.policyId());;
		payment.setAmount(dto.amount());
		payment.setPaymentDate(dto.paymentDate());
		payment.setPaymentMode(dto.paymentMode());
		payment.setTransactionId(dto.transactionId());
		payment.setStatus(dto.status());
		payment.setCreatedDate(dto.createdDate());
		payment.setCreatedBy(dto.createdBy());
		payment.setUpdatedDate(dto.updatedDate());
		payment.setUpdatedBy(dto.updatedBy());
		
		return repository.save(payment);
	}

	public PolicyPayment delete(String paymentId) {
		
		PolicyPayment payment=repository.findByPaymentId(paymentId)
				.orElseThrow(() -> new PaymentDetailsNotFoundException("payment details not available"));
		
		payment.setStatus("DELETED");
		payment.setUpdatedDate(LocalDateTime.now());
		return payment;
	}

}
