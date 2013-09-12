package com.bank.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bank.beans.DepositForm;
import com.bank.domain.Accounts;
import com.bank.domain.Transaction;

public interface IAccountsDao {
	
	//public List<String> getAccountTypes(String userId);
	public Map<String,String> getAccountTypes(String userId);
	public void processDeposit(DepositForm depositForm) throws IOException;
	public List<Accounts> getAccountSummary(String userId);
	public List<Transaction> getTransactions(String accountType, String accountNumber, String userId);
	public List<Accounts> getAccounts(String userId);

}
