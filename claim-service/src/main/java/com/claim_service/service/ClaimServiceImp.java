package com.claim_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.claim_service.dto.ClaimRequestDto;
import com.claim_service.dto.ClaimResponseDto;
import com.claim_service.dto.CustomerDto;
import com.claim_service.dto.PolicyDto;
import com.claim_service.entity.Claim;
import com.claim_service.exception.ClaimIdNotFoundException;
import com.claim_service.exception.CustomerIdNotFoundException;
import com.claim_service.exception.PolicyIdNotFoundException;
import com.claim_service.repository.ClaimRepository;

@Service
public class ClaimServiceImp implements ClaimService {
	
	private final ClaimRepository repository;
	private final RestTemplate restTemplate;
	
	public ClaimServiceImp(ClaimRepository repository, RestTemplate restTemplate) {
		this.repository=repository;
		this.restTemplate=restTemplate;
	}

	@Override
	public Claim create(ClaimRequestDto dto) {
		
		CustomerDto customer=restTemplate.getForObject("http://localhost:9092/customer/"
		+dto.customerId(), CustomerDto.class);
		
		if(customer==null) {
			throw new CustomerIdNotFoundException(dto.customerId()+"  This customerId Not Available in customer Table");
		}
		
		PolicyDto policy=restTemplate.getForObject("http://localhost:9093/policy/"+dto.policyId(), PolicyDto.class);
		
		if(policy==null) {
			throw new PolicyIdNotFoundException(dto.policyId()+" This policyId is Not Available in policy Table");
		}
		
		Claim claim=new Claim();
		
		claim.setClaimId(dto.claimId());
		claim.setClaimName(dto.claimName());
		claim.setPolicyId(dto.policyId());
		claim.setCustomerId(dto.customerId());
		claim.setClaimType(dto.claimType());
		claim.setClaimAmount(dto.claimAmount());
		claim.setIncidentDate(dto.incidentDate());
		claim.setClaimDate(dto.claimDate());
		claim.setDescription(dto.description());
		claim.setStatus(dto.status());
		claim.setApprovedAmount(dto.approvedAmount());
		claim.setRejectionReason(dto.rejectionReason());
		claim.setCreatedDate(dto.createdDate());
		claim.setCreatedBy(dto.createdBy());
		claim.setUpdatedDate(dto.updatedDate());
		claim.setUpdatedBy(dto.updatedBy());
		
		return repository.save(claim);
	}

	@Override
	public ClaimResponseDto readData(String claimId) {
		
		Claim claim=repository.findByClaimId(claimId).orElseThrow(()->
				new ClaimIdNotFoundException("Claim Id not Available"));
				
		
		return new ClaimResponseDto(claim.getClaimId(),
	            claim.getClaimName(),
	            claim.getPolicyId(),
	            claim.getCustomerId(),
	            claim.getClaimType(),
	            claim.getClaimAmount(),
	            claim.getIncidentDate(),
	            claim.getClaimDate(),
	            claim.getDescription(),
	            claim.getStatus(),
	            claim.getApprovedAmount(),
	            claim.getRejectionReason(),
	            claim.getCreatedDate(),
	            claim.getUpdatedDate(),
	            claim.getCreatedBy(),
	            claim.getUpdatedBy());
	}

	@Override
	public Claim update(String claimId, ClaimRequestDto dto) {
		
		Claim claim=repository.findByClaimId(claimId).orElseThrow(() ->
		 new ClaimIdNotFoundException("Claim Id Not Found"));
		

		claim.setClaimId(dto.claimId());
		claim.setClaimName(dto.claimName());
		claim.setPolicyId(dto.policyId());
		claim.setCustomerId(dto.customerId());
		claim.setClaimType(dto.claimType());
		claim.setClaimAmount(dto.claimAmount());
		claim.setIncidentDate(dto.incidentDate());
		claim.setClaimDate(dto.claimDate());
		claim.setDescription(dto.description());
		claim.setStatus(dto.status());
		claim.setApprovedAmount(dto.approvedAmount());
		claim.setRejectionReason(dto.rejectionReason());
		claim.setCreatedDate(dto.createdDate());
		claim.setCreatedBy(dto.createdBy());
		claim.setUpdatedDate(dto.updatedDate());
		claim.setUpdatedBy(dto.updatedBy());
		
		return repository.save(claim);
	}

}
