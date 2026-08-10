package com.customer_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="customer_id",nullable = false, unique = true)
	private String customerId;
	
	@Column(name="first_name", nullable = true)
	private String firstName;
	
	@Column(name="last_name", nullable = true)
	private String lastName;
	
	@Column(name="email", nullable = true, unique = true)
	private String email;
	
	@Column(name="mobile" , nullable = true)
	private String mobile;
	
	@Column(name="date_of_birth", nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(name="gender", nullable = true)
	private String gender;
	
	@Column(name="address", nullable = true)
	private String address;
	
	@Column(name="city", nullable = true)
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode", nullable = true)
	private String pincode;
	
	@Column(name="status")
	private String status;
	
	@Column(name="create_date")
	private LocalDateTime createdDate;
	
	@Column(name="update_date")
	private LocalDateTime updatedDate;

	public Customer() {
		
	}

	public Customer(Long id,String customerId, String firstName, String lastName, String email, String mobile,
			LocalDate dateOfBirth, String gender, String address, String city, String state, String pincode,
			String status, LocalDateTime createdDate, LocalDateTime updatedDate) {
		this.id=id;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<Nominee> nominess=new ArrayList<>();
	
	
	
	
	
}
