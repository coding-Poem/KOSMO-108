package a.b.c.ch1;

/*
제어 흐름 : Flow Control
	if, swhich

	for, while, do while 
*/
public class Exam_FlowControl {

	public static void main(String args[]) {

		// if 문을 조건 분기문 이라하고 
		// if 절에는 참인 경우가 실행 되고 
		// else 절에는 if 절의 참의 반대인 거짓일 대 실행된다. 
		// if 절은 () 소괄호에 사용하는 표현식의 결과가 참(true) 인경우만 수행된다.
		
		if (true) {
			System.out.println("true");
		}

		if (false) {
			System.out.println("false");
		}

		boolean bool = false;
		System.out.println("bool >>> : " + bool);
		if (bool) {
			System.out.println("true bool");
		}

		bool = true;
		System.out.println("bool >>> : " + bool);
		System.out.println("!bool >>> : " + !bool);
		
		if (!bool) {
			System.out.println("true bool");
		}

	}
}