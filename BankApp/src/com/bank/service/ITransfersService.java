package com.bank.service;

import java.util.Map;

import com.bank.beans.Receiver;
import com.bank.exceptions.BankDaoException;

public interface ITransfersService {
	public String validateReceiverInfo(Receiver addReceiverForm) throws BankDaoException;
	public Receiver getReceiverInfo (String accountNumber) throws BankDaoException;
	public void addReceiver(Receiver addReceiverForm) throws BankDaoException;
	public Map<String,String> getReceiverList(String userId) throws BankDaoException;

}
