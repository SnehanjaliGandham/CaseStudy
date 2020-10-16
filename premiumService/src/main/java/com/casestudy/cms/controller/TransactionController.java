package com.casestudy.cms.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.cms.bean.SuccessResponse;
import com.casestudy.cms.bean.Transaction;
import com.casestudy.cms.constants.PremiumConstants;
import com.casestudy.cms.exception.ResourceNotFoundException;
import com.casestudy.cms.repository.PolicyRepository;
import com.casestudy.cms.service.TransactionService;

/**
 * @author javacloudmc427
 * Description : This method is invoked when user performs any premium payment transaction 
 *
 */
@RestController
@RequestMapping("/api/user")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@PostMapping("/addTransaction")
	public ResponseEntity<Object> createTransaction(@RequestBody Transaction transaction) throws ResourceNotFoundException{
		
		Transaction newtran = new Transaction();
		Date curDate = new Date();
		long time = curDate.getTime();
		Timestamp curTime = new Timestamp(time);
		transaction.setStatus("success");
		transaction.setTransactionDate(curTime);
		logger.info("Save the User transaction details to teh database - started");
		newtran=transactionService.createTransaction(transaction);
		logger.info("Save the User transaction details to teh database - Ended");
		SuccessResponse success = new SuccessResponse();
		success.setSuccessCode(PremiumConstants.TRAN_SUCCESS_CODE);
		success.setSuccessMessage(PremiumConstants.TRAN_SUCCESS_MESSAGE);
		return ResponseEntity.accepted().body(success);
	}
	
	
}
