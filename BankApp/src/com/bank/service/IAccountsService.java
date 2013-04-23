package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.AccountSummaryForm;
import com.bank.beans.DepositForm;
import com.bank.beans.TransactionsForm;

public interface IAccountsService {
	
	//public List<String> getExistingAccountTypes(String userId);
	public Map<String,String> getExistingAccountTypes(String userId);
	public void processDeposit(DepositForm depositForm);
	public List<AccountSummaryForm> getAccountSummary(String userId);
	public List<TransactionsForm> getTransactions(String accountType, String accountNumber, String userId);
	

}
