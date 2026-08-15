package com.claim_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim_service.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

	Optional<Claim> findByClaimId(String claimId);




}
