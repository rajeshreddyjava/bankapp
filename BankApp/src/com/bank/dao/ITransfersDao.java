package com.bank.dao;

import org.springframework.dao.DataAccessException;

import com.bank.beans.AddReceiverForm;
import com.bank.exceptions.BankDaoException;

public interface ITransfersDao {

	public AddReceiverForm getReciverAccountInfo(String accountNumber);

	public String getUserId(String accountNumber);
	
	public void addReceiver(AddReceiverForm addReceiverForm) throws DataAccessException ;

}
