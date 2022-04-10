package a.b.c.ch2;

/*
자바에서 클래스를 만들면 (빌트인 클래스, 사용자 정의 클래스)
무조건 java.lang.Object  클래스를 상속하게 되어 있다.
그래스 실제로 클래스를 구성할 때는 상속하는 구문을 생략한다. 

java.lang.Object 클래스는 자바에서 수퍼 클래스, 최고 조상 클래스 라고 한다. 
생성자 1개
함수 11개
빌트인 클래스, 사용자정의 클래스는 위의 자원을 사용할 수 있다.

extendst 키워드로 클래스를 상속하면 
상속해준 클래스가 메모리에 먼저 올라간다.
*/
// public class Exam_Object extends java.lang.Object {
public class Exam_Object {
	// java.lang.Object
	// public String toString()
	public String toString() {
		
		System.out.println("나는 Object 클래스에 있는 toString() 함수이다.");
		
		return "문자를 리턴한다.";
	}

	public static void main(String args[]) {
		
		System.out.println("Java Hello ~~~ !!");
		
		Exam_Object eo = new Exam_Object();
		System.out.println("eo 참조변수 주소값 >>> : " + eo);
		// System.out.println("eo.toString() 참조변수 주소값 >>> : " + eo.toString());

	}
}