package a.b.c.ch5;

// 함수를 부르는 행위를 프로그램에서는 
// 함수를 호출한다 하고 부는다. invoke 한다.
// 호출한다라는 의미는 invoke와 뜻이 같다.

public class Exam_Invoke {

	// 기본 생성자 
	Exam_Invoke() {
		System.out.println("Exam_Invoke() 생성자 >>> : ");
		
		// aM() 함수를 호출 한다.
		aM();
	}
	// 기본 생성자는 해당 클래스의 함수를 호출할 수 있다.
	
	void aM() {
		System.out.println("aM() 함수 >>> : ");
		
		// bM() 함수를 호출한다.
		bM();
	}

	void bM() {
		System.out.println("bM() 함수 >>> : ");
		
		// cM() 함수를 호출한다.
		cM();
	}
	
	void cM() {
		System.out.println("cM() 함수 >>> : ");		
	}
	
	// main() 함수는 그 프로그램의 시작점이다. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Exam_Invoke() 생성자를 호출한다. invoke 한다.
		// "invoke".equals("호출한다.");
		// "호출한다.".equals("invoke");
		new Exam_Invoke();
	}
}
