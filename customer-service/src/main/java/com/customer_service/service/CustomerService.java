package com.customer_service.service;

import com.customer_service.dto.CustomerRequestDto;
import com.customer_service.dto.CustomerResponseDto;

public interface CustomerService {

	CustomerResponseDto CustomerData(CustomerRequestDto dto);

	CustomerResponseDto FindById(Long id);

}
