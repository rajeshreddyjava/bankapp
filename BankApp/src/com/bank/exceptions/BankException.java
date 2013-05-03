package com.bank.exceptions;

public class BankException extends Exception {
	
	private String message;
	public BankException(String message){
		this.message= message;
	}
	
	@Override
	public String toString(){
		return "Bank Exception" + this.message;
	}

}
