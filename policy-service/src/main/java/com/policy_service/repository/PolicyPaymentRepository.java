package com.policy_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy_service.entity.PolicyPayment;

@Repository
public interface PolicyPaymentRepository extends JpaRepository<PolicyPayment, Long> {

}
