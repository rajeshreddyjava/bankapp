package com.bank.dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bank.domain.CalendarInfo;
import com.bank.util.HibernateUtil;

public class CalendarInfoDao {

	public void populateCalendarInfo() {
		CalendarInfo calendarInfo = new CalendarInfo();
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			int j=5;
			for (int i = 1951; i <= 2013; i++) {
				
				String insertQuery = "INSERT INTO CALENDAR_INFO ( date)"
						+ " SELECT  DATE_ADD( '"+i+"-01-01', INTERVAL number DAY )" + " FROM numbers"
						+ " WHERE DATE_ADD( '"+i+"-01-01', INTERVAL number DAY ) BETWEEN '"+i+"-01-01' AND '"+i+"-12-31'" + " ORDER BY number;";
				SQLQuery sq = session.createSQLQuery(insertQuery);
				//sq.addScalar(arg0, arg1)
				sq.executeUpdate();
				j++;
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		/*
		 * hibernateTemplate.execute(new HibernateCallback() {
		 * 
		 * @Override public Object doInHibernate(Session session) throws
		 * HibernateException, SQLException { SQLQuery sq =
		 * session.createSQLQuery(insertQuery); sq.executeUpdate(); return null;
		 * } });
		 */
	}

	public static void main(String args[]) {
		CalendarInfoDao dao = new CalendarInfoDao();
		dao.populateCalendarInfo();
	}
}
