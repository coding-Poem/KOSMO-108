package a.b.c.prac.comm;

import java.text.SimpleDateFormat;
// SimpleDateFormat(String pattern)
import java.util.Date;

public abstract class DateFormatUtil_p {
	public static String ymdFormat(){
		// 년 월 일 형식으로 데이터를 바꾸어 주는 함수
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
		// Date 클래스에 생성자를 만든다.
		// SimpleDateFormat 클래스 에 "yyyyMMdd" 생성자를 만든다.
		// 오늘 날짜를 yyyyMMdd 형식으로 바꾼다.
	}
	
	public static String ymFormat(){
		// 년 월 형식으로 데이터를 바꾸어 주는 함수
		return new SimpleDateFormat("yyyyMM").format(new Date());
		// Date 클래스에 생성자를 만든 뒤, SimpleDateFormat 클래스에
		// yyyyMM 생성자를 만든다.
	}
	
	public static String yFormat(){
		// 년 형식으로 데이터를 바꾸어 주는 함수
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	

	public static String ymdFormats(String ymdFlag) {
		System.out.println("<<< 5. DateFormatUtil_p :: ymdFormats(String ymdFlag) 시작 >>>");
		System.out.println("ymdFlag >>> : "+ymdFlag);
		
		String y="";
		
		if ("D".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.ymdFormat();
			// 들어온 글자의 대문자가 D면
			// 년월일
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.ymFormat();
			// 들어온 글자의 대문자가 M이면
			// 년월
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.yFormat();
			// 들어온 글자의 대문자가 Y면
			// 년
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			y = "";
			// 들어온 글자가 N이면
			// 아무것도 출력하지 말라는 의미
		}
		
		System.out.println("<<< 6. DateFormatUtil_p :: ymdFormats(String ymdFlag) :: y >>> : "+y);
		return y;
	}

	// public static void main(String[] args) {
		// TODO Auto-generated method stub

	// }
}
