package com.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BALANCE_HISTORY")
public class BalanceHistory {

	@Id
	@Embedded
	private BalanceHistoryKey primaryKey;
	
	@Column(name="BALANCE_AT_DATE")
	private double balanceAtDate;
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	public BalanceHistoryKey getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(BalanceHistoryKey primaryKey) {
		this.primaryKey = primaryKey;
	}
	public double getBalanceAtDate() {
		return balanceAtDate;
	}
	public void setBalanceAtDate(double balanceAtDate) {
		this.balanceAtDate = balanceAtDate;
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
