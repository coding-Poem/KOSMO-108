package a.b.c.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

	public static String yyyymmdd() {		
		return new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
	}
		
	public static String cTime(){
		
		long time = System.currentTimeMillis();	
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
//		String cTime = sdf.format(new java.util.Date(time));
//		return cTime;
		
		return new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date(time)).toString();
	}
	
	public static boolean fromtoDate(String fromdate, String todate) {

		boolean bool = false;
		
		try {
			
			SimpleDateFormat sDate = new SimpleDateFormat("yyyyMMdd");		
			Date fromDate = sDate.parse(fromdate);
			Date toDate = sDate.parse(todate);
			long f = fromDate.getTime();
			long t = toDate.getTime();
			
			bool = f > t;
			
			if (bool) {
				System.out.println("FROM 날짜가 TO 날짜보다 크면 않됩니다. >>> : " + bool);
				System.out.println("프로그램을 종료합니다. 다시 실행해서 사용하시오 >>> : ");				
			}
		} catch (Exception e) {
			System.out.println("FROM TO 비교중 에러가 >>> : " + e.getMessage());
		}
		
		return bool;
	}

	public static void main(String args[]) {
		
//		System.out.println("yyyymmdd >>> : " + DateUtil.yyyymmdd());
//		System.out.println("cTime >>> : " + DateUtil.cTime());
	}
}
