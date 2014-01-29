package com.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Receiver;
import com.bank.dao.ITransfersDao;
import com.bank.exceptions.BankDaoException;
import com.bank.util.BankUtils;

@Service
public class TransfersService implements ITransfersService{

	private ITransfersDao transfersDao;
	
	@Autowired
	public void setTransfersDao(ITransfersDao transfersDao) {
		this.transfersDao = transfersDao;
	}

	@Override
	public String validateReceiverInfo(Receiver addReceiverForm)
			throws BankDaoException {
		return null;
	}

	@Override
	@Transactional
	public Receiver getReceiverInfo(String accountNumber)
			throws BankDaoException {
		
		return transfersDao.getReciverAccountInfo(accountNumber);
	}

	@Override
	@Transactional
	public void addReceiver(Receiver addReceiverForm)
			throws BankDaoException {
	  transfersDao.addReceiver(addReceiverForm,BankUtils.getCurrentUserId());
		
	}

	@Override
	@Transactional
	public Map<String,String> getReceiverList(String userId)
			throws BankDaoException {
		List<Receiver> receiverList = transfersDao.getReceiverList(userId);
		Map<String,String> receiversMap = new HashMap<String,String>();
		for(Receiver receiver :  receiverList){
			
			receiversMap.put(receiver.getAccountNumber(), receiver.getNickName());
		}
		
		return receiversMap;
	}
	
	

}
