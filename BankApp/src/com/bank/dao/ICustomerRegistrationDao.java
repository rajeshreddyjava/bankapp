package com.bank.dao;

import java.util.List;

import com.bank.beans.CustomerRegistrationForm;

public interface ICustomerRegistrationDao {
	public void insertRegistrationDetails(CustomerRegistrationForm registerForm);
	public void insertLoginDetails(CustomerRegistrationForm registerForm);
	public List getYears();
	public List getMonths();
	public List getDays();

}
