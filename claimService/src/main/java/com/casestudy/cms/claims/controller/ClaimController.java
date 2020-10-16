package com.casestudy.cms.claims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.cms.claims.bean.Claim;
import com.casestudy.cms.claims.bean.ClaimResponse;
import com.casestudy.cms.claims.constants.ClaimConstants;
import com.casestudy.cms.claims.exception.ResourceNotFoundException;
import com.casestudy.cms.claims.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimservice;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Method invoked when the user files claim
	 * @param claim
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/addClaim")
	public ResponseEntity<Object> createClaim(@RequestBody Claim claim) throws ResourceNotFoundException {

		Claim newClaim = new Claim();
		ClaimResponse claimresponse = new ClaimResponse();
		logger.info("Save the claim filed by the User to the database - started");
		newClaim = claimservice.createClaim(claim);
		logger.info("Save the claim filed by the User to the database - Ended");
		claimresponse.setClaimId(newClaim.getClaimId());
		claimresponse.setCode(ClaimConstants.CLAIM_SUCCESS_CODE);
		claimresponse.setMessage(ClaimConstants.CLAIM_SUCCESS_MESSAGE);
		return ResponseEntity.accepted().body(claimresponse);

	}

}
