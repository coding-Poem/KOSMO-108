package a.b.c.ch1;

public class Exam_String_3 {

	public void stringTest() {
		System.out.println("Exam_String_2.stringTest() 함수 시작 >>> : ");

		/*
		1. String 클래스 선언
		2. String 클래스 사용하려고 str0 변수 선언
		3. = : 대입 연산자 선언 : 오른쪽에 있는 값을 왼쪽에 있는 변수명에 대입한다.
		4. "" : 리터럴 (문자) : 빈문자열
		5. ; 문자 종결 연산자 
		6. str0  변수에 빈문자열을 대입한다. 
		*/
		String str0 = ""; // 빈문자열로 초기화 하는 방법
		//  str0 참조변수를 선언해서 도트연산자로 String 클래스에 있는 length() 함수를 호출했다.
		//  결과 값 str0 의 대입한  "" 빈 문자열의 값을 가지고 있다. 
		str0.length();

		// System.out.println() 문장으로 콘솔에 출력을 한다.
		System.out.println("" + str0.length());

		// str0.length() 호출한 결과 값을 str0Length 변수에 대입한다. 활당한다. 치환한다.
		int str0Length = str0.length();
		// 위 표현식이 수행되고 난 후에는 str0Length 변수 0 값이 대입되어 있다. 

		// System.out.println() 문장으로 str0Length 변수에 대입된 값을 콘솔에 출력한다. 
		System.out.println("" + str0Length);
	}

	public static void main(String args[]) {
		
		new Exam_String_3().stringTest();
	}
}