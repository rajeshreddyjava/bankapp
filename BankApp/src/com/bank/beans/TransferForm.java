package com.bank.beans;

import java.util.Calendar;

public class TransferForm {
	private String fromAccountType;
	private String toAccountNumber ;
	private String amount;
	private Calendar scheduledDate;
	public String getFromAccountType() {
		return fromAccountType;
	}
	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}
	public String getToAccountNumber() {
		return this.toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Calendar getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Calendar scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	

}
