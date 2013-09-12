package com.bank.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.AddReceiverForm;
import com.bank.controllers.AccountsController;
import com.bank.domain.Accounts;
import com.bank.domain.Customer;
import com.bank.exceptions.BankDaoException;

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
	public AddReceiverForm getAccountInfo(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		AddReceiverForm receiverForm = null;
		try{
			//session.beginTransaction();
			
			Query query = session.createQuery("select c.firstName, c.lastName, c.zipCode,  a.accountNumber from Customer c inner join c.accounts a where a.accountNumber =?  ");
			query.setParameter(0, accountNumber);
			List list = query.list();
			Customer customer = null;
			Accounts account = null;
			 receiverForm  = new AddReceiverForm();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object[] objects = (Object[])it.next();
				 customer = (Customer)objects[1];
				// account = (Accounts)objects[1];
			}
			
			populateReceiverForm(receiverForm, account, customer);
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
		AddReceiverForm receiverForm = null;
		try{
			//session.beginTransaction();
			Query query = session.createQuery("select c.firstName, c.lastName,  a.accountNumber from Customer c inner join c.accounts a where a.accountNumber =?  ");
			query.setParameter(0, accountNumber);
			List list = query.list();
			Customer customer = null;
			Accounts account = null;
			 receiverForm  = new AddReceiverForm();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object[] objects = (Object[])it.next();
				 customer = (Customer)objects[1];
				// account = (Accounts)objects[1];
			}
			
			populateReceiverForm(receiverForm, account, customer);
			//session.getTransaction().commit();
		}
		catch(DataAccessException dae){
			log.error(" Error In TransfersDao -> isAccountExist(): " );
			throw new BankDaoException(dae.toString());
		}
			return false;
	}
	
	public void populateReceiverForm(AddReceiverForm receiverForm,Accounts account, Customer customer){
		//receiverForm.setAccountNumber(account.getAccountNumber());
		//receiverForm.setAddress(customer.getAddress());
		receiverForm.setFirstName(customer.getFirstName());
	}


}
