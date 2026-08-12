package com.customer_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer_service.entity.Customer;
import com.customer_service.entity.Nominee;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long> {

	List<Nominee> findByCustomerCustomerId(String customerId);

	Optional<Nominee> findByIdAndCustomerCustomerId(Long id, String customerId);

	Optional<Nominee> findByNomineeId(String nomineeId);


}
