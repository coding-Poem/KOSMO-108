package a.b.c.ch1;

// String 클래스 : 문자열을 다루는 클래스 : char 배열이다. 문자의 배열이다.

// 배열 : 데이터를 순차적(index, 첨자)으로 관리하는 객체 
// 배열 연산자 [] 대괄호 braket 브라켓 
// 배열 종류 : 1차원 배열, 2차원 배열.... 가변 배열
// 1차원 배열 : 
// 데이터형 참조변수[] 배열연산자 = new 데이터형[배열이 들어갈 공간] 배열연산자;
// 데이터형 참조변수[] = new 데이터형[]{};
// 데이터형 참조변수[] = {};

public class Exam_String {

	public void arrayTest() {
		System.out.println("Exam_String.arrayTest() 함수 시작 >>> : ");

		// char(차) 데이터타입의 배열이다.
		char cArray[] = {'a', 'b', 'c'};
		System.out.println("cArray >>> : " + cArray);
		System.out.println("cArray[0] >>> : " + cArray[0]);
		System.out.println("cArray[1] >>> : " + cArray[1]);
		System.out.println("cArray[2] >>> : " + cArray[2]);

		// String 클래스(문자열 클래스)를 인스턴스 했다.
		String str = new String(cArray);
		System.out.println("str >>> : " + str);
		System.out.println("str.charAt(0) >>> : " + str.charAt(0));
		System.out.println("str.charAt(1) >>> : " + str.charAt(1));
		System.out.println("str.charAt(2) >>> : " + str.charAt(2));

		// String 클래스(문자열 클래스)를 인스턴스 했다.
		String str1 = new String("abc");
		System.out.println("str1 >>> : " + str1);
		System.out.println("str1.charAt(0) >>> : " + str1.charAt(0));
		System.out.println("str1.charAt(1) >>> : " + str1.charAt(1));
		System.out.println("str1.charAt(2) >>> : " + str1.charAt(2));

		//===========================================================
		// 이것만 사용하면 된다.
		String str2 = "abc";
		System.out.println("str2 >>> : " + str2);
		System.out.println("str2.charAt(0) >>> : " + str2.charAt(0));
		System.out.println("str2.charAt(1) >>> : " + str2.charAt(1));
		System.out.println("str2.charAt(2) >>> : " + str2.charAt(2));
		//===========================================================
	}

	public static void main(String args[]) {
		
		new Exam_String().arrayTest();
	}
}