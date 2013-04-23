package com.bank.beans;

import java.util.Map;

public class CustomerRegistrationForm {

	private String firstName;
	private String lastName;
	private AddressForm address;
	private String SSN;
	private String dateOfBirth;
	private String gender = "Male";
	private String driverLicenseNumber;
	private String licenseIssuedState;
	private String licenseExpirationDate;
	private String homePhone;
	private String mobilePhone;
	private String email; 
	private String confirmEmail;
	private String[] accountType;
	private String userId;
	private String password;
	private String confirmPassword;
	private String yearDOB;
	private String monthDOB;
	private String dayDOB;
	private String yearLicense;
	private String monthLicense;
	private String dayLicense;
	private Map<String, String> accountNumbers;
	
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
	
	public AddressForm getAddress() {
		return address;
	}
	public void setAddress(AddressForm address) {
		this.address = address;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public String getLicenseIssuedState() {
		return licenseIssuedState;
	}
	public void setLicenseIssuedState(String licenseIssuedState) {
		this.licenseIssuedState = licenseIssuedState;
	}
	public String getLicenseExpirationDate() {
		return licenseExpirationDate;
	}
	public void setLicenseExpirationDate(String licenseExpirationDate) {
		this.licenseExpirationDate = licenseExpirationDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	
	public String[] getAccountType() {
		return accountType;
	}
	public void setAccountType(String[] accountType) {
		this.accountType = accountType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getYearDOB() {
		return yearDOB;
	}
	public void setYearDOB(String yearDOB) {
		this.yearDOB = yearDOB;
	}
	public String getMonthDOB() {
		return monthDOB;
	}
	public void setMonthDOB(String monthDOB) {
		this.monthDOB = monthDOB;
	}
	public String getDayDOB() {
		return dayDOB;
	}
	public void setDayDOB(String dayDOB) {
		this.dayDOB = dayDOB;
	}
	public String getYearLicense() {
		return yearLicense;
	}
	public void setYearLicense(String yearLicense) {
		this.yearLicense = yearLicense;
	}
	public String getMonthLicense() {
		return monthLicense;
	}
	public void setMonthLicense(String monthLicense) {
		this.monthLicense = monthLicense;
	}
	public String getDayLicense() {
		return dayLicense;
	}
	public void setDayLicense(String dayLicense) {
		this.dayLicense = dayLicense;
	}
	public Map<String, String> getAccountNumbers() {
		return accountNumbers;
	}
	public void setAccountNumbers(Map<String, String> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
	
}
