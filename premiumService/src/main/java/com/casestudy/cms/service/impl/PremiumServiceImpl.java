package com.casestudy.cms.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.cms.bean.Policy;
import com.casestudy.cms.bean.Premium;
import com.casestudy.cms.bean.PremiumResponse;
import com.casestudy.cms.bean.Transaction;
import com.casestudy.cms.constants.PremiumConstants;
import com.casestudy.cms.exception.ResourceNotFoundException;
import com.casestudy.cms.model.PolicyModel;
import com.casestudy.cms.repository.PolicyRepository;
import com.casestudy.cms.service.PremiumService;

/**
 * Service Implementation class to perform Database transactions
 * 
 * @author javacloudmc427
 *
 */
@Service

public class PremiumServiceImpl implements PremiumService {

	@Autowired
	private PolicyRepository policyRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<PolicyModel> getPolicyByUserId(int userId) throws ResourceNotFoundException {

		List<PolicyModel> policyModelList = new ArrayList<>();
		logger.info("Get User Policies Details by UserId - Started");
		policyModelList = policyRepository.findByUserId(userId);
		logger.info("Get User Policies Details by UserId - Ended");
		return policyModelList;
	}

	public List<Policy> TransformPolicyModelToEntity(List<PolicyModel> policyModelList) {

		List<Policy> policyList = new ArrayList<>();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		policyModelList.forEach(policyModel -> {
			// for (PolicyModel policyModel : policyModelList) {
			Policy policy = new Policy();
			cal1.setTime(policyModel.getDueDate());
			cal2.setTime(new Date());
			boolean isCurMon = (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH));
			if (policyModel.getPremiumStatus().equalsIgnoreCase(PremiumConstants.PENDING) && isCurMon) {
				BeanUtils.copyProperties(policyModel, policy);
				policyList.add(policy);
			}

		});

		return policyList;

	}

	@Override
	public void updateUserPremium(Transaction tran) throws ResourceNotFoundException {
		PolicyModel policymodel = policyRepository.findById(tran.getPolicyNumber()).orElseThrow(
				() -> new ResourceNotFoundException("Policy Number is not available " + tran.getPolicyNumber()));
		policymodel.setPaidAmount(tran.getTransactionAmount());
		float paid = Float.parseFloat(tran.getTransactionAmount());
		float premium = Float.parseFloat(policymodel.getPremiumAmount());
		float due = premium - paid;
		policymodel.setDueAmount(String.valueOf(due));
		policymodel.setPaidAmount(tran.getTransactionAmount());
		if (due == 0) {
			policymodel.setPremiumStatus(PremiumConstants.PAID);
		}
		// PolicyModel updatePolicyDb = new PolicyModel();
		logger.info("Save the Premium details of the user to the database - started");
			policyRepository.save(policymodel);
		logger.info("Save the Premium details of the user to the database - Ended");
	}

	public PremiumResponse TransformResponse(List<Policy> policyList) {

		PremiumResponse response = new PremiumResponse();
		String userId = null;
		ArrayList<Premium> premiumList = new ArrayList<>();
		if (policyList != null && !policyList.isEmpty()) {
			for (Policy pol : policyList) {
				if (userId == null) {
					userId = String.valueOf(pol.getUserId());
				}

				Premium premium = new Premium();
				premium.setPolicyNumber(pol.getPolicyNumber());
				if (pol.getDueAmount() == null) {
					premium.setDueAmount(PremiumConstants.DUE_AMOUNT);
				} else {
					premium.setDueAmount(pol.getDueAmount());
				}
				premium.setDueDate(pol.getDueDate());
				premium.setPaidAmount(pol.getPaidAmount());
				premium.setPremiumAmount(pol.getPremiumAmount());
				premium.setPremiumStatus(pol.getPremiumStatus());
				premium.setTotalPolicyAmount(pol.getTotalPolicyAmount());
				premium.setPolicyStatus(pol.getPolicyStatus());
				premiumList.add(premium);
			}

			response.setUserid(Integer.parseInt(userId));
			response.setUserPolicy(premiumList);
		}
		return response;

	}

}
