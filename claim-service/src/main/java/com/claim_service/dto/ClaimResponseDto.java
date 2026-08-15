package com.claim_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClaimResponseDto(String claimId, String claimName, String policyId, String customerId, String claimType, BigDecimal claimAmount, LocalDate incidentDate, LocalDateTime claimDate,
		 String description, String status, BigDecimal approvedAmount, String rejectionReason,
		 LocalDateTime createdDate, LocalDateTime updatedDate, String createdBy, String updatedBy) {

}
