package com.bank.exceptions;

public class BankDaoException  extends RuntimeException{
	
private String message;
	
	public BankDaoException(String message){
		this.message = message;
	}
	@Override
	public String toString(){
		
		return "BankDaoExcpetion " +  message;
		
	}


}
