package a.b.c.ch1;

public class Exam_Operator_3 {

	// 증감 연산자
	public void inc_dec_Oper() {
		/*
			증감 연산자 increment and decrement operators
			++x		x 를 먼저 1 증가 시킨 후 그 값을 사용	
			--x		x 를 먼저 1 감소 시킨 후 그 값을 사용	
			x++		x 값를 먼저 사용한 후 1 증가 
			x--		x 값를 먼저 사용한 후 1 감소 
		*/

		int aX = 10;
		System.out.println(aX);
		
		aX++; // aX = aX + 1 --> 10 = 10 + 1;
		System.out.println(aX);

		++aX; // aX = aX + 1 --> 11 = 11 + 1;
		System.out.println(aX);


		int aXX = 100;
		System.out.println(aXX);

		int aa = aXX++; // int aa = aXX = aXX + 1 --> aa = 100 = 100 + 1	
		System.out.println(aa);		
		
		aa = ++aXX;
		System.out.println(aa);
	}

	// 삼항 연산자
	public void ternary_Oper() {
	
		// 삼항 연산자 ternary operator
		// 조건식 ? 결과1 : 결과2;
		// 조건식의 결과가 TRUE 이면 결과1, FALSE 이면 결과2
		int fatherAge = 45;
		int motherAge = 47;

		// char ch = ' '; char 자료형 빈 문자로 초기화 하기
		char ch = '\u0000'; // char 자료형 유니코드로 초기화 하기 
		
		boolean bool = fatherAge > motherAge;
		System.out.println("bool >>> : " + bool);

		ch = (fatherAge > motherAge) ? 'T' : 'F';
		System.out.println("ch >>> : " + ch);

		if (fatherAge > motherAge){
			System.out.println("true >>> : ");
		}else{
			System.out.println("false >>> : ");
		}

		// 하기 로직은 사용을 지양한다.
		if (fatherAge > motherAge)
			System.out.println("true >>> : ");			
			// System.out.println("true >>> : <<<<<<<<<>>>>>>>>>");
		else
			System.out.println("false >>> : 1");		
			System.out.println("false >>> : <<<<<<<<<>>>>>>>>> 2");

			System.out.println("false >>> : <<<<<<<<<>>>>>>>>> 3");
	}
	public static void main(String args[]) {
	
		Exam_Operator_3 eo = new Exam_Operator_3();
		System.out.println("eo >>> : " + eo);

		// Exam_Operator_3 클래스의 eo 참조변수로 inc_dec_Oper() 함수를 호출한다(invoke).
		eo.inc_dec_Oper();

		// Exam_Operator_3 클래스의 eo 참조변수로 ternary_Oper() 함수를 호출한다(invoke).
		eo.ternary_Oper();


		// Short Circuit 현상 
		// 단락 회로 평가 Short Circuit Evaluation : SCU
		// 논리 곱(&&) 연산과 논리 합(||) 연산을 할 때 두 항을 모두 실행하지 않더라고 
		// 결과 값을 알 수 있는 경우에, 나머지 항은 실행되지 않는다.
		/*
			&& 연산			|| 연산
			T AND T = T		T OR T = T
			T AND F = F		T OR F = T
			F AND T = F		F OR T = T
			F AND F = F		F OR F = F
		*/
		int num1 = 10;
		int i = 2;

		boolean b0 = (num1 = num1 + 10) < 10;
		boolean b1 = (i = i + 2) < 10;
		boolean b2 = b0 && b1;
		System.out.println("b0 >>> : " + b0);
		System.out.println("b1 >>> : " + b1);
		System.out.println("b2 >>> : " + b2);
		
		boolean value = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);
		System.out.println("value >>> : " + value);
		System.out.println("num1 >>> : " + num1);
		System.out.println("i >>> : " + i);


		boolean b3 = (num1 = num1 + 10) > 10;
		boolean b4 = (i = i + 2) < 10;
		boolean b5 = b3 || b4;
		System.out.println("b3 >>> : " + b3);
		System.out.println("b4 >>> : " + b4);
		System.out.println("b5 >>> : " + b5);

		boolean value1 = ((num1 = num1 + 10) > 10) || ((i = i + 2) < 10);
		System.out.println("value1 >>> : " + value1);
		System.out.println("num1 >>> : " + num1);
		System.out.println("i >>> : " + i);
		
	}
}