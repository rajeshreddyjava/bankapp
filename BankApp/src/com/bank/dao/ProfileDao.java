package com.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.exceptions.BankDaoException;
import com.bank.exceptions.BankRuntimeException;

@Repository
public class ProfileDao implements IProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
			session.close();
		}
		return userId;
	}

}
