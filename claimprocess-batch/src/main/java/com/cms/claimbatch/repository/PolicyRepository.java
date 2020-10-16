package com.cms.claimbatch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.claimbatch.model.PolicyModel;


@Repository
@Transactional
public interface PolicyRepository extends JpaRepository<PolicyModel, Integer>{
	
	@Query("select pol from PolicyModel pol where pol.userId =?1")
	List<PolicyModel> findByUserId(int userId);

	
	@Query("select pol from PolicyModel pol where pol.policyNumber =?1")
	PolicyModel findByPolicyNumber(int policyNumber);

}
