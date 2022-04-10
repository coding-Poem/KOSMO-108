package a.b.c.prac.comm;

import a.b.c.prac.comm.ChabunQuery_p;
import a.b.c.prac.comm.DateFormatUtil_p;

public class ChabunUtil_p {
	
	public static final String BIZ_GUBUN_TEST="T";
	// 멤버변수
	
	public static String numPad(String t, String c){
		System.out.println(" <<< 4. ChabunUtil_p :: numPad(String t, String c) 시작 >>>");
		System.out.println("String t >>> : "+t);
		System.out.println("Stirng c >>> : "+c);
		System.out.println("String c.length() >>> "+c.length());
		
		for (int i=c.length(); i<4; i++){
			c="0"+c;
			/*
			 * i가 c.length() 부터 시작
			 * c에 "0"을 붙인다.
			 * 언제까지 실행?
			 * i가 4보다 작으면 계속 실행
			 * 
			 * */
		}
		
		String ymd=DateFormatUtil_p.ymdFormats(t);
		
		System.out.println("<<< 7. ChabunUtil_p :: numPad(String t, String c) :: t >>> : "+ymd);
		return ymd.concat(c);
	}

	public static String getTestChabun(String type) {
		System.out.println("<<< 1. ChabunUtil_p :: getTestChabun(String type) :: 시작 >>>");
		System.out.println("\n type >>> : "+type);
		// main 함수에서  ChabunUtil_p 클래스의 
		// getTestChabun(String type) 함수로 String 데이터가
		// 들어온다.
		
		String commNum=ChabunQuery_p.getTestChabumQuery();
		// ChabunQuery_p 클래스의 
		// getTestChabumQuery() 함수 (staic 함수, return 있는 함수)
		// 로 값을 받아 String 데이터타입의 commNum 참조변수에 대입한다.
		
		System.out.println("\n 3. ChabunUtil_p :: commNum >>> : "+commNum);
		return BIZ_GUBUN_TEST.concat(ChabunUtil_p.numPad(type, commNum));
	}
	
	public static void main(String[] args) {
		System.out.println("\n 8. ChabunUtil_p 클래스의 main 함수  >>> : "+ChabunUtil_p.getTestChabun("d"));

	}
}


