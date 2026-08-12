package com.policy_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.policy_service.dto.CustomerDto;
import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.dto.PolicyResponseDto;
import com.policy_service.entity.PolicyEntity;
import com.policy_service.exception.CustomerNotFoundException;
import com.policy_service.exception.PolicyIdNotFoundException;
import com.policy_service.repository.PolicyRepository;

@Service
public class PolicyServiceImp implements PolicyService{
	
	
	private PolicyRepository repository;
	private RestTemplate restTemplate;
	
	public PolicyServiceImp(PolicyRepository repository, RestTemplate restTemplate ) {
		this.repository=repository;
		this.restTemplate=restTemplate;
	}

	@Override
	public PolicyEntity create(PolicyRequestDto dto) {
		
		String url="http://localhost:9092/customer/"+dto.customerId();
		
		CustomerDto customer=restTemplate.getForObject( url, CustomerDto.class);
		
		if(customer==null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		
		PolicyEntity policy=new PolicyEntity();
		
		policy.setCustomerId(dto.customerId());
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
		
		
		return repository.save(policy);
	}

	@Override
	public PolicyEntity findData(String policyId) {
		
		PolicyEntity policy=repository.findByPolicyId(policyId).orElseThrow(()->
		 new PolicyIdNotFoundException("This PolicyId Not Available"));
		

		
		return policy;
	}

	@Override
	public PolicyEntity update(String policyId, PolicyResponseDto dto) {
		
		PolicyEntity entity=repository.findByPolicyId(policyId).orElseThrow(
				()-> new PolicyIdNotFoundException("This PolicyId Not Available"));
		
		entity.setCustomerId(dto.customerId());
		entity.setPolicyId(dto.policyId());
		entity.setPolicyType(dto.policyType());
		entity.setPremiumAmount(dto.premiumAmount());
		entity.setSumAssured(dto.sumAssured());
		entity.setStartDate(dto.startDate());
		entity.setEndDate(dto.endDate());
		entity.setPaymentFrequency(dto.paymentFrequency());
		entity.setStatus(dto.status());
		entity.setCreatedBy(dto.createdBy());
		entity.setCreatedDate(dto.createdDate());
		entity.setUpdatedBy(dto.updatedBy());
		entity.setUpdatedDate(dto.updatedDate());
		
		return repository.save(entity);
	}

}
