package a.b.c.ch1;

// class 키워드를 이용해서 이름이 Exam_Method 사용자 정의 클래스를 선언한다.
// 사용자 정의 클래스 Exam_Method 에 있는 구성원은 class = 변수 + 함수 
// aMethod() 함수 1개
// main() 함수 1개 
// Exam_Mehtod = aMethod() 함수, main() 함수 
public class Exam_Method {

	// 일반 언어에서 함수라 Function 하는 것을 객체지향 언어에서는 메소드 method 라고 한다. 
	// 함수의 일반적인 정의 : 하나의 기능을 수행하는 일련의 코드
	// 함수의 정의 : 기능을 모아 두는 곳
	// 함수는 데이터를 담아 두는 상자이다.

	// 함수를 선언하는 방법
	/*
	1.	클래스 블럭 안에서 선언한다.
	2.	함수 이름 앞에는
			접근 제한자 키워드를 사용할 수 있다. : public, protected, default, private 
			수정자 키워드를 사용할 수 있다. : static, final 
			리턴형을 선언할 수 있다. : void, 기초자료형, 참조자료형, 사용자정의 클래스 데이터
	3.	함수 이름은 영문자 소문자로 시작한다.(한글도 가능하나 사용하지 않는다.)
	4.	함수 이름 뒤에는 () 소괄호를 선언한다.
		소괄호 안에는 parameter(매개변수)를 순차적으로 선언할 수 있다.
	5.	소괄호 뒤에는 {} 중괄호 블럭을 선언한다.
	6.	함수에서 return 키워드를 사용하는 이유
			함수에서 선언한 변수는 직접 함수 밖으로 나갈 수가 없다.
	7.	함수 블럭 {} 안에서는 인터프리트 interprite 방식 
		(한줄씩 읽어가면서 실행하는 형식)으로 실행 된다.
	*/
	public static void aMethod(int i) {
		int ii = i; 
		System.out.println("aMethod() 함수 블럭 안에서 출력 >>> : " + ii);
	}


	// 메인 함수를 선언한다.
	public static void main(String args[]){
	
		// 사용자 정의 클래스 Exam_Method 클래스 main() 함수에서 
		// 사용자 정의 클래스 Exam_Method 에 있는 aMethod() 함수를 호출한다 invoke 한다..
		Exam_Method.aMethod(100);
		
	} // end of main() 
} // end of Exam_Method class