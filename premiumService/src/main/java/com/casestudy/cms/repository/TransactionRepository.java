package com.casestudy.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.cms.model.TransactionModel;

@Repository
public interface TransactionRepository  extends JpaRepository<TransactionModel, Integer>{

}
