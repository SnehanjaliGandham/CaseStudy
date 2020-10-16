package com.casestudy.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.cms.bean.ErrorResponse;
import com.casestudy.cms.bean.Policy;
import com.casestudy.cms.bean.PremiumResponse;
import com.casestudy.cms.constants.PremiumConstants;
import com.casestudy.cms.exception.ResourceNotFoundException;
import com.casestudy.cms.model.PolicyModel;
import com.casestudy.cms.service.PremiumService;

@RestController
@RequestMapping("/api/user")
public class PremiumController {

	@Autowired
	public PremiumService premiumService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @param userId
	 * @return Returns the premium details of the user due for that month
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/premiumDetails/{id}")
	public ResponseEntity<Object> getUserPoliciesById(@PathVariable(value = "id") Integer userId)
			throws ResourceNotFoundException {
		ErrorResponse error = new ErrorResponse();
		logger.info("Get user policy details based on userid - started");
		List<PolicyModel> policyModelList = premiumService.getPolicyByUserId(userId);

		if (policyModelList.isEmpty()) {
			error.setErrorCode(PremiumConstants.NO_USER_ERROR_CODE);
			error.setErrorMessage(PremiumConstants.NO_USER);
			logger.info("No user available with the userId "+userId);
			return ResponseEntity.accepted().body(error);

		}
		List<Policy> policyList = premiumService.TransformPolicyModelToEntity(policyModelList);
		if (policyList.isEmpty()) {
			error.setErrorCode(PremiumConstants.NO_DUE_ERROR_CODE);
			error.setErrorMessage(PremiumConstants.NO_DUE);
			logger.info("No Premium due for that month");
			return ResponseEntity.accepted().body(error);
		}

		PremiumResponse response = premiumService.TransformResponse(policyList);
		logger.info("Get user policy details based on userid - ended");
		return ResponseEntity.accepted().body(response);
	}

}
