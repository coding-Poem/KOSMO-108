package a.b.c.ch1;

/*
ASCII( /?æski/, 아스키)
미국정보교환표준부호(영어: American Standard Code for Information Interchange), 

자바에서는 ASCII 코드를 기초자료형 char 로 표시한다. 
문자를 char로 표시한다.
*/

// char = Character 같은 의미
// 기초자료형과 wrapper 클래스의 차이일뿐

// char 자료형 공부하기 
// 클래스 자원 = 변수 + 함수 
// 사용자 정의 클래스 Exam_Var_4_1 의 자원 = 변수 + 함수 (charMethod(), main())

// 자바에서 클래스에 있는 자원을 메모리에 올리는 방법
// 1. static 키워드 <-- 지양하세요 
// 2. new 키워드  연산자 
public class Exam_Var_4_1 {

	void charMethod() {
		System.out.println("기초자료형 char 의 Wrapper 클래스 Character");
		System.out.println("char 2byte(양의정수 16bit, 문자를 다루기 때문에 음수를 가질 수 없다.)");

		// BYTES, MAX_VALUE, MIN_VALEU, SIZE 콘솔에 출력하기 
		// public static final int	BYTES	
		// int charBytes = java.lang.Character.BYTES;
		int charBytes = Character.BYTES;
		// public static final char MAX_VALUE
		// char charMaxValue = java.lang.Character.MAX_VALUE;
		char charMaxValue = Character.MAX_VALUE;
		// public static final char MIN_VALUE	l
		// char charMinValue = java.lang.Character.MIN_VALUE;
		char charMinValue = Character.MIN_VALUE;
		// public static final int	SIZE
		// int charSize = java.lang.Character.SIZE;
		int charSize = Character.SIZE;

		System.out.println("charBytes >>> : " + charBytes);
		System.out.println("charMaxValue >>> : " + charMaxValue);
		System.out.println("charMinValue >>> : " + charMinValue);
		System.out.println("charSize >>> : " + charSize);

		int charMaxValue_1 = Character.MAX_VALUE;
		int charMinValue_1 = Character.MIN_VALUE;
		System.out.println("charMaxValue_1 >>> : " + charMaxValue_1);
		System.out.println("charMinValue_1 >>> : " + charMinValue_1);


		char charMin = '\u0000'; // 유니코드
		char charMax = '\uFFFF'; // 유니코드 
		System.out.println("charMin >>> : " + charMin);
		System.out.println("charMax >>> : " + charMax);

		char charinitialization  = ' '; // char 데이터 타입은 빈 문자열, 싱글 쿼테이션으로 초기화 한다.
		System.out.println("charinitialization >>> : " + charinitialization);

	}

	public static void main(String args[]) {

		// 메모리에 올리는 방법 : 클래스 전체를 올린다. : 자바에서는 클래스가 최소 단위이다. 
		// 클래스를 메모리에 올리는 방법 : 인스턴스 : instance
		// 클래스이름 참조변수 = new 클래스이름()
		Exam_Var_4_1 ev4 = new Exam_Var_4_1();
		System.out.println("ev4 참조변수 : 주소값 >>> : " + ev4);
		// System.out.println("ev4.charMethod() >>> : " + ev4.charMethod());
		ev4.charMethod();

		// new Exam_Var_4_1().charMethod();

	} // end of mai()
} // end of Exam_Var_4_1 