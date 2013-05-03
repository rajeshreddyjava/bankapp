package com.bank.exceptions;

@SuppressWarnings("serial")
public class DepositException extends Exception{
	private String message;
	public DepositException(String message){
		this.message = message;
		
	}
	public String toString(){
		return message;
	}

}
