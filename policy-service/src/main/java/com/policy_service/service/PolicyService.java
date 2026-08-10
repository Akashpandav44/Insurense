package com.policy_service.service;

import com.policy_service.dto.PolicyRequestDto;
import com.policy_service.entity.PolicyEntity;

public interface PolicyService {


	PolicyEntity create(PolicyRequestDto dto);

}
