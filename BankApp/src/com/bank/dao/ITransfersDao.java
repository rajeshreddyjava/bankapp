package com.bank.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bank.beans.Receiver;
import com.bank.exceptions.BankDaoException;

public interface ITransfersDao {

	public Receiver getReciverAccountInfo(String accountNumber);

	public String getUserId(String accountNumber);
	
	public void addReceiver(Receiver addReceiverForm,String userid) throws DataAccessException ;
	
	public List getReceiverList(String userId);

}
