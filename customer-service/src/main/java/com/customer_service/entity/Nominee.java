package com.customer_service.entity;

import java.math.BigDecimal;

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
@Table(name="Nominee-Information")
public class Nominee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nominee_id", unique = true, nullable = false)
	private String nomineeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id")
	private  Customer customer;
	
	@Column(name="nominee_name")
	private String nomineeName;
	
	@Column(name="relationship")
	private String relationship;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="percentage", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentage;
	
	public Nominee() {
		
	}
	
	public Nominee(Long id, String nomineeId, Customer customer, String nomineeName,
			String relationship, String mobile, 
			BigDecimal percentage) {
		this.id=id;
		this.nomineeId=nomineeId;
		this.customer=customer;
		this.nomineeName=nomineeName;
		this.relationship=relationship;
		this.mobile=mobile;
		this.percentage=percentage;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(String nomineeId) {
		this.nomineeId = nomineeId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	
	

}
