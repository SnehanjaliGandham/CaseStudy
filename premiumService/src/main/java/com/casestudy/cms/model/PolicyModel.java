package com.casestudy.cms.model;

import java.sql.Date;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="policy")
public class PolicyModel {
	
	
	
	private int policyNumber;
	private int userId;
	private String totalPolicyAmount;
	private String premiumAmount;
	private String paidAmount;
	private String dueAmount;
	private Date dueDate;
	private String premiumStatus;
	private String policyStatus;

	public PolicyModel() {
		
	}
	

	public PolicyModel(int policyNumber, int userId, String totalPolicyAmount, String premiumAmount, String paidAmount,
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



	@Id
	@Column(name="policy_number")
	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	@Column(name="user_id" , nullable=false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	@Column(name="total_policy_amount" , nullable=false)
	public String getTotalPolicyAmount() {
		return totalPolicyAmount;
	}

	public void setTotalPolicyAmount(String totalPolicyAmount) {
		this.totalPolicyAmount = totalPolicyAmount;
	}

	@Column(name="premium_amount" , nullable=false)
	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	@Column(name="paid_amount",  nullable=false)
	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	@Column(name="due_amount" ,  nullable=false)
	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	@Column(name="due_date" ,  nullable=false)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name="premium_status" ,  nullable=false)
	public String getPremiumStatus() {
		return premiumStatus;
	}

	public void setPremiumStatus(String premiumStatus) {
		this.premiumStatus = premiumStatus;
	}

	@Column(name="policy_status" ,  nullable=false)
	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	
	
	
}
