package com.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bank.beans.CustomerRegistrationForm;
import com.bank.domain.CalendarInfo;

public interface ICustomerRegistrationService {
	
	public boolean insertCustomerData(CustomerRegistrationForm form);
	public List<CalendarInfo> getYears();
	public List<CalendarInfo> getMonths();
	public List<CalendarInfo> getDays();
	public List<ArrayList<String>> populateDateFields();
	public Map<String,String> generateAccountNumbers(String[] types);
	public boolean sendConfirmationEmail(CustomerRegistrationForm customerRegistrationForm);

}
