package com.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
	@Id
	@GeneratedValue
	@Column(name="TRANSACTION_ID")
	private int id;
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="PURCHASE_ID")
	private int purchaseId;
	@Column(name="TRANSACTION_TYPE")
	private String tansactionType;
	@Column(name="DATE_OF_TRANSACTION")
	private Date dateOfTransaction;
	@Column(name="AMOUNT")
	private double amount;
	@Column(name="IMAGE")
	private byte[] image;
	@Column(name="OTHER_DETAILS")
	private String otherDetails;
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	
	@ManyToOne
	//@JoinColumn(name="ACCOUNT_NUMBER")
	private Accounts account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getTansactionType() {
		return tansactionType;
	}
	public void setTansactionType(String tansactionType) {
		this.tansactionType = tansactionType;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
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
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
}
