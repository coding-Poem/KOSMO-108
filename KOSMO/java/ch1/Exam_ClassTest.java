package a.b.c.ch1;


public class Exam_ClassTest {

	// 멤버 변수 
	int iVal;

	// 스태틱 변수, 클래스 변수 
	// static 키워드가 붙은 변수는 
	// 실행할 때 자바 버철머신(JVM)이 해당 변수에 값을 초기화 해준다.
	static int iValStatic;

	// void : 리턴값이 없다 : return 키워드를 사용할 수 없다.
	public static void main(String args[]) {
		System.out.println("main() 함수는 콘솔어플리케이션 시작점이다.");
		System.out.println("함수 블럭안에서는 인터프리트 방식으로 수행된다.");

		// 함수 블럭 내부에서 선언한 지역 변수이다.
		// 지역 변수는 사용하기 전에 무조건 초기화가 되어 있어야 한다. 
		int i = 10;
		System.out.println("i >>> : " + i);

		// static 변수 호출하기 
		System.out.println("iValStatic >>> : " + iValStatic);
		
		// System.out.println("iVal >>> : " + iVal);
		/*
		C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_ClassTest.java
		Exam_ClassTest.java:17: error: non-static variable iVal cannot be referenced from a static context
                System.out.println("iVal >>> : " + iVal);
                                                   ^
		1 error
		*/

		// static 키워드가 붙지 않은 iVal 멤버 변수 사용법
		// iVal 멤버변수를 메모리에 올려야 한다. 
		Exam_ClassTest ec = new Exam_ClassTest();
		System.out.println("Exam_ClassTest 사용자정의 클래스의 변수(참조변수) ec >>> : \n" + ec);
		System.out.println("ec.iVal >>> : " + ec.iVal);

		Exam_ClassTest ec_1 = new Exam_ClassTest();
		System.out.println("Exam_ClassTest 사용자정의 클래스의 변수(참조변수) ec_1 >>> : \n" + ec_1);
		System.out.println("ec_1.iVal >>> : " + ec_1.iVal);

		System.out.println(  "스태틱변수는 참조변수로 참조해서 사용하면 않된다. \n"
						   + "ec_1.iValStatic >>> : " + ec_1.iValStatic);
	} // end of mai()
} // end of Exam_ClassTest 