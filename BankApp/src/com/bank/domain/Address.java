package com.bank.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

}
