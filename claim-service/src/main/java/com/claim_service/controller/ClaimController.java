package com.claim_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim_service.dto.ClaimRequestDto;
import com.claim_service.dto.ClaimResponseDto;
import com.claim_service.entity.Claim;
import com.claim_service.service.ClaimServiceImp;

@RestController
@RequestMapping("/claim")
public class ClaimController {
	
	private final ClaimServiceImp service;
	
	public ClaimController(ClaimServiceImp service) {
		this.service=service;
	}
	@PostMapping
	public ResponseEntity<Claim> create(@RequestBody ClaimRequestDto dto,
			@RequestParam String customerId, 
			@RequestParam String policyId){
		
		Claim claim=service.create(dto);
		
		return ResponseEntity.ok(claim);
	}
	@GetMapping("/{claimId}")
	public ResponseEntity<ClaimResponseDto> readData(@PathVariable String claimId){
		
		ClaimResponseDto response=service.readData(claimId);
		
		return ResponseEntity.ok(response);
	}
	@PutMapping("/{claimId}")
	public ResponseEntity<Claim> update(@PathVariable String claimId, @RequestBody ClaimRequestDto dto){
		
		Claim claim=service.update(claimId, dto);
		
		return ResponseEntity.ok(claim);
	}

}
