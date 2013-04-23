package com.bank.validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bank.beans.CustomerRegistrationForm;

public class CustomerRegistrationValidator implements Validator,
		ICustomerRegistrationValidator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

	}

	public void validateIntro(Object customerRegistrationForm, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"required.firstName", "First Name is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"required.lastName", "Last Name is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "SSN",
				"required.SSN", "SSN is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.gender", "Gender is Requred");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearDOB",
				"required.yearDOB", "Year of Birth is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monthDOB",
				"required.monthDOB", "Month Of Birth is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.dayDOB", "Day of Birth is Requred");

	}

	public void validatePersonal(Object customerRegistrationForm, Errors errors) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
//				"driverLicenseNumber", "required.driverLicenseNumber",
//				"License Number is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homePhone",
				"required.homephone", "Home Phone Number is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Email address is Requred");
		CustomerRegistrationForm form = (CustomerRegistrationForm) customerRegistrationForm;
		if (!form.getEmail().equalsIgnoreCase(form.getConfirmEmail()))
			errors.reject("donotmatch.email");
		if (!form.getDriverLicenseNumber().isEmpty()) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "licenseIssuedState",
					"required.licenseIssuedState", "License Issued State is Requred");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearLicense",
					"required.yearLicense", "Year of License Expiration is Requred");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monthLicense",
					"required.monthLicense", "Month of License Expiration is Requred");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monthLicense",
					"required.monthLicense", "Month of License Expiration is Requred");
			}
	}

	public void validateOnlineBankInfo(Object customerRegistrationForm,
			Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId",
				"required.userid", "User ID is Requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Password is Requred");
		CustomerRegistrationForm form = (CustomerRegistrationForm) customerRegistrationForm;
		if (!form.getPassword().equalsIgnoreCase(form.getConfirmPassword()))
			errors.reject("donotmatch.password");
		if(form.getAccountType().length==0){
			errors.reject("required.accounttype");
		}
	}

}
