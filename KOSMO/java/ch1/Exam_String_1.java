package a.b.c.ch1;


public class Exam_String_1 {

	public void arrayTest() {
		System.out.println("Exam_String.arrayTest() 함수 시작 >>> : ");

		// java.lang.System
		// public static int identityHashCode(Object x)

		// char(차) 데이터타입의 배열이다.
		char cArray[] = {'a', 'b', 'c'};
		System.out.println("cArray >>> : " + cArray);
		System.out.println("System.identityHashCode(cArray) >>> : " 
						+ System.identityHashCode(cArray));

		// String 클래스(문자열 클래스)를 인스턴스 했다.
		String str = new String(cArray);
		System.out.println("str >>> : " + str);
		System.out.println("System.identityHashCode(str) >>> : " 
						+ System.identityHashCode(str));

		// String 클래스(문자열 클래스)를 인스턴스 했다.
		String str1 = new String("abc");
		System.out.println("str1 >>> : " + str1);
		System.out.println("System.identityHashCode(str1) >>> : " 
						+ System.identityHashCode(str1));

		//===========================================================
		// 이것만 사용하면 된다.
		String str2 = "abc";
		System.out.println("str2 >>> : " + str2);
		System.out.println("System.identityHashCode(str2) >>> : " 
						+ System.identityHashCode(str2));
		//===========================================================
	}

	public static void main(String args[]) {
		
		new Exam_String_1().arrayTest();
	}
}