package a.b.c.ch1;

// 함수 안에서 사용하는 변수의 유효 범위
// 함수에서 선언하는 변수는  
// {} 중괄호 블럭에서 선언하고 {} 중괄호 블럭에서 사용해야 한다. 
public class Exam_Var_2 {

	// 메인 함수 콘솔 어플리케이션의 시작점이다. 
	public static void main(String args[]) {
		System.out.println("Exam_Var_2.main() 함수 시작");
		System.out.println("인터프르트 방식으로 수행 된다. ");
		System.out.println("main() 함수 블럭 왼쪽 부터 오른쪽 80컬럼 기준으로 수행된다.");

		// 변수를 선언하고 초기화 했다.
		// 선언한 변수명 i 의 유효 범위는(사용할 수 있는 범위)
		// i 선언한 하위 라인부터 main 함수 블럭이 끝난 라인까지 유효하다.
		// System.out.println(">>> : " + i);

		int i = 10;

		System.out.println(">>> : " + i);
		
		// 이름이 없는(익명) 블럭을 선언 했다.
		{
			int ii = 1000;
			System.out.println(">>> : " + ii);
			System.out.println("{} 안에서 >>> : " + i);
			i = 101;
		}
		/*
		System.out.println(">>> : " + ii);
		C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_Var_2.java
		Exam_Var_2.java:23: error: cannot find symbol
						System.out.println(">>> : " + ii);
													  ^
		  symbol:   variable ii
		  location: class Exam_Var_2
		1 error
		*/
		System.out.println(">>> : " + i);
	} // end of main()
} // end of Exam_Var_2 class