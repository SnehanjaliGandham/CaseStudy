package com.cms.claimbatch.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.cms.claimbatch.constants.BatchConstants;
import com.cms.claimbatch.model.ClaimModel;
import com.cms.claimbatch.model.PolicyModel;
import com.cms.claimbatch.model.UserModel;
import com.cms.claimbatch.repository.ClaimRepository;
import com.cms.claimbatch.repository.PolicyRepository;
import com.cms.claimbatch.repository.UserRepository;

@Component
public class ClaimProcessHelper {
	
	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
    private JavaMailSender javaMailSender;

	
	public void performtask() {
		List<ClaimModel> ClaimModel = claimRepository.findByClaimStatus(BatchConstants.PENDING);
		if (ClaimModel != null) {
			for (ClaimModel clmmod : ClaimModel) {
				if (clmmod != null) {
					boolean flag = validateClaim(clmmod);
					if (flag) {
						clmmod.setClaimStatus(BatchConstants.COMPLETED);
						processclaim(clmmod);
					}
				}
			}
		}

	}

	private void processclaim(ClaimModel claimModel) {
	
		claimRepository.save(claimModel);
		sendEmail(claimModel.getPolicyNumber());
	}
	
	private void sendEmail(int policyNumber) {
		UserModel usermodel=userRepository.findByPolicyNumber(policyNumber);
		String email = usermodel.getEmailId();
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(email);

	        msg.setSubject(BatchConstants.EMAIl_SUBJECT);
	        msg.setText(BatchConstants.EMAIl_TEXT + policyNumber + ".");

	        javaMailSender.send(msg);
		System.out.println("About to send Email");
	}

	private boolean validateClaim(ClaimModel claimModel) {
		PolicyModel polmodel = policyRepository.findByPolicyNumber(claimModel.getPolicyNumber());
		if (polmodel != null) {

			Float polAmt = Float.parseFloat(polmodel.getTotalPolicyAmount());
			Float claimAmt = Float.parseFloat(claimModel.getClaimAmount());
			if ((!claimModel.getClaimReason().isBlank()) && (claimAmt <= polAmt)
					&& polmodel.getPolicyStatus().equalsIgnoreCase(BatchConstants.STATUS_ACTIVE)) {
				return true;
			}

		}

		return false;
	}

}
