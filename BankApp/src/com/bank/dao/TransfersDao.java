package com.bank.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Receiver;
import com.bank.beans.AddressForm;
import com.bank.controllers.AccountsController;
import com.bank.domain.Accounts;
import com.bank.domain.Customer;
import com.bank.domain.TransferAccounts;
import com.bank.domain.TransferAccountsKey;
import com.bank.exceptions.BankDaoException;
import com.bank.exceptions.BankRuntimeException;
import com.bank.util.BankUtils;

@Repository
public class TransfersDao implements ITransfersDao {
	static Logger log = Logger.getLogger(AccountsController.class.getName());
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Receiver getReciverAccountInfo(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		Receiver receiverForm = new Receiver();
		try{
			//session.beginTransaction();
			
			Query query = session.createQuery("select c.firstName, c.lastName,  ad.zipCode from Accounts a inner join a.customer c inner join c.address ad where a.accountNumber =?  ");
			query.setParameter(0, accountNumber);
			List list = query.list();
			Customer customer = null;
			Accounts account = null;
			 receiverForm  = new Receiver();
			Iterator it = list.iterator();
			String firstName = null, lastName = null, zipCode = null;
			while(it.hasNext()){
				Object[] objects = (Object[])it.next();
				 firstName = (String)objects[0];
				 lastName = (String)objects[1];
				 zipCode = (String)objects[2];
			}
			AddressForm address = new AddressForm();
			address.setZipCode(zipCode);
			receiverForm.setAddress(address);
			receiverForm.setAccountNumber(accountNumber);
			receiverForm.setFirstName(firstName);
			receiverForm.setLastName(lastName);
			
			//session.getTransaction().commit();
		}
		catch(DataAccessException dae){
			log.error("In TransfersDao : " + dae.toString());
			throw new BankDaoException(dae.toString());
		}
		return receiverForm;
	}
	
	
	public boolean isAccountAlreadyAdded(String accountNumber){
		
		Session session = sessionFactory.getCurrentSession();
		Receiver receiverForm = new Receiver();
		try{
			//session.beginTransaction();
			
			Query query = session.createQuery("  ");
			query.setParameter(0, accountNumber);
			List list = query.list();
			
		}
		catch(DataAccessException dae){
			log.error(" Error In TransfersDao -> isAccountExist(): " );
			throw new BankDaoException(dae.toString());
		}
			return false;
	}
	
	
	@Override
	@Transactional
	public String getUserId(String accountNumber) {
		String userId = null;
		Session session = sessionFactory.getCurrentSession();
		try{
			Query  query = session.createQuery("select c.userId from Customer c inner join c.accounts a where a.accountNumber =? " );
			query.setParameter(0, accountNumber);
			List list = query.list();
			if(list.size()>1)
				throw new BankRuntimeException("One account has two userids..something went wrong");
			else
				userId = (String)list.get(0);
		}
		catch(DataAccessException e){
		throw new BankDaoException(e.toString());
		}
		finally{
			//session.close();
		}
		return userId;
	}

	@Override
	public void addReceiver(Receiver addReceiverForm, String userid)
			throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try{
			//session.beginTransaction();
			TransferAccounts transferAccounts = new TransferAccounts();
			TransferAccountsKey transferAccountsKey = new TransferAccountsKey();
			transferAccountsKey.setUserId(userid);
			transferAccountsKey.setAccountNumberAdded(addReceiverForm.getAccountNumber());
			transferAccounts.setTransferAccountsKey(transferAccountsKey);
			transferAccounts.setNickName(addReceiverForm.getNickName());
			transferAccounts.setOtherNotes("Receiver Added");
			transferAccounts.setAddTimestamp(Calendar.getInstance().getTime());
			transferAccounts.setAddUser("bank-app");
			transferAccounts.setUpdateTimestamp(Calendar.getInstance().getTime());
			transferAccounts.setUpdateUser("bank-app");
			session.save(transferAccounts);
			//session.getTransaction().commit();
			
		}
		catch(DataAccessException ex){
			throw new BankDaoException(ex.toString());
		}
		finally{
			//session.close();
		}
	}

	@Override
	public List<Receiver> getReceiverList(String userId) {
		List<Receiver> receiverList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TransferAccounts ta where user_id = ?");
			query.setParameter(0, userId);
			List<TransferAccounts> list = query.list();
			if(list!=null){
				receiverList = new ArrayList<Receiver>();
				Receiver receiver =  null;
				for(TransferAccounts transferAccount : list){
					receiver = new Receiver();
					receiver.setAccountNumber(transferAccount.getTransferAccountsKey().getAccountNumberAdded());
					receiver.setNickName(transferAccount.getNickName());
					receiverList.add(receiver);
				}
			}
		}
		catch(DataAccessException ex)
		{
			throw new BankDaoException(ex.toString());
		}
		return receiverList;
	}
	
	


}
