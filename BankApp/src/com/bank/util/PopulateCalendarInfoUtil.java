package com.bank.util;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bank.dao.CalendarInfoDao;

public class PopulateCalendarInfoUtil {
	
	private CalendarInfoDao populatecalendarInfoDao;

	
	public void setPopulatecalendarInfoDao(CalendarInfoDao populatecalendarInfoDao) {
		this.populatecalendarInfoDao = populatecalendarInfoDao;
	}
	

}
