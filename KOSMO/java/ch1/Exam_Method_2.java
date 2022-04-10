package a.b.c.ch1;

public class Exam_Method_2 {
	
	// int 형 데이터 타입, 자료형, 프라이머티브 타입 : 리턴형 
	// 리턴형 : 함수에서 출력하는(밖으로 내보내는) 테이터 타입을 말한다. 
	// return 키워드 뒤에 쓰는 데이터 타입(형)이 이 함수에서는 int 형 이어야 한다.
	// static int :  int 자료형 하고 return a + b 의 결과 값의 자료형이 int 형으로 동일 해야 한다.
	// 함수의 리턴형과 return 키워드 뒤에 선언되는 데이터형은 항시 동일해야 한다. 아니면 에러가 발생한다. 
	static int addMethod() {
		// addMethod() 함수 블럭에 있지만, 리턴 대상이 아니다. 
		// 콘솔에 출력하라는 명령문이다. 
		System.out.println("Exam_Method_2 클래스에 있는 addMethod() 메소드(함수) ");
		
		int a = 1;
		int b = 2;

		// addMethod() 함수의 리턴값은 a + b 의 결과 값이다. 
		// 리턴값 a + b 의 데이터 형 과 addMethod() 선언부에 있는 int 리턴형은 데이터 타입이 항시 동일해야 한다. 
		return a + b;
	}
	
	// default 키워드 접근 제한자 access modifier
	// a.b.c.ch1 패키지(폴더) 내에서만  호출할 수 있다. 
	static void aM() {
		System.out.println("Exam_Method_2 클래스에 있는 aM() 메소드(함수) ");
	}

	// public 키워드 접근 제한자 access modifier
	// a.b.c.ch1 패키지(폴더) 가 아닌 폴더에서도 호출할 수 있다. 
	public static void bM() {
		System.out.println("bM() method  함수");
	}

	// 메인 함수를 선언한다.
	public static void main(String args[]){
		System.out.println("Exam_Method_2 클래스에 있는 main() 메소드(함수) \n");
		
		System.out.println("리턴형이 있는 함수는 리턴 값을 받는 변수를 선언해서 사용한다. ");
		System.out.println("Exam_Method_2.addMethod() 함수 호출 결과 >>> : " 
								+ Exam_Method_2.addMethod());
		int sum = Exam_Method_2.addMethod();
		// int sum = 3 (return [a + b = 3]);
		System.out.println("int sum = " + sum + "\n");
		
		System.out.println("리턴형이 void인 함수는(리턴 값이 없는 함수, return 키워드가 없는 함수)는");
		System.out.println("리턴값을 받는 변수를 사용하지 않는다. 그냥 함수만 호출해서 사용한다.");
		Exam_Method_2.aM();
		
	} // end of main() 	
} // end of Exam_Method_2 class