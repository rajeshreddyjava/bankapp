package com.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.UserDao;
import com.bank.domain.Authority;
import com.bank.domain.User;

@Repository("userLoginDetailsService")
public class UserLoginDetailsService implements UserDetailsService {

	@Resource
	private UserDao userDao;

	public UserLoginDetailsService() {
	}

	@Autowired
	public UserLoginDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional("transactionManager")
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		User user = null;
		List<String> authorityList = new ArrayList<String>();
		String authority;
		try {
			user = userDao.getUserByUserName(userName);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid Credentials.");
		}
		Set<Authority> authoritySet = user.getAuthoritySet();
		Iterator<Authority> authoritySetIterator = authoritySet.iterator();
		while (authoritySetIterator.hasNext()) {
			authority = authoritySetIterator.next().getAuthority();
			authorityList.add(authority);
		}
		user.setUserAuthorities(authorityList);
		return (UserDetails) user;
	}
}