// 패키지 a.b.c.ch1 을 선언한다.
package a.b.c.ch1;

// 일반 클래스 Exam_Variable을 선언한다.
// public 키워드를 선언해서 다른 패키지에서 사용할 수 있게 한다.
public class Exam_Variable {

	// 콘솔 어플리케이션 main() 함수를 선언한다. 
	public static void main(String args[]) {
	
		// 콘솔에 Exam_Variable 문자열을 출력한다.  
		System.out.println("Exam_Variable");

		// 변수를 선언하고 값을 넣는다.
		/*
			int : 자료형 선언
			i : 변수명 선언
			= : 대입연산자 선언 : 오른쪽에 있는 값 10을 왼쪽에 있는 변수명 i에 넣은다(대입한다).
			10 : 값 variable data 선언
			; : 문장 종결 : statement(int i = 10) 종결 하기 
		
		*/
		// int 형 자료형은 선언하고 변수명을 i 로 선언해서 값 10을 초기화 한다.
		int i = 10;

		// 콘솔에 문자열 Exam_Variable >>> : 를 출력하고 
		// i 변수의 값을 콘솔에 출력한다.
		// + : 더하기 연산자 : "Exam_Variable >>> : "  문자열과 숫자 i (10)더 한다.
		// 자바에서 문자열 과 숫자를 더하기 연산자로 더하면 문자열로 바뀐다. 
		System.out.println("Exam_Variable >>> : " + i);

	// main() 함수 블럭을 닫는다.
	} // end of main()

// 일반 클래스 Exam_Variable 블럭을 닫는다.
} // end of Exam_Variable