package com.policy_service.entity;

import java.math.BigDecimal;
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
@Table(name="Policy-payment")
public class PolicyPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="payment_id", nullable = false, unique = true)
	private String paymentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="policy_id", referencedColumnName = "policy_id")
	private PolicyEntity policy;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	public PolicyPayment() {
		
	}

	public PolicyPayment(Long id, String paymentId, PolicyEntity policy, BigDecimal amount, LocalDateTime paymentDate,
			String paymentMode, String transactionId, String status, LocalDateTime createdDate, String createdBy,
			LocalDateTime updatedDate, String updatedBy) {
		this.id = id;
		this.paymentId = paymentId;
		this.policy = policy;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.transactionId = transactionId;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public PolicyEntity getPolicy() {
		return policy;
	}

	public void setPolicy(PolicyEntity policy) {
		this.policy = policy;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	

}
