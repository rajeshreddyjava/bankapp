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

@Repository
public class TransactionDao implements ITransactionDao{
	
}
