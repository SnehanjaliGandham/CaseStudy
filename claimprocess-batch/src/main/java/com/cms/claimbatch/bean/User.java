package com.cms.claimbatch.bean;

import java.sql.Date;

public class User {
	
	
	private int userId;
	private int ssn;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String emailId;
	private String mobileNumber;
	private String address;
	private String city;
	
	
	
	
	
	public User(int userId, int ssn, String firstName, String lastName, Date birthDate, String emailId,
			String mobileNumber, String address, String city) {
		super();
		this.userId = userId;
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.city = city;
	}

	public User() {
		
		
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", city=" + city + "]";
	}

	

}
