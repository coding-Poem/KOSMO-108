package a.b.c.prac1;

public class Invoke_p {
	public Invoke_p() {
		System.out.println("저는 Invoke_p() 기본 생성자입니다.");
		aM();
		// aM() invoke
	}
	
	void aM(){
		System.out.println("저는 aM() 함수입니다.");
		bM();
		// bM() invoke
	}
	// aM이 아닌 aaM이라고 이름을 지으면,
		/*
		 Exception in thread "main" java.lang.Error: 
		 Unresolved compilation problem: 
		 The method aM() is undefined for the type Invoke_p
		 */
		// aM() 에서 first error 
		// new Invoke_p();에서 second error
		// new 인스턴스 연산자로 객체 생성 후, 생성자 호출후에
		// aM method를 호출했는데, error는 반대로 출력된다.
	
	void bM(){
		System.out.println("저는 bM() 함수입니다.");
		cM();
		// cM() invoke
	}
	// bM이 아닌 bbM이라고 이름을 지으면,
	// bM();에서 first error
	// aM();에서 second error
	// new Invoke_p();에서 third error
	
	void cM(){
		System.out.println("저는 cM() 함수입니다.");
	}
	// cM이 아닌 ccM이라고 이름을 지으면
	// cM(); fist error
	// bM(); second error
	// aM(); third error
	// new Invoke_p(); firth error

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Invoke_p();
		// 생성자를 new 키워드로 인스턴스한다.
		// Invoke_p invoke

	}

}
