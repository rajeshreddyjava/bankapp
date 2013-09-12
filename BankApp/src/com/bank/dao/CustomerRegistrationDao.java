package com.bank.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bank.beans.CustomerRegistrationForm;
import com.bank.domain.Accounts;
import com.bank.domain.Address;
import com.bank.domain.Authority;
import com.bank.domain.CalendarInfo;
import com.bank.domain.Customer;
import com.bank.domain.User;

@Repository
public class CustomerRegistrationDao implements ICustomerRegistrationDao {

	private HibernateTemplate hibernateTemplate;

	/*@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	*/

	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insertRegistrationDetails(CustomerRegistrationForm registerForm) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
	      
		Customer customer = new Customer();
		customer.setSSN(registerForm.getSSN());
		customer.setCustomerTypeCode("Personal");
		customer.setFirstName(registerForm.getFirstName());
		customer.setLastName(registerForm.getLastName());
		
		//Date dateOfBirth = (Date)df.parse(registerForm.getMonthDOB() + " " + registerForm.getDayDOB() + ","+registerForm.getYearDOB() );
		customer.setDateOfBirth(new Date());
		
		customer.setHomePhone(registerForm.getHomePhone());
		customer.setMobilePhone(registerForm.getMobilePhone());
		customer.setLicenseNumber(registerForm.getDriverLicenseNumber());
		//Date licenseExpirationDate = (Date)df.parse(registerForm.getMonthLicense() + " " + registerForm.getDayLicense() + ","+registerForm.getYearLicense() );
		customer.setLicenseExpirationDate(new Date());
		customer.setLicenseIssuedState(registerForm.getLicenseIssuedState());
		customer.setEmail(registerForm.getEmail());
		customer.setDateBecameMember(new Date());
		customer.setCurrentBalance(25.0);
		customer.setOtherDetails("Customer Added");
		customer.setAddTimestamp(new Date());
		customer.setAddUser("Raj");
		customer.setUpdateTimestamp(new Date());
		customer.setUpdateUser("Raj");
		customer.setUserId(registerForm.getUserId());
		//customer.seta
		
		Address address = new Address();
		address.setAddressTypeCode("Home");
		address.setCity(registerForm.getAddress().getCity());
		address.setStreetAddress(registerForm.getAddress().getStreetAddress());
		address.setState(registerForm.getAddress().getState());
		address.setZipCode(registerForm.getAddress().getZipCode());
		address.setCountry("USA");
		address.setOtherAddressDetails("Address Added");
		address.setAddUser("Raj");
		address.setUpdateTimestamp(new Date());
		address.setUpdateUser("Raj");
		address.setCustomer(customer);
		customer.getAddress().add(address);
		
		Accounts account =  new Accounts();
		account.setAccountTypeCode(registerForm.getAccountType()[0]);
		account.setAccountNumber(registerForm.getAccountNumbers().get(registerForm.getAccountType()[0]));
		account.setAccountName("Personal");
		account.setAddTimestamp(new Date());
		account.setAddUser("Raj");
		account.setUpdateTimestamp(new Date());
		account.setUpdateUser("Raj");
		account.setUserId(registerForm.getUserId());
		account.setCurrentBalance(25.0);
		account.setDateOpened(new Date());
		account.setOtherAccountDetails(registerForm.getAccountType()[0] + "account added");
		account.setAddTimestamp(new Date());
		account.setAddUser("Raj");
		account.setUpdateTimestamp(new Date());
		account.setUpdateUser("Raj");
		account.setCustomer(customer);
		customer.getAccounts().add(account);
		Accounts account1  = null;
		if(registerForm.getAccountType().length >1){
		 account1 =  new Accounts();
		account1.setAccountTypeCode(registerForm.getAccountType()[1]);
		account1.setAccountNumber(registerForm.getAccountNumbers().get(registerForm.getAccountType()[1]));
		account1.setAccountName("Personal");
		account1.setAddTimestamp(new Date());
		account1.setAddUser("Raj");
		account1.setUpdateTimestamp(new Date());
		account1.setUpdateUser("Raj");
		account1.setUserId(registerForm.getUserId());
		account1.setCurrentBalance(25.0);
		account1.setDateOpened(new Date());
		account1.setOtherAccountDetails(registerForm.getAccountType()[1] + "account added");
		account1.setAddTimestamp(new Date());
		account1.setAddUser("Raj");
		account1.setUpdateTimestamp(new Date());
		account1.setUpdateUser("Raj");
		account1.setCustomer(customer);
		customer.getAccounts().add(account1);
		}
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(address);
		session.saveOrUpdate(account);
		if(account1 != null)
			session.saveOrUpdate(account1);
		
		session.getTransaction().commit();
		}
		
		catch(Exception p){
			session.getTransaction().rollback();
			p.printStackTrace();
		}
		finally{
			session.close();
		}

	}

	@Override
	public void insertLoginDetails(CustomerRegistrationForm registerForm) {
		User user = new User();
		user.setUsername(registerForm.getUserId());
		user.setPassword(registerForm.getPassword());
		user.setDateLatestLogin(new Date());
		user.setDateOfNextPasswordChange(new Date());
		user.setEnabled(true);
		Authority authority = new Authority();
		authority.setAuthorityId((long) 2);
		authority.setAuthority("ROLE_MEMBER");

		user.getAuthoritySet().add(authority);
		// authorities.add(authority);
		// user.setAuthoritySet(authorities);
		hibernateTemplate.saveOrUpdate(user);
		hibernateTemplate.saveOrUpdate(authority);

	}

	@Override
	public List<CalendarInfo> getYears() {
		List<CalendarInfo> yearList = new ArrayList<CalendarInfo>();
		try{
			yearList = hibernateTemplate
				.find("select distinct c.year from CalendarInfo c order by c.year desc");
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		return yearList;
		}

	@Override
	public List<CalendarInfo> getMonths() {
		List<CalendarInfo> monthList = new ArrayList<CalendarInfo>();
		try{
		 monthList = hibernateTemplate
				.find("select distinct c.month from CalendarInfo c");
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		return monthList;
	}

	@Override
	public List<CalendarInfo> getDays() {
		List<CalendarInfo> dayList= new ArrayList<CalendarInfo>();
		try{
			dayList = hibernateTemplate
				.find("select distinct c.dayOfMonth from CalendarInfo c");
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		return dayList;
	}

}