package a.b.c.ch1;

public class Exam_Static {

	static byte b;

	static void aM(){
		System.out.println("aM() 함수 ");
	}

	// 자바 프로그램에서 main() 함수는 
	// 맨 아래쪽에 기술해 놓는다. 
	public static void main(String args[]) {
	
		Exam_Static.aM();
		// static 키워드가 붙은 변수를 호출 사용할 때는 
		// 클래스이름.변수이름으로 호출해서 사용한다. 
		System.out.println("b >>> : " + Exam_Static.b);
		System.out.println("b >>> : 이것도 되는데 이케는 사용하지 말기 >>> : " + b);

		// static 키워드가 붙은 함수를 호출할 때는 
		// 클래스이름.함수이름으로 호출해서 사용한다.
		Exam_Static.aM();

		// 단 static 키워드가 붙어있는 함수에서는
		// static 키워드를 사용할 수가 없다. 
		// 예) main() 함수 블럭에서는 static 키워드를 사용할 수 없다. 
		//     static void main() : main() 함수 앞에 static 키워드가 있다. 
	}
}