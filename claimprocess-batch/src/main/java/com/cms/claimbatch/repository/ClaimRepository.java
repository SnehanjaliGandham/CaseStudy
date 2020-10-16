package com.cms.claimbatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.claimbatch.model.ClaimModel;



@Repository
public interface ClaimRepository extends JpaRepository<ClaimModel, Integer>{

	@Query("select clm from ClaimModel clm where clm.claimStatus =?1")
	List<ClaimModel> findByClaimStatus(String claimStatus);

}
