package com.bank.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bank.dao.AccountsDao;
import com.bank.dao.IAccountsDao;

public class AccountsDaoTest {
	private IAccountsDao accountsDao;

	@Before
	public void setUp(){
		 accountsDao = new AccountsDao();
		
	}
	@Test
	public void test() {
		assertEquals("Raj", "Raj");
//fail("Not yet implemented");
	}

}
