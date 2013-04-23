package com.bank.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConceptsTestingUtil {
	public static void main(String args[]) throws ParseException{
		//DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		String fromDate = "19/05/2009";
	      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	      java.util.Date dtt = (Date)df.parse(fromDate);
	     // Object system;
		//java.sql.Date ds = new java.sql.Date(dtt.getDate());
	      System.out.println(dtt);//Mon Jul 05 00:00:00 IST 2010
		
	}

}
