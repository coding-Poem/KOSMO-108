package a.b.c.ch1;

public class Exam_For_4 {


	public static void main(String args[]) {
		/*
		1. 지역 변수 , 초기화 해서 사용해야 한다.
		2. 참조 변수 , 주소값을 갖는다(생략),
		// public static int identityHashCode(Object x)
		3. rt.jar : java.lang.String : import 하지 않아도 사용 가능
		4. 문자열을 다루는 빌트인 클래스 
		*/
		/*
		데이터 타입 선언
		참조변수 s0 을 선언
		문자열 "abc" 값으로 초기화 했서요 
		*/
		String s0 = "abc";
		// public String toUpperCase() : 영문자를 대문자로 변경하는 함수 
		String s1 = s0.toUpperCase();	
		

		for (int i=0; i < s0.length(); i++ ){
			System.out.println("s0.charAt("+ i + ") >>> : " + s0.charAt(i));
		}
		
		for (int i=0; i < s1.length(); i++ ){
			System.out.println("s1.charAt("+ i + ") >>> : " + s1.charAt(i));
		}
	}
}
