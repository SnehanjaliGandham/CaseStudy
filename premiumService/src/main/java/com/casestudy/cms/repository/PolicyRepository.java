package com.casestudy.cms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.cms.model.PolicyModel;

@Repository
@Transactional
public interface PolicyRepository extends JpaRepository<PolicyModel, Integer>{
	
	@Query("select pol from PolicyModel pol where pol.userId =?1")
	List<PolicyModel> findByUserId(int userId);

}
