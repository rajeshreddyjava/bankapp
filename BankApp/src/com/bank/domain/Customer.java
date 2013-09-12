package com.bank.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Column(name = "CUSTOMER_ID")
	
	
	@GeneratedValue
	private int ID;
	@Column(name = "SSN")
	private String SSN;
	@Column(name = "CUSTOMER_TYPE_CODE")
	private String customerTypeCode;
	@Column(name = "CUSTOMER_FIRST_NAME")
	private String firstName;
	@Column(name = "CUSTOMER_LAST_NAME")
	private String lastName;
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	@Id
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "CUSTOMER_HOME_PHONE")
	private String homePhone;
	@Column(name = "CUSTOMER_MOBILE_PHONE")
	private String mobilePhone;
	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;
	@Column(name = "LICENSE_EXPIRATION_DATE")
	private Date licenseExpirationDate;
	@Column(name = "LICENSE_ISSUED_STATE")
	private String licenseIssuedState;
	// @OneToMany(mappedBy="ADDRESSES")
	// @JoinColumn(name=)
	// @ForeignKey()
	
	@Column(name = "CUSTOMER_EMAIL")
	private String email;
	@Column(name = "DATE_BECAME_CUSTOMER")
	private Date dateBecameMember;
	
	@Column(name = "CURRENT_BALANCE")
	private double currentBalance;
	@Column(name = "OTHER_DETAILS")
	private String otherDetails;
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private Collection<Address> address = new ArrayList<Address>();
	
	@OneToMany(mappedBy = "customer")
	@JoinColumn(name = "user_id")
	private Collection<Accounts> accounts = new ArrayList<Accounts>();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getCustomerTypeCode() {
		return customerTypeCode;
	}
	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
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
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	public String getLicenseIssuedState() {
		return licenseIssuedState;
	}
	public void setLicenseIssuedState(String licenseIssuedState) {
		this.licenseIssuedState = licenseIssuedState;
	}
	public Collection<Address> getAddress() {
		return address;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateBecameMember() {
		return dateBecameMember;
	}
	public void setDateBecameMember(Date dateBecameMember) {
		this.dateBecameMember = dateBecameMember;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getLicenseExpirationDate() {
		return licenseExpirationDate;
	}
	public void setLicenseExpirationDate(Date licenseExpirationDate) {
		this.licenseExpirationDate = licenseExpirationDate;
	}
	public Collection<Accounts> getAccounts() {
		return accounts;
	}
	public void setAccounts(Collection<Accounts> accounts) {
		this.accounts = accounts;
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
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	

}
