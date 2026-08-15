package com.claim_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="claim-Details")
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="claim_id", unique = true, nullable = false)
	private String claimId;
	
	@Column(name="claim_name")
	private String claimName;
	
	@Column(name="policy_id")
	private String policyId;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="claim_type")
	private String claimType;
	
	@Column(name="claim_amount")
	private BigDecimal claimAmount;
	
	@Column(name="incident_date")
	private LocalDate incidentDate;
	
	@Column(name="claim_date")
	private LocalDateTime claimDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="approved_amount")
	private BigDecimal approvedAmount;
	
	@Column(name="rejection_reason")
	private String rejectionReason;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	public Claim() {}
	
	public Claim(Long id, String claimId, String claimName, String policyId, String customerId, String claimType,
			BigDecimal claimAmount, LocalDate incidentDate, LocalDateTime claimDate, String description, String status,
			BigDecimal approvedAmount, String rejectionReason, LocalDateTime createdDate, LocalDateTime updatedDate,
			String createdBy, String updatedBy) {
		this.id = id;
		this.claimId = claimId;
		this.claimName = claimName;
		this.policyId = policyId;
		this.customerId = customerId;
		this.claimType = claimType;
		this.claimAmount = claimAmount;
		this.incidentDate = incidentDate;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
		this.approvedAmount = approvedAmount;
		this.rejectionReason = rejectionReason;
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

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getClaimName() {
		return claimName;
	}

	public void setClaimName(String claimName) {
		this.claimName = claimName;
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

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public BigDecimal getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

	public LocalDate getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(LocalDate incidentDate) {
		this.incidentDate = incidentDate;
	}

	public LocalDateTime getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDateTime claimDate) {
		this.claimDate = claimDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
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
