package com.bank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransferAccountsKey implements Serializable{
	
	@Column(name="USER_ID")
	private String userId;
	@Column(name="ACCOUNT_ADDED")
	private String accountNumberAdded;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountNumberAdded() {
		return accountNumberAdded;
	}
	public void setAccountNumberAdded(String accountNumberAdded) {
		this.accountNumberAdded = accountNumberAdded;
	}
	
	
	

}
