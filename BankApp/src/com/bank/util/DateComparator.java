package com.bank.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateComparator {
	public static void main(String args[]) throws ParseException{
		Date now = new Date();
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		DateFormat df = DateFormat.getDateTimeInstance(
		    DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
		//TimeZone est = TimeZone.getTimeZone("EDT");
		TimeZone mst = TimeZone.getTimeZone("PST");
		System.out.println(df.format(now));
		df.setTimeZone(mst);
		System.out.println(df.format(now));
		
		 Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		    cal.setTime(sdf.parse(df.format(now)));// all done
		    System.out.println(cal.getTime());
		    int diff = (int)( (Calendar.getInstance().getTimeInMillis() - cal.getTimeInMillis() )  );
		    double days = Math.ceil(TimeUnit.HOURS.convert(diff,TimeUnit.MILLISECONDS)/24.0);
		   System.out.println(TimeUnit.HOURS.convert(diff,TimeUnit.MILLISECONDS));
		    System.out.println(diff+ " " +days);
		
	}

}
