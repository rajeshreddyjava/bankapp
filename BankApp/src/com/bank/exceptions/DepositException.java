package com.bank.exceptions;

@SuppressWarnings("serial")
public class DepositException extends Exception{
	public DepositException(){
		
	}
	public String toString(){
		return "Exception while making deposit";
	}

}
