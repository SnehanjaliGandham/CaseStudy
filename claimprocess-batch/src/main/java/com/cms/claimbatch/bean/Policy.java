package com.cms.claimbatch.bean;

import java.sql.Date;

public class Policy {
	
	
	private int policyNumber;
	private int userId;
	private String totalPolicyAmount;
	private String premiumAmount;
	private String paidAmount;
	private String dueAmount;
	private Date dueDate;
	private String premiumStatus;
	private String policyStatus;
	
	public Policy() {
		
	}
	
	
	
	public Policy(int policyNumber, int userId, String totalPolicyAmount, String premiumAmount, String paidAmount,
			String dueAmount, Date dueDate, String premiumStatus, String policyStatus) {
		super();
		this.policyNumber = policyNumber;
		this.userId = userId;
		this.totalPolicyAmount = totalPolicyAmount;
		this.premiumAmount = premiumAmount;
		this.paidAmount = paidAmount;
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.premiumStatus = premiumStatus;
		this.policyStatus = policyStatus;
	}



	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTotalPolicyAmount() {
		return totalPolicyAmount;
	}
	public void setTotalPolicyAmount(String totalPolicyAmount) {
		this.totalPolicyAmount = totalPolicyAmount;
	}
	public String getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getPremiumStatus() {
		return premiumStatus;
	}
	public void setPremiumStatus(String premiumStatus) {
		this.premiumStatus = premiumStatus;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	
	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", userId=" + userId + ", totalPolicyAmount="
				+ totalPolicyAmount + ", premiumAmount=" + premiumAmount + ", paidAmount=" + paidAmount + ", dueAmount="
				+ dueAmount + ", dueDate=" + dueDate + ", premiumStatus=" + premiumStatus + ", policyStatus="
				+ policyStatus + "]";
	}
	
	
	
	

	
	
	
}
