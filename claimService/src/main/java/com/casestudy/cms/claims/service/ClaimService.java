package com.casestudy.cms.claims.service;

import org.springframework.stereotype.Service;

import com.casestudy.cms.claims.bean.Claim;
import com.casestudy.cms.claims.exception.ResourceNotFoundException;


@Service
public interface ClaimService {
	
	public Claim createClaim(Claim claim) throws ResourceNotFoundException;

}
