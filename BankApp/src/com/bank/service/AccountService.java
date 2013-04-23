package com.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.beans.AccountSummaryForm;
import com.bank.beans.DepositForm;
import com.bank.beans.TransactionsForm;
import com.bank.dao.IAccountsDao;
import com.bank.domain.Accounts;
import com.bank.domain.Transaction;

@Service
public class AccountService implements IAccountsService {

	private IAccountsDao accountsDao;

	@Autowired
	public void setAccountsDao(IAccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	@Override
	public Map<String, String> getExistingAccountTypes(String userId) {
		// TODO Auto-generated method stub
		return accountsDao.getAccountTypes(userId);
	}

	@Override
	public void processDeposit(DepositForm depositForm) {

		try {
			accountsDao.processDeposit(depositForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<AccountSummaryForm> getAccountSummary(String userId) {
		List<AccountSummaryForm> summaryList = new ArrayList<AccountSummaryForm>();
		try {
			List<Accounts> accounts = accountsDao.getAccountSummary(userId);
			for (Iterator it = accounts.iterator(); it.hasNext();) {
				Object[] account = (Object[]) it.next();
				String accountNumber = (String) account[0];
				double currentBalance = (double) account[1];
				String accountType = (String) account[2];
				AccountSummaryForm summaryForm = new AccountSummaryForm();
				summaryForm.setAccountNumber(accountNumber);
				summaryForm.setAccountType(accountType);
				summaryForm.setCurrentBalance(currentBalance);
				summaryList.add(summaryForm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryList;
	}

	@Override
	public List<TransactionsForm> getTransactions(String accountType, String accountNumber,
			String userId) {
		List<TransactionsForm> transactionList = new ArrayList<TransactionsForm>();
		List<Transaction> tList = accountsDao.getTransactions(accountType, accountNumber, userId);
		
		for(Transaction transaction : tList){
			TransactionsForm form = new TransactionsForm();
			form.setAmount(transaction.getAmount());
			form.setTransactionType(transaction.getTansactionType());
			form.setTransactionDate(transaction.getDateOfTransaction());
			transactionList.add(form);
		}
		
		return transactionList;
	}
}
