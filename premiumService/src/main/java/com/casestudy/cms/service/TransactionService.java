package com.casestudy.cms.service;

import org.springframework.stereotype.Service;

import com.casestudy.cms.bean.Transaction;
import com.casestudy.cms.exception.ResourceNotFoundException;

@Service
public interface TransactionService {
	
	public Transaction createTransaction(Transaction transaction) throws ResourceNotFoundException;

}
