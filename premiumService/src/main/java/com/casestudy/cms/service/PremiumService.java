package com.casestudy.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.cms.bean.Policy;
import com.casestudy.cms.bean.PremiumResponse;
import com.casestudy.cms.bean.Transaction;
import com.casestudy.cms.exception.ResourceNotFoundException;
import com.casestudy.cms.model.PolicyModel;

@Service
public interface PremiumService {

	public List<PolicyModel> getPolicyByUserId(int id) throws ResourceNotFoundException;

	public void updateUserPremium(Transaction tran) throws ResourceNotFoundException;

	public PremiumResponse TransformResponse(List<Policy> policyList);

	public List<Policy> TransformPolicyModelToEntity(List<PolicyModel> policyModelList);
}
