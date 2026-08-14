package com.customer_service.service;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer_service.dto.NomineeDto;
import com.customer_service.dto.NomineeResponseDto;
import com.customer_service.entity.Customer;
import com.customer_service.entity.Nominee;
import com.customer_service.exception.CustomerNotFoundException;
import com.customer_service.exception.NomineeNotFoundException;
import com.customer_service.exception.NomineePercentageExceededException;
import com.customer_service.repository.CustomerRepository;
import com.customer_service.repository.NomineeRepository;

@Service
public class NomineeServiceImp implements NomineeService{

	
	private NomineeRepository repository;
	private CustomerRepository customerRepo;
	
	public NomineeServiceImp(NomineeRepository repository, CustomerRepository customerRepo) {
		this.repository=repository;
		this.customerRepo=customerRepo;
	}
	
	@Override
	public Nominee create(String customerId, NomineeDto dto) {

	    Customer customer = customerRepo.findByCustomerId(customerId)
	            .orElseThrow(() ->
	                    new CustomerNotFoundException(
	                            "customer not found " + customerId));

	    BigDecimal newPercentage = dto.percentage();

	    if (newPercentage == null) {
	        throw new RuntimeException("Percentage is required");
	    }

	    if (newPercentage.compareTo(BigDecimal.ZERO) <= 0 ||
	            newPercentage.compareTo(new BigDecimal("100")) > 0) {

	        throw new InvalidParameterException(
	                "Percentage must be between 1 and 100");
	    }

	    List<Nominee> existingNominees =
	            repository.findByCustomerCustomerId(customerId);

	    BigDecimal existingTotal = existingNominees.stream()
	            .map(Nominee::getPercentage)
	            .reduce(BigDecimal.ZERO, BigDecimal::add);

	    BigDecimal newTotal = existingTotal.add(newPercentage);

	    if (newTotal.compareTo(new BigDecimal("100")) > 0) {

	        throw new NomineePercentageExceededException(
	                "Total nominee percentage cannot exceed 100%. " +
	                "Existing: " + existingTotal +
	                "%, New: " + newPercentage +
	                "%, Total: " + newTotal + "%");
	    }

	    Nominee nominee = new Nominee();

	    nominee.setNomineeId(dto.nomineeId());
	    nominee.setNomineeName(dto.nomineeName());
	    nominee.setRelationship(dto.relationship());
	    nominee.setMobile(dto.mobile());
	    nominee.setPercentage(newPercentage);
	    nominee.setCustomer(customer);

	    return repository.save(nominee);
	}

	@Override
	public NomineeResponseDto finddata(String nomineeId) {
		
		 Nominee nominee =repository.findByNomineeId(nomineeId).orElseThrow(
				 () -> new NomineeNotFoundException(nomineeId+ " This Id Not Avialable in Nominee Table "));
				 
		    return new NomineeResponseDto(
		            nominee.getCustomer().getCustomerId(),
		            nominee.getNomineeId(),
		            nominee.getNomineeName(),
		            nominee.getRelationship(),
		            nominee.getMobile(),
		            nominee.getPercentage()
		    );
	}

	@Override
	public Nominee update(String nomineeId, NomineeDto dto) {
		
		
		Nominee nominee=repository.findByNomineeId(nomineeId).orElseThrow(
				() -> new NomineeNotFoundException("Nominee Not Available"));
		
	    nominee.setNomineeName(dto.nomineeName());
	    nominee.setRelationship(dto.relationship());
	    nominee.setMobile(dto.mobile());
	    nominee.setPercentage(dto.percentage());
		
		return repository.save(nominee);
	}

	public Nominee delete(String nomineeId) {
		
		Nominee nominee=repository.findByNomineeId(nomineeId).orElseThrow(
				() -> new NomineeNotFoundException("Nominee Not Available "));
		
		
		return nominee;
	}



}
