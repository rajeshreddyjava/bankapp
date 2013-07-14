package com.bank.exceptions;

public class BankServiceException extends Exception {
	private String message;
	
	public BankServiceException(String message){
		this.message = message;
	}
	@Override
	public String toString(){
		
		return "BankServiceExcpetion " +  message;
		
	}

}
