package com.policy_service.service;

import org.springframework.stereotype.Service;


import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.entity.PolicyEntity;
import com.policy_service.repository.PolicyRepository;

@Service
public class PolicyServiceImp implements PolicyService{
	
	
	private PolicyRepository repository;
	
	public PolicyServiceImp(PolicyRepository repository ) {
		this.repository=repository;
	}

	@Override
	public PolicyEntity create(PolicyRequestDto dto) {
		
		
		PolicyEntity policy=new PolicyEntity();
		
		policy.setPolicyId(dto.policyId());
		policy.setPolicyType(dto.policyType());
		policy.setPremiumAmount(dto.premiumAmount());
		policy.setSumAssured(dto.sumAssured());
		policy.setStartDate(dto.startDate());
		policy.setEndDate(dto.endDate());
		policy.setPaymentFrequency(dto.paymentFrequency());
		policy.setStatus(dto.status());
		policy.setCreatedBy(dto.createdBy());
		policy.setCreatedDate(dto.createdDate());
		policy.setUpdatedBy(dto.updatedBy());
		policy.setUpdatedDate(dto.updatedDate());
		policy.setCustomerId(dto.customerId());
		
		return repository.save(policy);
	}

}
