package a.b.c.ch1;

// System.out.println() 문장으로 log 를 찍는다.
public class Exam_ClassTest_3 {

	public int aMethod() {
		System.out.println("	Exam_ClassTest_3.aMethod() 시작 >>> : \n");
		
		int x = 1;
		int y = 2;
		System.out.println("	Exam_ClassTest_3.aMethod() >>> : " + x + " : " + y);
		int addSum = x + y;
		System.out.println("	Exam_ClassTest_3.aMethod() >>> : " + x + " + " + y + " = " + addSum + "\n");
		System.out.println("	Exam_ClassTest_3.aMethod() 끝 >>> : \n");
		
		return addSum;
		// return 키워드 statement 를 수행하고 ; 종결 문자를 한 뒤에는 
		// 어떤 구문도 허락하지 않는다.
		/*
		System.out.println("Exam_ClassTest_3.aMethod() 끝 >>> : ");
		Exam_ClassTest_3.java:10: error: unreachable statement
                System.out.println("Exam_ClassTest_3.aMethod() 끝 >>> : ");
                ^
		Exam_ClassTest_3.java:11: error: missing return statement
			}
			^
		2 errors
		*/
	}
	
	public static void main(String args[]) {
		System.out.println("Exam_ClassTest_3.main() 시작 >>> : \n");

		Exam_ClassTest_3 ec3 = new Exam_ClassTest_3();
		System.out.println("ec3 >>> : " + ec3 + "\n");
		System.out.println("ec3.aMethod() >>> : " + ec3.aMethod());
		
		System.out.println("Exam_ClassTest_3.main() 끝 >>> : ");	
	} // end of mai()
} // end of Exam_ClassTest 