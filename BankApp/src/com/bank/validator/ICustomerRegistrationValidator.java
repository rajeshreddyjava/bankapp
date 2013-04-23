package com.bank.validator;

import org.springframework.validation.Errors;

public interface ICustomerRegistrationValidator {
	public void validateIntro(Object customerRegistrationForm, Errors errors);
	public void validatePersonal(Object customerRegistrationForm, Errors errors);
	public void validateOnlineBankInfo(Object customerRegistrationForm,	Errors errors);

}
