package com.cms.claimbatch.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.claimbatch.model.UserModel;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	
	
	@Query(value="select u.user_id,u.address,u.birth_date,u.city,u.ssn,u.email_id,u.first_name,u.last_name,u.mobile_Number from users u,policy p where u.user_id=p.user_id and p.policy_number=?1",nativeQuery=true)
	UserModel findByPolicyNumber(int policyNumber);
	
	// @Query(value = "select userId,ssn,firstName,lastName,lastName,emailId,mobileNumber,address,city from claimsmc.users", nativeQuery=true)
	 //List<UserModel> findAll();

}