package a.b.c.ch1;

// 교재 112 쪽
// 어떤 조건 부터 어떤 조건 까지 반복 수행 
// from        to          loop
public class Exam_For {

	public static void main(String args[]) {

		// 자바에서 for 
		// for 키워드
		// (초기화식; 조건식; 증감식) 소괄호 
		//		초기화식 : 데이터타입 선언 변수 선언 = 값 초기화; int i = 0;
		//		조건식 : boolean = 1 < 5;
		//		증감식 : 초기화 식에 선언한 변수를 이용해서 증감식을 쓴다. i++
		//		증감식 연산자는 : 전위, 후위, ++, --, 배수 무엇이든 사용가능하다.
		// { 반복수행할 표현식;} 중괄호 

		// 자바에서는 for 키워드를 자바 버철머신이 보면 
		// for 키워드 뒤에 () 가 있으면 무조건 반복 수행한다. 

		/*
		for (초기화식; 조건식 ; 증감식) {
			초기화 식에서 선언한 변수를 사용한다. 
			System.out.println(">>>>");
		}
		*/

		/*
		for (int i=0; ; ){
			System.out.println("i >>> : " + i);
		}
		*/
		/*
		int i=0;
		for (; ; ){
			System.out.println("i >>> : " + i);
		}
		*/
		/*
		int i;
		for (i=0; ; ){
			System.out.println("i >>> : " + i);
		}
		*/
		/*
		int i;
		for (i=0; i < 3;){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
		*/
		/*
		int i;
		for (i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
		*/
		/*
		int i;
		for (i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
		System.out.println("for {} 블럭 외부 ::: i >>> : " + i);
		*/
		for (int i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
		System.out.println("for {} 블럭 외부 ::: i >>> : " + i);

	}
}