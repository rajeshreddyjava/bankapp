package com.bank.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "ACCOUNTS")
public class Accounts {

	@Column(name="ACCOUNT_ID")
	@Id
	@GeneratedValue
	private int accountId;
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="ACCOUNT_TYPE_CODE")
	private String accountTypeCode;
	@Column(name="USER_ID")
	private String userId;
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	@Column(name="DATE_OPENED")
	private Date dateOpened;
	@Column(name="DATE_CLOSED")
	private Date dateClosed;
	@Column(name="CURRENT_BALANCE")
	private double currentBalance;
	@Column(name="OTHER_ACCOUNT_DETAILS")
	private String otherAccountDetails;
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	@JoinColumn(name = "account_number")
	@ForeignKey(name = "account_number")
	private Collection<BalanceHistory> balanceHistory = new ArrayList<BalanceHistory>();

	public Collection<BalanceHistory> getBalanceHistory() {
		return balanceHistory;
	}

	public void setBalanceHistory(Collection<BalanceHistory> balanceHistory) {
		this.balanceHistory = balanceHistory;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getOtherAccountDetails() {
		return otherAccountDetails;
	}

	public void setOtherAccountDetails(String otherAccountDetails) {
		this.otherAccountDetails = otherAccountDetails;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
