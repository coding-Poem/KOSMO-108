package a.b.c.ch1;

/*
	함수에서 
	파라미터 parameter 매개변수 선언하기
	함수 호출할 때 인수 argument를 사용하는 방법
*/

public class Exam_Method_3 {
	
	// 더하기 함수를 만들기
	/*
		함수를 선언할 때(함수를 만들 때) 
		함수 이름 뒤에 () 소괄호를 선언해서 
		소괄호에 데이터 타입을 선언하고 변수명을 선언하는 것을
		우리는 파라미터 parameter 매개변수라고 부른다.
		매개변수 : 연결해 주는 변수
	*/
	static int addMethod(int x, int y) {		
		System.out.println("Exam_Method_3 클래스에 있는 addMethod() 메소드(함수) ");	

		int addSum = x + y;

		return addSum;
	}
	
	// 메인 함수를 선언한다.
	public static void main(String args[]){
		System.out.println("Exam_Method_3 클래스에 있는 main() 메소드(함수) \n");

		// 변수를 선언해서 초기화 했다.
		int x = 1;
		int y = 2;

		// 함수를 호출할 때 
		/*
			함수를 호출할 때 
			함수 이름 뒤 소괄호에 선언하는 값 또는 변수를 
			우리는 아규먼트 argument 인수 라고 부른다. 
		*/
		int addSum = Exam_Method_3.addMethod(x, y);
		// static int addMethod(int x, int y) ==> static int addMethod(x = 1, y = 2) 
		/*
		==========================================================
			아규먼트의 변수명 addMethod(x, y) 과 
			파라미터의 변수명 addMethod(int x, int y)은 동일하지 않아도 된다.
			여기서 x, y 와 int x, int y의 변수명은 같지 않아도 된다.
		==========================================================
		*/
		System.out.println("addSum >>> : " + addSum + "\n");

		System.out.println("Exam_Method_3.addMethod(x, y) >>> : " 
							+ Exam_Method_3.addMethod(x, y) + "\n");

		int addSum_1 = Exam_Method_3.addMethod(1, 2);
		System.out.println("addSum_1 >>> : " + addSum_1 + "\n");

		System.out.println("Exam_Method_3.addMethod(1, 2) >>> : " 
							+ Exam_Method_3.addMethod(1, 2) + "\n");

	} // end of main() 	
} // end of Exam_Method_2 class