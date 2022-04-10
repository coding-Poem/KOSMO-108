package a.b.c.prac1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_p {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date d=new Date();
		System.out.println("Date d >>> : "+d);
		// Date d >>> : Fri Feb 25 13:03:26 KST 2022
		
		// 년 
		/*
		 * java.lang.Object 
		 * 	java.util.Date
		 * 		java.sql.Date
		 * java.sql.Date : A milliseconds value represents the number of milliseconds 
		 * that have passed since January 1, 
		 * 1970 00:00:00.000 GMT.
		 * 
		 * int getYear() 
		 * 
		 * Deprcated Calendar.get(Calendar.YEAR) -1900
		 * */
		int year=d.getYear();
		// Deprecated 때문에 Date Method를 입력하면 -줄이 뜬다.
		System.out.println("year >>> : "+year);
		//year >>> : 122
		year=year+1900;
		System.out.println("year+1900 >>> : "+year);
		//year+1900 >>> : 2022
		
		// 월
		
		/*
		 * public int getMonth()
		 * 
		 * The value returned is between 0 and 11, 
		 * with the value 0 representing January.
		 * 
		 * */
		int month=d.getMonth();
		System.out.println("month >>> : "+month);
		// 1
		month=month+1;
		System.out.println("month+1 >>> : "+month);
		// 2
		
		// 일
		// public int getDate()
		/*
		 * Deprecated. As of JDK version 1.1, 
		 * replaced by Calendar.get(Calendar.DAY_OF_MONTH).
		 * */
		int date=d.getDate();
		System.out.println("date >>> : "+date);
		
		// 년-월-일
		String time=year+"."+month+"."+date;
		System.out.println("time >>> : "+time);
		time=time.replace('.',  '-');
		System.out.println("time >>> : "+time);
		time=time.replace('-','.');
		System.out.println("time >>> : "+time);
		
		
		// SimpleDateFormat 사용하기
		String ymd[]= {"yyyy.MM.dd","yyyy-MM-dd","yyyy/MM/dd"};
		
		for (int i=0; i<ymd.length; i++) {
			SimpleDateFormat sdf=new SimpleDateFormat(ymd[i]);
			System.out.println("sdf >>> : "+sdf);
			System.out.println("sdf.format(d) >>> : "+sdf.format(d));
		}
		
		
	}

}
