package com.policy_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentRequest(String paymentId, String policyId, BigDecimal amount, LocalDateTime paymentDate,
		 String paymentMode, String transactionId, String status, LocalDateTime createdDate, String createdBy, 
		 LocalDateTime updatedDate, String updatedBy) {

}
