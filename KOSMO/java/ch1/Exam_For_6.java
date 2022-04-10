package a.b.c.ch1;

/*
하기	main() 함수에 초기화 된 지역변수 5개를 16진수로 콘솔에 출력하시오 
단:	함수를 만들어서 main() 함수에서 각 함수를 호출해서 실행 시키시오
	콘솔에 16진수를 출력할 때는 0x 를 붙여서 출력하시오
함수 이름 toHex_S0(), toHex_S1(), toHex_S2(), toHex_S3(), toHex_S4()

16:45 까지 하기 
*/
public class Exam_For_6 {

	// toHex_S0 함수를 선언한다.
	// 매개변수는 String 문자열을 받는다.
	public void toHex_S0(String str) {
		// toHex_S0 함수를 호출하면 제일 먼저 하기 로그가 콘솔에 출력된다.
		System.out.println("Exam_For_6.toHex_S0() 함수 진입 >>> : ");

		// toHex_S0 함수 블럭에서 매개변수 선언한  String 클래스 str 변수는 
		// toHex_S0 함수 블럭에서 사용이 가능하다.

		// 메인 함수에 new Exam_For_6().toHex_S0(s0); 이렇게 
		// toHex_S0(s0) 함수를 호출하면 
		// 인수로 넘어온 s0 변수의 값이
		// str 변수에 대입이 된다. String str = s0
		// String s0 = "abcdefghijklmnopqrstuvwxyz"; 초기화 된 값이
		// str = "abcdefghijklmnopqrstuvwxyz"; 값이 대입된다.

		// 이상태에서 str 에는 "abcdefghijklmnopqrstuvwxyz" 이렇게 영문자 소문자 26개 대입되어 있다.

		// if  문에서 
		// str 의 값이 null 이 아니고 길이가 0 보다 클 때만 if  문이 수행된다.
		// str 에 "abcdefghijklmnopqrstuvwxyz" 값이 있기 때문에
		// if  문 블럭이 수행될 수 있다. 
		if (str !=null && str.length() > 0){
			// if 문 블럭이 수행이 되면 
			
			// 제일 먼저 char 데이터 타입이 c 지역변수 선언되어서 ' ' 초기화 된다.
			char c = ' ';

			// for  문이 str 문자열 길이 만큼(영문자 소문자 26개 만큼) 반복 수행(루프 가 돈다)된다.
			for (int i=0; i < str.length(); i++ ){

				// for 문 첫번째 라인에서 
				// 변수 c 에 str 에 대입 된 영문자 소문자 26개가 순차적으로 대입이 된다.
				// str.charAt(int index) 함수에 의해서 
				c = str.charAt(i);

				// 콘솔에 c 변수에 대입된 영문자 소문자를  출력한다.
				System.out.print(c + " ");

				// 콘솔에 문자열 0x 와 영문자 소문자를 16진수 변환 값을 더해서 출력한다.
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S1(String str) {
		System.out.println("Exam_For_6.toHex_S1() 함수 진입 >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S2(String str) {
		System.out.println("Exam_For_6.toHex_S2() 함수 진입 >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S3(String str) {
		System.out.println("Exam_For_6.toHex_S3() 함수 진입 >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S4(String str) {
		System.out.println("Exam_For_6.toHex_S4() 함수 진입 >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {
		
		// String 클래스를 지역변수로 값을 초기화 했다.
		// 지역변수 s0, s1, s2, s3, s4 로 선언했다.
		// 각 변수에 문자열을 초기화 한다.
		// 문자열이 영문자 소문자
		// 영문자 소문자를 String 클래스의 toUpperCase() 함수로 대문자로 만든다.
		// 숫자 0 ~ 9
		// 연산자 : 사칙연산자 
		// 특수 문자 8개

		// 영문자 소문자
		String s0 = "abcdefghijklmnopqrstuvwxyz";
		// 영문자 대문자 
		String s1 = s0.toUpperCase();
		// 숫자 
		String s2 = "0123456789";
		// 연산기호
		String s3 = "*+-/";
		// 특수 문자
		String s4 = "!@#%%^&*";


		//  사용자 정의 Exam_For_6() 클래스를 인스턴스 해서 
		//	toHex_S0() 함수를 호출한다.
		//	인수(아규먼트로) s0 지역변수른 넘겨준다. 
		//	s0 지역변수에는 영문자 소문자 초기화 되어있다.
		new Exam_For_6().toHex_S0(s0);

		//  사용자 정의 Exam_For_6() 클래스를 인스턴스 해서 
		//	toHex_S1() 함수를 호출한다.
		//	인수(아규먼트로) s1 지역변수른 넘겨준다. 
		//	s1 지역변수에는 영문자 대문자가 초기화 되어있다.
		new Exam_For_6().toHex_S1(s1);

		//  사용자 정의 Exam_For_6() 클래스를 인스턴스 해서 
		//	toHex_S2() 함수를 호출한다.
		//	인수(아규먼트로) s2 지역변수른 넘겨준다. 
		//	s2 지역변수에는 숫자 0 ~ 9 초기화 되어있다.
		new Exam_For_6().toHex_S2(s2);

		//  사용자 정의 Exam_For_6() 클래스를 인스턴스 해서 
		//	toHex_S3() 함수를 호출한다.
		//	인수(아규먼트로) s3 지역변수른 넘겨준다. 
		//	s3 지역변수에는 사칙연산자가 초기화 되어있다.
		new Exam_For_6().toHex_S3(s3);

		//  사용자 정의 Exam_For_6() 클래스를 인스턴스 해서 
		//	toHex_S4() 함수를 호출한다.
		//	인수(아규먼트로) s4 지역변수른 넘겨준다. 
		//	s4 지역변수에는 특수 문자가 초기화 되어있다.
		new Exam_For_6().toHex_S4(s4);

	}
}
