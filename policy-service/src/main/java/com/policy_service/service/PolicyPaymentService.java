package com.policy_service.service;

import com.policy_service.dto.PaymentRequestDto;
import com.policy_service.dto.PaymentResponse;
import com.policy_service.entity.PolicyPayment;

public interface PolicyPaymentService {


	PolicyPayment created(PaymentRequestDto dto, String policyId);

	PaymentResponse findData(String paymentId);

	PolicyPayment update(String paymentId, PaymentResponse dto);

}
