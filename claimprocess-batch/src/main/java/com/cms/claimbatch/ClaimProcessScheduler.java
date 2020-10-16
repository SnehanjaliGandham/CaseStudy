package com.cms.claimbatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cms.claimbatch.helper.ClaimProcessHelper;

@Component
public class ClaimProcessScheduler {
	
	@Autowired
	ClaimProcessHelper prohelper;
	
	@Scheduled (fixedRate=20000)
	public void scheduleTask(){
		
		prohelper.performtask();
		
	}



}
