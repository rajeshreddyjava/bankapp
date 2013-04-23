package com.bank.beans;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DepositForm {
	
	private CommonsMultipartFile checkImage;
	private double amount;
	private String accountTypeSelected;
	private String depositMode = "cash";
	private Date checkDepositedDate;
	private String otherDetails;
	private String userId;
	
	public CommonsMultipartFile getCheckImage() {
		return checkImage;
	}
	public void setCheckImage(CommonsMultipartFile checkImage) {
		this.checkImage = checkImage;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccountTypeSelected() {
		return accountTypeSelected;
	}
	public void setAccountTypeSelected(String accountTypeSelected) {
		this.accountTypeSelected = accountTypeSelected;
	}
	public String getDepositMode() {
		return depositMode;
	}
	public void setDepositMode(String depositMode) {
		this.depositMode = depositMode;
	}
	
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCheckDepositedDate() {
		return checkDepositedDate;
	}
	public void setCheckDepositedDate(Date checkDepositedDate) {
		this.checkDepositedDate = checkDepositedDate;
	}
	

}
