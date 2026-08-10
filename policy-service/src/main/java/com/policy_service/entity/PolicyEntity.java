package com.policy_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="policy_info")
public class PolicyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="policy_id")
	private String policyId;
	
	
	@Column(name="customer_id")
	private String customerId;

	@Column(name="policy_type")
	private String policyType;
	
	@Column(name="premium_amount")
	private BigDecimal premiumAmount;
	
	@Column(name="sum_assured")
	private BigDecimal sumAssured;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="payment_frequency")
	private String paymentFrequency;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	public PolicyEntity() {}

	public PolicyEntity(Long id, String policyId, String customerId, String policyType, BigDecimal premiumAmount,
			BigDecimal sumAssured, LocalDate startDate, LocalDate endDate, String paymentFrequency, String status,
			LocalDateTime createdDate, LocalDateTime updatedDate, String createdBy, String updatedBy) {
		this.id = id;
		this.policyId = policyId;
		this.customerId = customerId;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.sumAssured = sumAssured;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentFrequency = paymentFrequency;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public BigDecimal getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public BigDecimal getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(BigDecimal sumAssured) {
		this.sumAssured = sumAssured;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	

}
