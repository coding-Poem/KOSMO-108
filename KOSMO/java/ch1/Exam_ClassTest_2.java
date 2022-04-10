package a.b.c.ch1;

public class Exam_ClassTest_2 {

	// 멤버 변수
	// 상수
	public static final int ID_NUM = 1;
	// 스태틱 변수, 클래스 변수
	static int id_val = 11;
	// 전역 변수
	public int iVal_G;
	// 멤버 변수
	int iVal;

	// 리턴형이 없는 함수, static 없는 함수
	public void aMethod(){
		System.out.println("aMethod()");
	}

	// 리턴형이 없는 함수, static 있는 함수
	public static void aaMethod(){
		System.out.println("aaMethod()");
	}

	// 리턴형 int, static 없는 함수 
	public int bMethod(){
		System.out.println("bMethod()");
		return 1 + 1;
	}

	// 리턴형 int, static 있는 함수 
	public static int bbMethod(){
		System.out.println("bbMethod()");
		return 10 + 10;
	}

	
	public static void main(String args[]) {
		
		// static 있는 자원(변수, 함수) 호출하는 방법
		// 패키지명.클래스이름.자원이름 
		System.out.println("Exam_ClassTest_2.ID_NUM >>> : " + Exam_ClassTest_2.ID_NUM + "\n");
		System.out.println("Exam_ClassTest_2.id_val >>> : " + Exam_ClassTest_2.id_val + "\n");
		
		// println() 함수에 void 리턴형 함수(리턴값이 없는 함수)는 사용할 수 없다. 
		// System.out.println("Exam_ClassTest_2.aaMethod() >>> : " + Exam_ClassTest_2.aaMethod());
		// Exam_ClassTest_2.java:44: error: 'void' type not allowed here
        //        System.out.println("Exam_ClassTest_2.aaMethod() >>> : " + Exam_ClassTest_2.aaMethod());
        //                           ^
		// 1 error
		
		//void 리턴형 함수(리턴값이 없는 함수)는 하기와 같이 함수를 호출해서 사용한다.
		Exam_ClassTest_2.aaMethod();
		
		// 리턴형이 있는 함수는 println() 함수 에서 사용이 가능한다. 
		System.out.println("\n Exam_ClassTest_2.bbMethod() >>> : " + Exam_ClassTest_2.bbMethod() + "\n");
		
		// 리턴형이 있는 함수는 리턴 값을 받아서 사용해도 된다.
		int iBB = Exam_ClassTest_2.bbMethod();
		System.out.println("\n iBB >>> : " + iBB + "\n");

		Exam_ClassTest_2 ec2 = new Exam_ClassTest_2();
		System.out.println("ec2 참조변수 주소값 >>> : " + ec2 + "\n");
		System.out.println("ec2.iVal_G >>> : " + ec2.iVal_G + "\n");
		System.out.println("ec2.iVal >>> : " + ec2.iVal + "\n");	
		
		ec2.aMethod();
		
		// 리턴형이 있는 함수는 println() 함수 에서 사용이 가능한다. 
		System.out.println("\n ec2.bMethod() >>> : " + ec2.bMethod());
		
		// 리턴형이 있는 함수는 리턴 값을 받아서 사용해도 된다.
		int iB = ec2.bMethod();
		System.out.println("\n iB >>> : " + iB + "\n");

	} // end of mai()
} // end of Exam_ClassTest 