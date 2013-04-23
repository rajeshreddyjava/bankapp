package com.bank.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override

	public User getUserByUserName(String userName) {
		Query queryResult;
		queryResult = getCurrentSession().createQuery(
				"from User where username=:userName");
		queryResult.setParameter("userName", new String(userName));
		return (User) queryResult.list().get(0);
	}
}