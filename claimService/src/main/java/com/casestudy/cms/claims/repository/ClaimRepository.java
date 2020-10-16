package com.casestudy.cms.claims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.cms.claims.model.ClaimModel;


@Repository
public interface ClaimRepository extends JpaRepository<ClaimModel, Integer>{

}
