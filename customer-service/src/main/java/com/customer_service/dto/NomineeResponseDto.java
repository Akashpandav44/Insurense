package com.customer_service.dto;

import java.math.BigDecimal;

import com.customer_service.entity.Customer;

public record NomineeResponseDto(String customerId,
        String nomineeId,
        String nomineeName,
        String relationship,
        String mobile,
        BigDecimal percentage) {

}
