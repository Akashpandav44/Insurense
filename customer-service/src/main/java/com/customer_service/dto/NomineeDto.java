package com.customer_service.dto;

import java.math.BigDecimal;

public record NomineeDto(String nomineeId, String nomineeName,
		String relationship, String mobile, BigDecimal percentage) {

}
