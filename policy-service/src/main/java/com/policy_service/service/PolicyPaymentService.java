package com.policy_service.service;

import com.policy_service.dto.PaymentRequest;
import com.policy_service.entity.PolicyPayment;

public interface PolicyPaymentService {


	PolicyPayment created(PaymentRequest dto, String policyId);

}
