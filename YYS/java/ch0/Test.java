// 패키지를 선언 했다.
package a.b.c;


// 사용자 정의로 일반 클래스를 만들려고 선언 했다. 
// 클래스 구성원 = 변수 + 함수
// 사용자 정의 Text = 변수 (s, i) + 함수 (aM(), bM(), main())
public class Test {

	// 변수 
	String s;
	int i;

	void aM(){
		System.out.println("리턴값이 없는 aM() 메소드");
	}

	// bM() 메소드를 호출하면 리턴값으로 3 이 리턴된다.
	int bM(){
		System.out.println("리턴값이 있는 bM() 메소드");

		return  1 + 2;
	}

	// main() 함수는 콘솔 어플리케이션의 시작 점이다.
	// 함수에는 인터프리터 방식으로 수행 된다. 
	public static void main(String args[]) {
	
		// main() 함수에서 사용자 정의 Test 클래스를 사용하려고
		// new 연산자로 사용자 정의 Test 클래스를 인스턴스 한다.(메모리에 올린다).

		/*
		1. Test 클래스 선언을 한다.
		2. 참조변수를 선언한다. 참조변수 명은 개발자가 정한다. 단 변수의 첫 문자는 소문자로한다.
		3. = 대입 연산자을 선언한다.
		4. new 키워드(연산자) 를 선언한다. new 인스턴스 연산자르 선언 한다.
		5. Test() 생성자를 선언한다. 사용자정의 클래스 이름 + () 소괄호로 만든다.
		6. 상기 라인을 JVM이 수행하면 사용자 정의 클래스의 자원이 
			(사용자 정의 Text = 변수 (s, i) + 함수 (aM(), bM(), main())
			메모리에 올라가고 
			멤버변수 데이터 타입의 기본값 default 값으로 초기화 한다.
			String s = null, int i = 0;
			참조변수에 사용자정의 클래스의 자원을 가르키는 주소값이 할당된다.
		*/
		Test t = new Test();



		// 상기 인스턴스 과정이 수행되면
		// Test 클래스의 참조변수 t 를 사용해서(가지고) Test 클래스의 
		// 자원을 호출해서 사용할 수 있다.ㅏ 
		System.out.println("t 참조변수 주소값 >>> : " + t);
		System.out.println("t.s >>> : " + t.s);
		System.out.println("t.i >>> : " + t.i);	
		t.aM();
		int ii = t.bM();
		System.out.println("ii >>> : " + ii);	
	}
}