package com.casestudy.cms.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionModel {
	
	private int transactionId;
	private int policyNumber;
	private String transactionAmount;
	private Timestamp transactionDate;
	private String status;

	
	public TransactionModel() {
		
	}


	public TransactionModel(int transactionId, int policyNumber, String transactionAmount, Timestamp transactionDate,
			String status) {
		super();
		this.transactionId = transactionId;
		this.policyNumber = policyNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="transaction_id")
	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name="policy_number" , nullable=false)
	public int getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	@Column(name="transaction_amount", nullable=false)
	public String getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Column(name="transaction_date" ,  nullable=false)
	public Timestamp getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name="status",  nullable=false)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
