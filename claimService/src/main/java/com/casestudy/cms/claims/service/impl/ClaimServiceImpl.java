package com.casestudy.cms.claims.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.cms.claims.bean.Claim;
import com.casestudy.cms.claims.constants.ClaimConstants;
import com.casestudy.cms.claims.exception.ResourceNotFoundException;
import com.casestudy.cms.claims.model.ClaimModel;
import com.casestudy.cms.claims.repository.ClaimRepository;
import com.casestudy.cms.claims.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	@Override
	public Claim createClaim(Claim claim) throws ResourceNotFoundException {

		ClaimModel claimModel = new ClaimModel();
		BeanUtils.copyProperties(claim, claimModel);
		claimModel.setApprovedClaimAmount(ClaimConstants.DEFAULT_CLAIM_AMOUNT);
		claimModel.setClaimSubmissionDate(new Timestamp(System.currentTimeMillis()));
		claimModel.setClaimStatus(ClaimConstants.PENDING);
		ClaimModel claimModelNew = new ClaimModel();
		claimModelNew = claimRepository.save(claimModel);
		claim = new Claim();
		BeanUtils.copyProperties(claimModelNew, claim);
		return claim;
	}

}
