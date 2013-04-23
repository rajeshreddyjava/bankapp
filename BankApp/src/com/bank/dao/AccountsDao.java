package com.bank.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.DepositForm;
import com.bank.beans.TransactionsForm;
import com.bank.domain.Accounts;
import com.bank.domain.BalanceHistory;
import com.bank.domain.BalanceHistoryKey;
import com.bank.domain.Customer;
import com.bank.domain.Transaction;

@Repository
public class AccountsDao implements IAccountsDao {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	@Autowired
	
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		return this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public Map<String, String> getAccountTypes(String userId)
			throws DataAccessException {

	     Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
	     Query query = session.createQuery("select a.accountNumber, a.accountTypeCode from Accounts a where a.userId=? order by a.accountTypeCode");
	     query.setParameter(0,userId);
		List<Accounts> accountList = new ArrayList<Accounts>(); 
		accountList = query.list();//hibernateTemplate.find("select a.accountNumber, a.accountTypeCode from Accounts a where a.userId=? order by a.accountTypeCode",userId);
		Map<String, String> accountMap = new HashMap<String, String>();
		for(Iterator it = accountList.iterator(); it.hasNext();){
				Object[] accountsInfo = (Object[])it.next();
				accountMap.put(accountsInfo[0].toString(), accountsInfo[1].toString());
					
		}
		return accountMap;
	}

	@Transactional
	public List<Accounts> getAccountSummary(String userId) {
		Map<String, Double> summaryMap = new HashMap<String, Double>();
		List<Accounts> accounts = new ArrayList<Accounts>();
		try {
			Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("accountNumber"));
			projectionList.add(Projections.property("currentBalance"));
			projectionList.add(Projections.property("accountTypeCode"));
			
			Criteria criteria = session.createCriteria(Accounts.class);
					
			criteria.setProjection(projectionList);
			criteria.add(Restrictions.eq("userId", userId));
			 accounts = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts ;
	}

	@Override
	@Transactional
	public void processDeposit(DepositForm depositForm) throws IOException {

		List customerList = hibernateTemplate.find(
				"from Customer c where c.userId=?", depositForm.getUserId());
		Customer customer = (Customer) customerList.get(0);
		double newBalance = depositForm.getAmount()
				+ customer.getCurrentBalance();
		customer.setCurrentBalance(newBalance);
		customer.setUpdateTimestamp(new Date());
		customer.setUpdateUser("Deposit_usr");

		List currentBalanceList = hibernateTemplate
				.find("select a.currentBalance from Accounts a where a.accountNumber=?",
						depositForm.getAccountTypeSelected());

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		// session.beginTransaction();

		Query updateCustomer = session
				.createQuery("update Customer c set currentBalance = :currentBalance, c.updateTimestamp = :updateTime, c.updateUser =:updateUser where c.userId = :userId");

		updateCustomer.setParameter("currentBalance", newBalance);
		updateCustomer.setParameter("updateTime", new Date());
		updateCustomer.setParameter("updateUser", "deposit");
		updateCustomer.setParameter("userId", depositForm.getUserId());

		System.out.println("Customer updated ---"
				+ updateCustomer.executeUpdate());
		double currentBalance = (double) currentBalanceList.get(0);

		Query updateAccounts = session
				.createQuery("update Accounts a set a.currentBalance = a.currentBalance + :amount, a.updateTimestamp = :updateTime, a.updateUser =:updateUser where a.accountNumber = :accountNumber");

		updateAccounts.setParameter("amount", newBalance);
		updateAccounts.setParameter("updateTime", new Date());
		updateAccounts.setParameter("updateUser", "deposit");
		updateAccounts.setParameter("accountNumber",
				depositForm.getAccountTypeSelected());

		System.out.println("Accounts Updated - rows affected :"
				+ updateAccounts.executeUpdate());

		Transaction transaction = new Transaction();

		transaction.setAccountNumber(depositForm.getAccountTypeSelected());
		transaction.setDateOfTransaction(depositForm.getCheckDepositedDate());
		transaction.setAmount(depositForm.getAmount());
		if (depositForm.getCheckImage() != null)
			transaction.setImage(depositForm.getCheckImage().getBytes());
		transaction.setTansactionType("Deposit");
		transaction.setOtherDetails(depositForm.getDepositMode());
		transaction.setDateOfTransaction(new Date());
		transaction.setAddUser("deposit_usr");
		transaction.setAddTimestamp(new Date());
		transaction.setUpdateTimestamp(new Date());
		transaction.setUpdateUser("deposit_usr");
		BalanceHistory balanceHistory = new BalanceHistory();
		BalanceHistoryKey balanceHistoryKey = new BalanceHistoryKey();
		balanceHistoryKey
				.setAccountNumber(depositForm.getAccountTypeSelected());
		balanceHistoryKey.setBalanceDate(new Date());
		balanceHistory.setPrimaryKey(balanceHistoryKey);
		balanceHistory.setBalanceAtDate(newBalance);
		balanceHistory.setAddUser("deposit");
		balanceHistory.setUpdateTimestamp(new Date());
		balanceHistory.setUpdateUser("deposit");
		balanceHistory.setAddTimestamp(new Date());
		session.saveOrUpdate(transaction);
		session.saveOrUpdate(balanceHistory);

	}

	@Override
	@Transactional
	public List<Transaction> getTransactions(String accountType, String accountNumber,
			String userId) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select t from Transaction t where t.accountNumber = :accountNumber ");
		query.setParameter("accountNumber", accountNumber);
		return query.list();
	}

}
