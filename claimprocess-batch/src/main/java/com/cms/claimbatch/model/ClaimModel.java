package com.cms.claimbatch.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claim")
public class ClaimModel {
	
	private int claimId;
	private int policyNumber;
	private String claimAmount;
	private String claimReason;
	private String additionalComments;
	private String approvedClaimAmount;
	private Timestamp claimSubmissionDate;
	private String claimStatus;
	private String proofDocuments;
	

	public ClaimModel() {
		
	}

	
	
	public ClaimModel(int claimId, int policyNumber, String claimAmount, String claimReason, String additionalComments,
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


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="claim_id")
	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	@Column(name="policy_number", nullable=false)
	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	@Column(name="claim_amount" , nullable=false)
	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	@Column(name="claim_reason" , nullable=false)
	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	@Column(name="additional_comments" , nullable=false)
	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	@Column(name="approved_claim_amount" , nullable=false)
	public String getApprovedClaimAmount() {
		return approvedClaimAmount;
	}

	public void setApprovedClaimAmount(String approvedClaimAmount) {
		this.approvedClaimAmount = approvedClaimAmount;
	}

	@Column(name="claim_submission_date" , nullable=false)
	public Timestamp getClaimSubmissionDate() {
		return claimSubmissionDate;
	}

	public void setClaimSubmissionDate(Timestamp claimSubmissionDate) {
		this.claimSubmissionDate = claimSubmissionDate;
	}

	@Column(name="claim_status" , nullable=false)
	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	@Column(name="proof_documents" , nullable=false)
	public String getProofDocuments() {
		return proofDocuments;
	}

	public void setProofDocuments(String proofDocuments) {
		this.proofDocuments = proofDocuments;
	}


}
