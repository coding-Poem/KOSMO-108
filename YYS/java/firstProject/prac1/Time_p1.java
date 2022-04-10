package a.b.c.prac1;

import java.util.Calendar;
import java.util.TimeZone;

public class Time_p1 {
	public static void timeZone(){
		String cityID[]=TimeZone.getAvailableIDs();
		// getAvailableIDs 전세계의 도시 이름을 가져오시오.
		System.out.println("전세계 도시 수  >>> : "+cityID.length);
		
		for (int i=0; i<cityID.length; i++){
			//System.out.println("cityID ["+i+"] >>> : "+cityID[i]);
		}
	}
	
	public static String cityTime(Calendar cd){
		String time= "현재시간 : "+cd.get(Calendar.YEAR)+"년"+(cd.get(Calendar.MONTH)+1)+"월"+cd.get(Calendar.DATE)+"일"+cd.get(Calendar.HOUR_OF_DAY)+"시"+cd.get(Calendar.MINUTE)+"분"+cd.get(Calendar.SECOND)+"초";
		return time;
	}
		

	public static void main(String[] args) {
		Time_p1.timeZone();
		
		String strID[]= {"Asia/Seoul","America/New_York","Europe/Paris","Europe/London","Australia/Sydney"};
		String strName[]= {"서울", "뉴욕","파리","런던","시드니"};
		
		// 도시시간 가져오기
		for (int i=0; i<strID.length; i++){
			TimeZone tz=TimeZone.getTimeZone(strID[i]);
			Calendar cd = Calendar.getInstance(tz);
			// Calendar는 abstract class 이므로, getInstance로
			// 생성자를 생성한다.
			
			String t=Time_p1.cityTime(cd);
			System.out.println(strName[i]+" "+t);
		}

	}

}
