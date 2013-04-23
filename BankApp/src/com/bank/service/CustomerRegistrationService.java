package com.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.CustomerRegistrationForm;
import com.bank.dao.ICustomerRegistrationDao;
import com.bank.domain.CalendarInfo;
import com.mysql.jdbc.StringUtils;

@Service
public class CustomerRegistrationService implements
		ICustomerRegistrationService {

	private ICustomerRegistrationDao registrationDao;
	private MailSender mailSender;
	private MessageSource emailSource;

	@Autowired()
	@Qualifier("emailSource")
	public void setEmailSource(MessageSource emailSource) {
		this.emailSource = emailSource;
	}

	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	public void setRegistrationDao(ICustomerRegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean insertCustomerData(CustomerRegistrationForm form) {
		boolean success = false;
		try {
			registrationDao.insertLoginDetails(form);
			form.setAccountNumbers(generateAccountNumbers(form.getAccountType()));
			registrationDao.insertRegistrationDetails(form);
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public List<ArrayList<String>> populateDateFields() {
		List<ArrayList<String>> dateFieldList = new ArrayList<ArrayList<String>>();
		ArrayList<String> yearList = new ArrayList<String>();
		List<Integer> yearListFromDao = new ArrayList<Integer>();
		yearListFromDao = registrationDao.getYears();
		yearList.add(" ");
		for (Integer year : yearListFromDao) {
			yearList.add("" + year);
		}
		dateFieldList.add(yearList);
		ArrayList<String> monthList = new ArrayList<String>();
		List<String> monthListFromDao = new ArrayList<String>();
		monthListFromDao = registrationDao.getMonths();
		monthList.add(" ");
		for (String month : monthListFromDao) {
			monthList.add(month);
		}
		dateFieldList.add(monthList);
		ArrayList<String> dayList = new ArrayList<String>();
		List<Integer> dayListFromDao = new ArrayList<Integer>();
		dayListFromDao = registrationDao.getDays();
		dayList.add(" ");
		for (Integer day : dayListFromDao) {
			dayList.add("" + day);
		}
		dateFieldList.add(dayList);
		return dateFieldList;
	}

	@Override
	public List<CalendarInfo> getYears() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarInfo> getMonths() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarInfo> getDays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> generateAccountNumbers(String[] types) {
		Map accountNumbers = new HashMap<String, String>();
		Random random = new Random();
		long base = 10000000000L;
		for (int i = 0; i < types.length; i++)
			accountNumbers.put(types[i],
					(base + (long) Math.floor(Math.random() * 9000000000L))
							+ "");
		return accountNumbers;
	}

	@Override
	public boolean sendConfirmationEmail(CustomerRegistrationForm form) {
		try{
		String fromEmail = emailSource.getMessage("confirmation.from", null,
				"Required", null);
		String toEmail = form.getEmail();
		String subject = emailSource.getMessage("confirmation.subject", null,
				"Required", null);
		StringBuffer message = new StringBuffer();
		message.append(emailSource
				.getMessage(
						"confirmation.message",
						new Object[] { form.getFirstName() + " "
								+ form.getLastName() }, null));
		message.append(StringUtils.isNullOrEmpty(form.getAccountType()[0]
				+ ":\t"
				+ StringUtils.isNullOrEmpty(form.getAccountNumbers().get(
						StringUtils.isNullOrEmpty(form.getAccountType()[0])))) +"\n");
		message.append(StringUtils.isNullOrEmpty(form.getAccountType()[1]
				+ ":\t"
				+ StringUtils.isNullOrEmpty(form.getAccountNumbers().get(
						StringUtils.isNullOrEmpty(form.getAccountType()[1])))));

		message.append("\n If you have any questions, Please contact us @ 203-631-3766");
		SimpleMailMessage email = new SimpleMailMessage();

		email.setFrom(fromEmail);
		email.setTo(toEmail);
		email.setSubject(subject);
		email.setText(message.toString());
		mailSender.send(email);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;

	}

}
