package a.b.c.ch1;

public class Exam_Limit_1 {

	public static void main(String args[]) {

		int intMax = Integer.MAX_VALUE;
		long longMax = Long.MAX_VALUE;
		
		/* 
		intMax를 int로 선언하고, Integer의 MAX_VALUE를 할당
		longMax를 long으로 선언하고, Long의 MAX_VALUE를 할당

		System : java.lang.System 클래스를 선언
		System 클래스 자바에서 시스템에 관련된 기능을 모아둔 클래스

		.: 링크 연산자 : System 클래스와 out 필드를 연결하는 연산자이다.
		out: System 클래스에 있는 변수로 스트림(아웃 풋)을 출력하는 통로 역할을 하는 변수
		. : out 필드의 println() 함수를 연결하는 링크 연산자
		println() : 콘솔에 출력을 하는 함수이다.
		print : 출력하시오.
		ln : 라인을 하나 띄우세요.

		println() 함수에 아규먼트로 있는 데이터를 콘솔에 출력 하시오.
		*/

		System.out.println("intMax >>> : " + intMax);
		System.out.println("longMax >>> : " + longMax);

		/*
		int num1 = 9223372036854775807;
		System.out.println("int num1 >>> : " + num1);		

		long num2 = 9223372036854775807;		
		System.out.println("long num2 >>> : " + num2);
		*/
		/*
		C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_Limit.java
		Exam_Limit.java:14: error: integer number too large: 9223372036854775807
						int num1 = 9223372036854775807;
								   ^
		Exam_Limit.java:17: error: integer number too large: 9223372036854775807
						long num2 = 9223372036854775807;
									^
		2 errors

		첫 번째 에러의 경우, int의 범위를 초과한 숫자라서 나온 에러이다.
		두 번째 에러의 경우, long의 범위를 초과하지 않았지만, long의 경우 마지막 세미클론
		찍기 전에 L or l을 같이 써줘서 long이라는 것을 인지 시켜줘야 한다.

		*/
		
		long num3 = 9223372036854775807L;		
		System.out.println("long num3 >>> : " + num3);

		long num4 = 9223372036854775807l;		
		System.out.println("long num4 >>> : " + num4);
	}
}