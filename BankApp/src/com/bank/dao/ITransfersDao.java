package com.bank.dao;

import com.bank.beans.AddReceiverForm;

public interface ITransfersDao {

	public AddReceiverForm getAccountInfo(String accountNumber);
}
