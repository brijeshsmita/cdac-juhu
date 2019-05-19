package com.cg.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	public static Date convertStringToUtilDate(String strDate) {
		Date d=new Date();//date formatting
		SimpleDateFormat ft= 
				new SimpleDateFormat("yyyy/MM/dd") ;
		System.out.println("Formatted Date :"+ft.format(d));
//parsing the formatted date into Date 	
		try {
			d = ft.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static java.sql.Date 
		convertUtiltoSql(java.util.Date utilDob) {
		return new java.sql.Date(utilDob.getTime());
	}
	public static java.sql.Date 
		convertStringtoSql(String strDate) {
	return convertUtiltoSql(convertStringToUtilDate
			(strDate));
		
	}
}
