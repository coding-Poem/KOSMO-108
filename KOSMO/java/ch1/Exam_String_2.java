package a.b.c.ch1;

/*
1. ASCII(American Standard Code for Information Interchange)
	ASCII는 최초의 문자열 인코딩이다.
	7 bit로 구성되어 있으며, 영어를 위한 문자, 숫자, 특수문자, 기호 등 128개 문자를 표현할 수 있다.

2. ANSI(American National Standard Institute)
	ANSI는 8bit로 구성되어 있으며 256개의 문자를 표현할 수 있다.
	ANSI의 앞 7bit는 ASCII와 동일하고, 뒤에 1bit를 이용하여 다른 언어의 문자를 표현한다.
*/

public class Exam_String_2 {

	public void stringTest() {
		System.out.println("Exam_String_2.stringTest() 함수 시작 >>> : ");
		System.out.println("String 클래스에서 문자열 떠블 쿼테이션을 사용한다.");

		// 스트링 클래스를 초기화 하는 방벙
		String str0 = ""; // 빈문자열로 초기화 하는 방법
		String str1 = null; // null 로 초기화 하는 방법 : default 값
							// 데이터가 없다는 의미이므로 데이터를 초기화(데이터 값) 해서 사용해야한다.
		String str2 = " ab c  ";

		// public int length()		
		System.out.println("str0.length() 문자열 길이를 구하는 함수 >>> : " + str0.length());
		int str0Length = str0.length();
		System.out.println("str2Length 문자열 길이를 구하는 함수 >>> : " + str0Length);		
		System.out.println("str2.length() 문자열 길이를 구하는 함수 >>> : " + str2.length());
		int str2Length = str2.length();
		System.out.println("str2Length 문자열 길이를 구하는 함수 >>> : " + str2Length);

		// System.out.println("str1.length() 문자열 길이를 구하는 함수 >>> : " + str1.length());
		/*
		Exception in thread "main" java.lang.NullPointerException
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:22)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:29
		*/

		System.out.println("str0 >>> : " + str0);
		System.out.println("str1 >>> : " + str1);
		System.out.println("str2 >>> : " + str2);

		// System.out.println("str0.charAt(0) >>> : " + str0.charAt(0));
		/*
		Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        at java.lang.String.charAt(String.java:658)
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:34)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:41)		
		*/
		// System.out.println("str1.charAt(0) >>> : " + str1.charAt(0));
		/*
		Exception in thread "main" java.lang.NullPointerException
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:41)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:47)		
		*/
		System.out.println("str2.charAt(0) >>> : " + str2.charAt(0));
		System.out.println("(int)str2.charAt(0) >>> : " + (int)str2.charAt(0));
		// public static String toHexString(int i)
		System.out.println("Integer.toHexString(str2.charAt(0)) >>> : " 
							+ Integer.toHexString(str2.charAt(0)));
		System.out.println("Integer.toHexString(str2.charAt(1)) >>> : " 
									+ Integer.toHexString(str2.charAt(1)));
		System.out.println("Integer.toHexString(str2.charAt(2)) >>> : " 
									+ Integer.toHexString(str2.charAt(2)));
		System.out.println("Integer.toHexString(str2.charAt(3)) >>> : " 
									+ Integer.toHexString(str2.charAt(3)));
		System.out.println("Integer.toHexString(str2.charAt(4)) >>> : " 
									+ Integer.toHexString(str2.charAt(4)));
		System.out.println("Integer.toHexString(str2.charAt(5)) >>> : " 
									+ Integer.toHexString(str2.charAt(5)));
		System.out.println("Integer.toHexString(str2.charAt(6)) >>> : " 
									+ Integer.toHexString(str2.charAt(6)));	
	}

	public static void main(String args[]) {
		
		new Exam_String_2().stringTest();
	}
}