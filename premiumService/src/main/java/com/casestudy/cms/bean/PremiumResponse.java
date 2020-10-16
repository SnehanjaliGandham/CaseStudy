package com.casestudy.cms.bean;

import java.util.ArrayList;

public class PremiumResponse {
	
	private int userid;
	private ArrayList<Premium> userPolicy;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public ArrayList<Premium> getUserPolicy() {
		return userPolicy;
	}
	public void setUserPolicy(ArrayList<Premium> userPolicy) {
		this.userPolicy = userPolicy;
	}
	
	

}
