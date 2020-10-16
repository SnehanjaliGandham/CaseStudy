package com.casestudy.cms.bean;

import java.sql.Timestamp;

public class Transaction {
	
	private int transactionId;
	private int policyNumber;
	private String transactionAmount;
	private Timestamp transactionDate;
	private String status;
	
	public Transaction(int transactionId, int policyNumber, String transactionAmount, Timestamp transactionDate,
			String status) {
		super();
		this.transactionId = transactionId;
		this.policyNumber = policyNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.status = status;
	}
	
	public Transaction() {
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", policyNumber=" + policyNumber + ", transactionAmount="
				+ transactionAmount + ", transactionDate=" + transactionDate + ", status=" + status + "]";
	}
	

	
}
