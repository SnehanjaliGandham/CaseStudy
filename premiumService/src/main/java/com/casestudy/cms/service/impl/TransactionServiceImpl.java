package com.casestudy.cms.service.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.cms.bean.Transaction;
import com.casestudy.cms.constants.PremiumConstants;
import com.casestudy.cms.exception.ResourceNotFoundException;
import com.casestudy.cms.model.TransactionModel;
import com.casestudy.cms.repository.TransactionRepository;
import com.casestudy.cms.service.PremiumService;
import com.casestudy.cms.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	private PremiumService premiumService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Transaction createTransaction(Transaction transaction) throws ResourceNotFoundException {
		TransactionModel transmodel = new TransactionModel();
		TransactionModel transnew =  new TransactionModel();
		BeanUtils.copyProperties(transaction, transmodel);
		transaction.setStatus(PremiumConstants.SUCCESS);
		transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
		logger.info("Save the user premium transaction details to database - started");
			transnew=transRepo.save(transmodel);
		logger.info("Save the user premium transaction details to database - Ended");
		 if(transnew!=null) {
			premiumService.updateUserPremium(transaction);
		 }
		transaction = new Transaction();
		BeanUtils.copyProperties(transnew, transaction);
		return transaction;
				
	}
	
	
	

}
