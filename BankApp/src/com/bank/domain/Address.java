package com.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "ADDRESSES")
public class Address {
	@Column(name="ADDRESS_ID")
	@Id @GeneratedValue
	private int id;
	
	@Column(name = "ADDRESS_TYPE_CODE")
	private String addressTypeCode;
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE_COUNTY")
	private String state;
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="OTHER_ADDRESS_DETAILS")
	private String otherAddressDetails;
	
	@Column(name="ADD_TS")
	private Date addTimestamp;
	@Column(name="ADD_USR")
	private String addUser;
	@Column(name="UPDT_TS")
	private Date updateTimestamp;
	@Column(name="UPDT_USR")
	private String updateUser;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressTypeCode() {
		return addressTypeCode;
	}
	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOtherAddressDetails() {
		return otherAddressDetails;
	}
	public void setOtherAddressDetails(String otherAddressDetails) {
		this.otherAddressDetails = otherAddressDetails;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/*public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
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
