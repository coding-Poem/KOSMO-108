package a.b.c.ch4;

public class Exam_EqualsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		java.lang.Object.equals(Object obj) : 인스턴스한 주소값을 비교하는 함수 
		java.lang.String.equals(Object obj) : 문자열을 비교하는 함수 


		boolean b = 참조변수.equals(참조변수);
		비교할 참조변수를 보고 버철머신이 판단을 한다. 
		
		*/
		String s = "abc";
		String s1 = "abc";
		boolean b = s.equals(s1); // <-- java.lang.String.equals() 함수가 호출되어서 문자열 비교한다.
		System.out.println("System.identityHashCode(s) s >>> : " + System.identityHashCode(s));
		System.out.println("System.identityHashCode(s1) s1 >>> : " + System.identityHashCode(s1));		
		System.out.println("b >>> : " + b);

		Object o = new Object();
		Object o1 = new Object();
		boolean b1 = o.equals(o1); // <--- java.lang.Object.equals() 함수가 호출되어서 주소값을 비교한다.
		System.out.println("o >>> : " + o);
		System.out.println("o1 >>> : " + o1);		
		System.out.println("System.identityHashCode(o) o >>> : " + System.identityHashCode(o));
		System.out.println("System.identityHashCode(o1) o1 >>> : " + System.identityHashCode(o1));	
		System.out.println("b1 >>> : " + b1);		
				
		boolean b2 = o == o1; 
		System.out.println("b2 >>> : " + b2);
		
		// 자바에서는 문자열 비교할 때는 == 상등연산자, 등가연산자 연산자 사용 금지
		// 자바스크립트에서는 문자열, 문자 비교에 다 사용 가능 
		boolean b3 = s == s1;
		System.out.println("b3 >>> : " + b3);

	}
}
