package com.bank.exceptions;

public class BankRuntimeException  extends RuntimeException{
	
private String message;
	
	public BankRuntimeException(String message){
		this.message = message;
	}
	@Override
	public String toString(){
		
		return "BankRuntimeException " +  message;
		
	}


}
