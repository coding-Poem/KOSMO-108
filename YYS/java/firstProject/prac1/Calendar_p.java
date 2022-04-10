package a.b.c.prac1;

import java.util.Calendar;

public class Calendar_p {

	public static void main(String[] args) {
		Calendar cd=Calendar.getInstance();
		System.out.println("cd >>> : "+cd);
		// 왜 getInstance???
		// 추상클래스는 new 연산자로 인스턴스 하지 못 함
		// 추상클래스의 상속을 받은 일반클래스에 new 인스턴스로 생성자만드는것만 가능
		/*
		 * public abstract class Calendar
		 *	extends Object
		 *	implements Serializable, 
		 *	Cloneable, 
		 *	 Comparable<Calendar>
		 * */
		// Calender는 윤년이나 윤달을 고려하여, 작업하기 어려우므로, 한국에서는
		// Date를 많이 쓴다.
		
		//년
		int y=cd.get(Calendar.YEAR);
		// 1st 방법
		System.out.println("y >>> : "+y);
		// 2nd 방법
		System.out.println("cd.get(1) >>> : "+cd.get(1));
		// cd.get(num)의 num은 java.util.Calendar의 ConstantField 의 고유 넘버이다.
		
		//월
		int m=cd.get(Calendar.MONTH)+1;
		// 1st 방법
		System.out.println("m >>> : "+m);
		// 2nd 방법
		System.out.println("(cd.get(2)+1 >>> "+(cd.get(2)+1));
		// 0~11로 저장되어 있어서 1을 더해줘야 한다.
		
		//일
		int d = cd.get(Calendar.DATE);
		System.out.println("d >>>> : "+d);
		System.out.println("cd.get(5) >>> "+cd.get(5));
		// 년은 cd.get(1)
		// 월은 cd.get(2)
		// 일은 cd.get(5)
		
		// 또 다른 일 구하는 방법		
		int d1=cd.get(Calendar.DAY_OF_MONTH);
		System.out.println("d1 >>> : "+d1);
		
		// 결과값이 전부 동일함. 그침나, Calendar.DAY_OF_MONTH는 지양하자.
		
		// 시
		int t =cd.get(Calendar.HOUR_OF_DAY);
		System.out.println("t >>> : "+t);
		System.out.println("cd.get(11) >>> : "+cd.get(11));
		// 여기서는 11이다.
		
		// 분
		int mm=cd.get(Calendar.MINUTE);
		System.out.println("mm >>> : "+mm);
		System.out.println("cd.get(12) >>> "+cd.get(12));
		// 여기서는 12이다.
		
		// 초
		int s=cd.get(Calendar.SECOND);
		System.out.println("s >>> : "+s);
		System.out.println("cd.get(13) >>> : "+cd.get(13));
		
		String time="현재 시간은 : "+y+"년"+m+"월"+d+"일"+t+"시"+mm+"분"+s+"초 입니다. !!!!";
		System.out.println("time >>> : \n "+time);


	} // main method

} // Calendar_p method
