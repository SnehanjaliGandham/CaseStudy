package com.casestudy.cms.bean;

import java.util.Date;

public class Premium {
	
	private int policyNumber;
	private String totalPolicyAmount;
	private String premiumAmount;
	private String paidAmount;
	private String dueAmount="0.00";
	private Date dueDate;
	private String premiumStatus;
	private String policyStatus;
	
	public Premium() {
		
	}

	
	public Premium(int policyNumber, String totalPolicyAmount, String premiumAmount, String paidAmount,
			String dueAmount, Date dueDate, String premiumStatus, String policyStatus) {
		super();
		this.policyNumber = policyNumber;
		this.totalPolicyAmount = totalPolicyAmount;
		this.premiumAmount = premiumAmount;
		this.paidAmount = paidAmount;
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.premiumStatus = premiumStatus;
		this.policyStatus = policyStatus;
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


	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
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


	@Override
	public String toString() {
		return "Premium [policyNumber=" + policyNumber + ", totalPolicyAmount=" + totalPolicyAmount + ", premiumAmount="
				+ premiumAmount + ", paidAmount=" + paidAmount + ", dueAmount=" + dueAmount + ", dueDate=" + dueDate
				+ ", premiumStatus=" + premiumStatus + ", policyStatus=" + policyStatus + "]";
	}

	
	
	

} 
