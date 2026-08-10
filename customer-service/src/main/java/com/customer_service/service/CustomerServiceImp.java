package com.customer_service.service;

import org.springframework.stereotype.Service;

import com.customer_service.dto.CustomerRequestDto;
import com.customer_service.dto.CustomerResponseDto;
import com.customer_service.entity.Customer;
import com.customer_service.exception.CustomerNotFoundException;
import com.customer_service.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	private CustomerRepository repository;
	
	public CustomerServiceImp(CustomerRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public CustomerResponseDto CustomerData(CustomerRequestDto dto) {
		
		Customer customer=new Customer();
		
		customer.setCustomerId(dto.getCustomerId());
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		customer.setMobile(dto.getMobile());
		customer.setDateOfBirth(dto.getDateOfBirth());
		customer.setGender(dto.getGender());
		customer.setAddress(dto.getAddress());
		customer.setCity(dto.getCity());
		customer.setState(dto.getState());
		customer.setPincode(dto.getPincode());
		customer.setStatus(dto.getStatus());
		customer.setCreatedDate(dto.getCreatedDate());
		customer.setUpdatedDate(dto.getUpdatedDate());
		
		Customer savedCustomer=repository.save(customer);
	 
		CustomerResponseDto response=new CustomerResponseDto();
		
		response.setId(savedCustomer.getId());
		response.setCustomerId(savedCustomer.getCustomerId());
	    response.setFirstName(savedCustomer.getFirstName());
	    response.setLastName(savedCustomer.getLastName());
	    response.setEmail(savedCustomer.getEmail());
	    response.setMobile(savedCustomer.getMobile());
	    response.setDateOfBirth(savedCustomer.getDateOfBirth());
	    response.setGender(savedCustomer.getGender());
	    response.setAddress(savedCustomer.getAddress());
	    response.setCity(savedCustomer.getCity());
	    response.setState(savedCustomer.getState());
	    response.setPincode(savedCustomer.getPincode());
	    response.setStatus(savedCustomer.getStatus());
	    response.setCreatedDate(savedCustomer.getCreatedDate());
	    response.setUpdatedDate(savedCustomer.getUpdatedDate());
		
		
	    return response;
	}

	@Override
	public CustomerResponseDto FindById(Long id) {
	  
		Customer customer=repository.findById(id).orElseThrow(() ->
		new CustomerNotFoundException(id+" :This Customer Id Not Available "));
		
		CustomerResponseDto response = new CustomerResponseDto();

		response.setId(customer.getId());
		response.setCustomerId(customer.getCustomerId());
		response.setFirstName(customer.getFirstName());
		response.setLastName(customer.getLastName());
		response.setEmail(customer.getEmail());
		response.setMobile(customer.getMobile());
		response.setDateOfBirth(customer.getDateOfBirth());
		response.setGender(customer.getGender());
		response.setAddress(customer.getAddress());
		response.setCity(customer.getCity());
		response.setState(customer.getState());
		response.setPincode(customer.getPincode());
		response.setStatus(customer.getStatus());
		response.setCreatedDate(customer.getCreatedDate());
		response.setUpdatedDate(customer.getUpdatedDate());

		return response;
	}

	@Override
	public CustomerResponseDto updateData(Long id, CustomerRequestDto dto) {
		
		Customer customer=repository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer Not Found "));
		
		
		customer.setCustomerId(dto.getCustomerId());
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		customer.setMobile(dto.getMobile());
		customer.setDateOfBirth(dto.getDateOfBirth());
		customer.setGender(dto.getGender());
		customer.setAddress(dto.getAddress());
		customer.setCity(dto.getCity());
		customer.setState(dto.getState());
		customer.setPincode(dto.getPincode());
		customer.setStatus(dto.getStatus());
		customer.setCreatedDate(dto.getCreatedDate());
		customer.setUpdatedDate(dto.getUpdatedDate());
		
		Customer save=repository.save(customer);
		
		CustomerResponseDto update=new CustomerResponseDto();
		
		update.setCustomerId(save.getCustomerId());
		update.setFirstName(save.getFirstName());
		update.setLastName(save.getLastName());
		update.setEmail(save.getEmail());
		update.setMobile(save.getMobile());
		update.setDateOfBirth(save.getDateOfBirth());
		update.setGender(save.getGender());
		update.setAddress(save.getAddress());
		update.setCity(save.getCity());
		update.setState(save.getState());
		update.setPincode(save.getPincode());
		update.setStatus(save.getStatus());
		update.setCreatedDate(save.getCreatedDate());
		update.setUpdatedDate(save.getUpdatedDate());
		
		return update;
		
		
	}

}
