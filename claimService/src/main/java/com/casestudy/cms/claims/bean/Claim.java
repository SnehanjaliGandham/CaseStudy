package com.casestudy.cms.claims.bean;

import java.sql.Timestamp;

public class Claim {
	
	
	private int claimId;
	private int policyNumber;
	private String claimAmount;
	private String claimReason;
	private String additionalComments;
	private String approvedClaimAmount;
	private Timestamp claimSubmissionDate;
	private String claimStatus;
	private String proofDocuments;
	
	
	public Claim(int claimId, int policyNumber, String claimAmount, String claimReason, String additionalComments,
			String approvedClaimAmount, Timestamp claimSubmissionDate, String claimStatus, String proofDocuments) {
		super();
		this.claimId = claimId;
		this.policyNumber = policyNumber;
		this.claimAmount = claimAmount;
		this.claimReason = claimReason;
		this.additionalComments = additionalComments;
		this.approvedClaimAmount = approvedClaimAmount;
		this.claimSubmissionDate = claimSubmissionDate;
		this.claimStatus = claimStatus;
		this.proofDocuments = proofDocuments;
	}

	public Claim() {
		
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public String getApprovedClaimAmount() {
		return approvedClaimAmount;
	}

	public void setApprovedClaimAmount(String approvedClaimAmount) {
		this.approvedClaimAmount = approvedClaimAmount;
	}

	public Timestamp getClaimSubmissionDate() {
		return claimSubmissionDate;
	}

	public void setClaimSubmissionDate(Timestamp claimSubmissionDate) {
		this.claimSubmissionDate = claimSubmissionDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getProofDocuments() {
		return proofDocuments;
	}

	public void setProofDocuments(String proofDocuments) {
		this.proofDocuments = proofDocuments;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", policyNumber=" + policyNumber + ", claimAmount=" + claimAmount
				+ ", claimReason=" + claimReason + ", additionalComments=" + additionalComments
				+ ", approvedClaimAmount=" + approvedClaimAmount + ", claimSubmissionDate=" + claimSubmissionDate
				+ ", claimStatus=" + claimStatus + ", proofDocuments=" + proofDocuments + "]";
	}
	
	
	

	
	
}
