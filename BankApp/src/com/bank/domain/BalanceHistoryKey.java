package com.bank.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BalanceHistoryKey implements Serializable{
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="BALANCE_DATE")
	private Date balanceDate;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

}
