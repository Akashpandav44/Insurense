package com.claim_service.service;

import com.claim_service.dto.ClaimRequestDto;
import com.claim_service.dto.ClaimResponseDto;
import com.claim_service.entity.Claim;

public interface ClaimService {

	Claim create(ClaimRequestDto dto);

	ClaimResponseDto readData(String claimId);

	Claim update(String claimId, ClaimRequestDto dto);

}
