package com.bank.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.AddressForm;
import com.bank.beans.CustomerRegistrationForm;
import com.bank.dao.CustomerRegistrationDao;
public class CustomerRegistrationDaoTest extends BaseTest{

	
	@Autowired
	private CustomerRegistrationDao customerRegistrationDao;
	
	@Test
	@Transactional
	public void testInsertRegistrationDetails(){
		CustomerRegistrationForm customerForm =  new CustomerRegistrationForm();
		customerForm.setFirstName("Raj");
		customerForm.setLastName("Katipally");
		customerForm.setUserId("rkatipally4");
		Map<String,String> accountNumbers  =  new HashMap<String,String>();
		accountNumbers.put("checking", "1234567898");
		accountNumbers.put("savings", "1234567899");
		customerForm.setAccountNumbers(accountNumbers);
		customerForm.setAccountType(new String[]{"checking","savings"});
		AddressForm address = new AddressForm();
		address.setCity("Rockville");
		address.setCountry("USA");
		address.setState("MD");
		address.setStreetAddress("15 WGude Dr");
		customerForm.setAddress(address);
		
		customerRegistrationDao.insertRegistrationDetails(customerForm);
		
		
		
	}
	
}
