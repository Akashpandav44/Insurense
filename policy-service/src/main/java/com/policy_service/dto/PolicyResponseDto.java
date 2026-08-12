package com.policy_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PolicyResponseDto(String policyId,String customerId, String policyType, BigDecimal premiumAmount
		,BigDecimal sumAssured, LocalDate startDate, LocalDate endDate,
		String paymentFrequency, String status, LocalDateTime createdDate, LocalDateTime updatedDate,
		String createdBy, String updatedBy) {

}
