package com.bank.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bank.beans.AddReceiverForm;

public class BankValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		AddReceiverForm addReceiverForm = (AddReceiverForm)object;
		
	}
	public String validateReceiverInfo(AddReceiverForm addReceiverForm){
		
		return "";
	}
	

}