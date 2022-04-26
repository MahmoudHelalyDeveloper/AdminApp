package com.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ConverterDate {

	public static Date formString(String dateString) throws ParseException {
		
	    Date newDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);  

		
		return newDate;
	}
	
	public static Integer getMonths (Date startDate, Date endDate) {
		int m1 = startDate.getYear() * 12 + startDate.getMonth();
	    int m2 = endDate.getYear() * 12 + endDate.getMonth();
		
	    return m2 - m1 + 1;

	}
	
	
	
	public static void main(String[] args) throws ParseException {
	
		Date formString = formString("31/12/1998");
		System.err.println("formString is "+formString);
	
	
	}
	
}
