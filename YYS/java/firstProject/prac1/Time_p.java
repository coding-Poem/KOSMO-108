package a.b.c.prac1;

import java.text.SimpleDateFormat;

public class Time_p {
	public static void main(String[] args) {
	// 현재 서버 시간을 long 타입으로 가져오기
	/*
	 * System.currentTimeMillis()는
	 * 현재 시각과 1970년 1월 1일 00:00:00 시와의 차이를
	 * long값으로 전달한다.
	 *
	 * static void : currentTimeMillis()
	 * Returns the current time in millisecond
	 * 
	 * the difference, measured in milliseconds, 
	 * between the current time and midnight, January 1, 1970 UTC.
	 * 
	 * */
	
	long start=System.currentTimeMillis();
	System.out.println("start >>> : "+start);
	System.out.println("start >>> : "+new SimpleDateFormat ("yyyy년 MM월 dd일 HH시 mm분 ss초").format(start));
	System.out.println("start >>> : "+new SimpleDateFormat ("ss초").format(start));
	
	try {
		Thread.sleep(5000);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	long end=System.currentTimeMillis();
	System.out.println("end >>> : "+end);
	System.out.println("end >>> : "
			+ new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(end));
	
	long idle_second = (end-start)/1000;
	// 밀리초결과를  1초단위로 long 타입에 저장하라
	long idle_minute=(end-start)/(1000*60);
	// 밀리초결과를 1 분단위로 long 타입에 저장하라.
	long idle_hour=(end-start)/(1000*60*60);
	// 밀리초결과를 1시간 단위로 long 타입에 저장하라.
	System.out.println("실행시간 (1초단위) >>> : "+idle_second+"초");
	System.out.println("실행시간 (1분단위) >>> : "+idle_minute+"분");
	System.out.println("실행시간 (1시간단위) >>> :"+idle_hour+"시");

	} // main method

} // Time_p class
