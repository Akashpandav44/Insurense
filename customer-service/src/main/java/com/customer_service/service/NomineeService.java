package com.customer_service.service;

import com.customer_service.dto.NomineeDto;
import com.customer_service.dto.NomineeResponseDto;
import com.customer_service.entity.Nominee;

public interface NomineeService {

	public Nominee create(String customerId, NomineeDto dto);

	

	NomineeResponseDto finddata(String customerId, Long id);

	

}
