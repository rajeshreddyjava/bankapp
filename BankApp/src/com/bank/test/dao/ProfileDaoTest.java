package com.bank.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.dao.ProfileDao;

public class ProfileDaoTest extends BaseTest{
	
	@Autowired
	private ProfileDao profileDao;
	@Test
	public void testGetUserid(){
		
		String userId = profileDao.getUserId("10919114837");
		assertNotNull(userId);
		
	}

}
