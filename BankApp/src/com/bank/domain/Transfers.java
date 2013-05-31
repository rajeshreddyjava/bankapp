package com.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSFERS")
public class Transfers {
	@Id
	@Column(name = "TRANSFERS_ID")
	private int id;
	@Column(name="ACCOUNT_NUMBER_FROM")
	private String accountNumberFrom;
	@Column(name="ACCOUNT_NUMBER_TO")
	private String accountNumberTo;
	@Column(name="DATE_OF_TRANSFER")
	private Date dateOfTransfer;
	@Column(name="AMOUNT_TRANSFERRED")
	private double amountTransferred;
	@Column(name="REASON_FOR_TRANSFER")
	private String reasonForTransfer;
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumberFrom() {
		return accountNumberFrom;
	}
	public void setAccountNumberFrom(String accountNumberFrom) {
		this.accountNumberFrom = accountNumberFrom;
	}
	public String getAccountNumberTo() {
		return accountNumberTo;
	}
	public void setAccountNumberTo(String accountNumberTo) {
		this.accountNumberTo = accountNumberTo;
	}
	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}
	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
	public double getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public String getReasonForTransfer() {
		return reasonForTransfer;
	}
	public void setReasonForTransfer(String reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}
	public Date getAddTimestamp() {
		return addTimestamp;
	}
	public void setAddTimestamp(Date addTimestamp) {
		this.addTimestamp = addTimestamp;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	
}
