package com.bank.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Receiver;
import com.bank.dao.ITransfersDao;
import com.bank.dao.ProfileDao;

public class TransferDaoTest extends BaseTest{
	@Autowired
	ITransfersDao transfersDao ;
	SessionFactory sessionFactory;

	@Before
	public void setUp(){
	}
	@Test
	@Transactional
	public void testGetReceiverInfo(){
		String accountNumber = "1234567898";
		Receiver receiverForm = null;
		try{
			
			receiverForm = transfersDao.getReciverAccountInfo(accountNumber);
			assertNotNull(receiverForm.getFirstName());
		}
		catch(Exception de){
			de.printStackTrace();
			fail("Exception occurred .. " + de.toString());
		
		}
		
	}
	@Test
	public void testGetUserid(){
		String userId = transfersDao.getUserId("10919114837");
		assertNotNull(userId);
	}

	@Test
	@Transactional
	public void testAddReceiver(){
		Receiver addReceiverForm = new Receiver();
		addReceiverForm.setAccountNumber("1234567899");
		addReceiverForm.setNickName("test");
		transfersDao.addReceiver(addReceiverForm,"rkatipally4");
	}
	
	@Test
	@Transactional
	public void testGetReceiverList(){
		List receiverList = transfersDao.getReceiverList("rkatipally4");
		assertNotNull(receiverList);
	}
}
