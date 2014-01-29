package com.bank.test.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({
	"file:web/WEB-INF/bankapp-servlet.xml",
	"file:web/WEB-INF/application-config.xml"
	}
) 

@TransactionConfiguration(transactionManager="transactionManager" , defaultRollback = true)
public class BaseTest {

}
