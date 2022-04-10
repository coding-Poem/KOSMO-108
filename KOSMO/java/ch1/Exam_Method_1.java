package a.b.c.ch1;

// 사용자 정의클래스 Exam_Method_1 클래스에는 자원이 무엇이 있는가요 ??
// class 의 자원 class = 변수 + 함수 
// 함수 4개 : main() 함수 +  사용자 정의함수 3개
// 컴파일하고 : 
// 실행 하기 : 

// 자바는 인터프리트 방식으로 수행된다. 함수 블럭 안에서만 인트프리트 방식으로 수행 된다. 
// 자바 콘솔 어플리케이션은 main() 함수부터 시작을 한다. 
// main() 함수 블럭을 한줄씩 읽어 가면서 수행 된다.

// Exam_Method_1 자바 소스를 컴파일한다.
// Exam_Method_1 클래스 파일을 실행한다.
/*
	1. Exam_Method_1 클래스 안에 있는 main() 함수를 호출한다.
	2. main()의 블럭의 첫 번째 라인을 읽어서 수행한다.
*/

/*
==========================================
자바 콘솔 어플리케이션 시작은 main() 함수이다. 
main() 함수 블럭에서 한 줄씩 읽어가면서 
함수를 호출하면서 수행 된다. 

메인 함수의 위치는 실행 순선와 관계 없다.
보통 자바에서는 main() 함수는 맨 아래쪽에 위치하게 한다.
==========================================
*/

// 식별자 : identifier 사용 규칙
// 클래스 이름, 변수 이름, 메소드(함수) 이름 

public class Exam_Method_1 {
	
	/*
	// 메인 함수를 선언한다.
	public static void main(String args[]){
		System.out.println("첫 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 main() 함수 시작 >>> : ");
		System.out.println("두 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 aM() 함수를 호출한다. >>> : ");
		System.out.println("aM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.aM();
		System.out.println("세 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 cM() 함수를 호출한다. >>> : ");
		System.out.println("cM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.cM();
		System.out.println("네 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 bM() 함수를 호출한다. >>> : ");
		System.out.println("bM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.bM();
	} // end of main() 
	*/


	public static void aM() {
		System.out.println("aM() method  함수");
		System.out.println("aM() method  함수 블럭 두 번째 라인에서 bM() 함수 호출을 한다.");
		Exam_Method_1.bM();
	}

	public static void bM() {
		System.out.println("bM() method  함수");
	}

	public static void cM() {
		System.out.println("cM() method  함수");
	}

	public static void ddddM() {
		System.out.println("ddddM() method  함수");
	}

	// 메인 함수를 선언한다.
	public static void main(String args[]){
		System.out.println("첫 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 main() 함수 시작 >>> : ");
		
		System.out.println("두 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 aM() 함수를 호출한다. >>> : ");
		System.out.println("aM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.aM();
		
		System.out.println("세 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 cM() 함수를 호출한다. >>> : ");
		System.out.println("cM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.cM();
		
		System.out.println("네 번째 라인에서 Exam_Method_1 클래스 블럭에 있는 bM() 함수를 호출한다. >>> : ");
		System.out.println("bM() 함수 블럭의 첫 번째 라인이 수행된다. >>> : ");
		Exam_Method_1.bM();
	} // end of main() 	
} // end of Exam_Method class