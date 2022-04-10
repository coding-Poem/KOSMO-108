package a.b.c.ch1;

public class Exam_Var_1 {

	public static void main(String args[]) {

		/*
			1. int 형 데이터 타입 선언 한다. 
			2. level : int 형 데이터 타입을 사용하려고 level 변수명은 선언한다. 
			3. = : 대입 연산자 
			4. 10 : 정수형 10 숫자(리터럴)을 선언한다.
			5. ; : 문장을 종결하는 ; 세미콜론(기호, 연산자)를 선언한다. 
		*/
		// 6. int 형 변수 level을 선언하고 값 10을 초기화 했다. 
		int level = 10;

		// level 변수명을 호출해서(불러와서) level 변수에 초기화된 데이터를 콘솔에 출력한다.
		System.out.println(level);

		int i; 
		/*
		System.out.println(i);
		Exam_Var_1.java:11: error: variable i might not have been initialized
                System.out.println(i);
                                   ^
		1 error
		*/
		i = 100;
		System.out.println(i);
	}
}