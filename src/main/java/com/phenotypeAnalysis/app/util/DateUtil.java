package com.phenotypeAnalysis.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String formDate(String date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Date today = sdf.parse(date);
	    SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
	    String newDate = formatt.format(today);
	    return newDate;	
	}
}
