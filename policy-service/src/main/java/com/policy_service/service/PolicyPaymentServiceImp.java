package com.policy_service.service;

import org.springframework.stereotype.Service;

import com.policy_service.dto.PaymentRequest;
import com.policy_service.entity.PolicyEntity;
import com.policy_service.entity.PolicyPayment;
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
	public PolicyPayment created(PaymentRequest dto, String policyId) {
		
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

}
