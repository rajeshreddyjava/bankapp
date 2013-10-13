package com.bank.test.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.IAccountsDao;
import com.bank.domain.Accounts;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({
	"file:web/WEB-INF/bankapp-servlet.xml",
	"file:web/WEB-INF/application-config.xml"
}
)
@TransactionConfiguration(defaultRollback = true, transactionManager="transactionManager")
public class AccountsDaoTest {
	
	@Autowired
	private IAccountsDao accountsDao;

	@Before
	public void setUp(){
		
		
	}
	@Test
	@Transactional
	public void testGetAccounts() {
		String userId ="destiny";
		try{
			List<Accounts> accountList = accountsDao.getAccounts(userId);
			assertFalse(accountList.size()==0);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Exception occurred .. " + e.toString());
		}

	}

}
