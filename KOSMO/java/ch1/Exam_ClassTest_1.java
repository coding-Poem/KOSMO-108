package a.b.c.ch1;


public class Exam_ClassTest_1 {

	// 멤버 변수 
	byte bVal;
	char cVal;
	short sVal;
	int iVal;
	long lVal;
	float fVal;
	double dVal;
	boolean boolVal;
	String strVal;

	public static void main(String args[]) {
		/*
		1.	Exam_ClassTest_1 클래스를 사용하려면 맨 먼저 Exam_ClassTest_1 를 인스턴스 instance 해야 한다. 
		2.	instanc 인스턴스 : 클래스를 메모리에 올리는 행위 : 가장 대표적인 연산자 new 키워드 연산자 
		3.	new 키워드 (연산자)로 인스턴스 하는 방법(메모리에 올리는 방법)
			3.1		사용하려고하는 클래스(빌트인 클래스rt.jar에 있는 클래스, 사용자정의 클래스)를 클래스 이름으로 선언한다.
			3.2		참조변수 reference variable 을 선언한다.
					이 참조변수 메모리에 올라간 클래스를 참조해서 
					클래스 블럭에 선언한 변수, 함수를 참조변수.(도트연산자) 를 이용해서 사용할 수 있다. 
			3.3		= 대입 연산자 선언
			3.4		클래스 이름 뒤 () 소괄호를 붙여서 생성자를 만든다.
					===================================================
					생성자가 메모리에 올라가면(인스턴스 되면) 
					해당 클래스에 있는 멤버변수를 디폴트 값으로 초기화 한다. 
					===================================================
			클래스이름 참조변수 = new 클래스이름(); 
			클래스이름() <--- 이 넘을 생성자라고 한다. 
							이 생성자가 해당 클래스 내부에 선언한 멤버변수를 디폴트 값으로 초기화 한다.
		*/

		Exam_ClassTest_1 ec = new Exam_ClassTest_1();
		System.out.println("ec 참조변수 주소값 >>> : " + ec);
		System.out.println("ec.bVal >>> : " + ec.bVal);
		System.out.println("ec.cVal >>> : " + ec.cVal);
		System.out.println("ec.sVal >>> : " + ec.sVal);
		System.out.println("ec.iVal >>> : " + ec.iVal);
		System.out.println("ec.lVal >>> : " + ec.lVal);
		System.out.println("ec.fVal >>> : " + ec.fVal);
		System.out.println("ec.dVal >>> : " + ec.dVal);
		System.out.println("ec.boolVal >>> : " + ec.boolVal);
		System.out.println("ec.strVal >>> : " + ec.strVal);
	} // end of mai()
} // end of Exam_ClassTest 