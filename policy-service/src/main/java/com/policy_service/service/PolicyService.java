package com.policy_service.service;

import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.dto.PolicyResponseDto;
import com.policy_service.entity.PolicyEntity;

public interface PolicyService {


	PolicyEntity create(PolicyRequestDto dto);

	PolicyEntity findData(String policyId);

	PolicyEntity update(String policyId, PolicyResponseDto dto);

}
