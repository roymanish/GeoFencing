package com.manh.lm.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateService {

	public DateService() {
		// TODO Auto-generated constructor stub
	}

	public static Date getCurrentISTDate()
	{
		Calendar calTZ = new GregorianCalendar(TimeZone.getTimeZone("Asia/Calcutta"));
		calTZ.setTimeInMillis(new Date().getTime());
		Calendar cal = Calendar.getInstance();



		cal.set(Calendar.YEAR, calTZ.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, calTZ.get(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH, calTZ.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, calTZ.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, calTZ.get(Calendar.MINUTE));
		cal.set(Calendar.SECOND, calTZ.get(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, calTZ.get(Calendar.MILLISECOND));

		return cal.getTime();

	}
	
	
	public static String getCurrentISTDateString()
	{
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyy hh:mm a");

		return format.format(getCurrentISTDate())+" IST";

	}
	
	
	
	public String getDaysAgo(Date date){
	    long days = (getCurrentISTDate().getTime() - date.getTime()) / 86400000;

	    if(days == 0) return "Today";
	    else if(days == 1) return "Yesterday";
	    else return days + " days ago";
	}

	

	/*private static void getAllTimeZone() {
		String[] zoneIds = TimeZone.getAvailableIDs();
		for (int i = 0; i < zoneIds.length; i++) {
			TimeZone tz = TimeZone.getTimeZone(zoneIds[i]);
			System.out.print("TZ Id="+tz.getID() + " Display Name= " + tz.getDisplayName()+" Time = ");
			getTime(tz.getID());
		}
	}

	public static void getTime(String timeZoneId) {
		Calendar calTZ = new GregorianCalendar(TimeZone.getTimeZone(timeZoneId));
		calTZ.setTimeInMillis(new Date().getTime());
		Calendar cal = Calendar.getInstance();



		cal.set(Calendar.YEAR, calTZ.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, calTZ.get(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH, calTZ.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, calTZ.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, calTZ.get(Calendar.MINUTE));
		cal.set(Calendar.SECOND, calTZ.get(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, calTZ.get(Calendar.MILLISECOND));
		//cal.setTimeZone(TimeZone.getTimeZone(timeZoneId));

		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		System.out.println(format.format(cal.getTime()));
	}*/
}
