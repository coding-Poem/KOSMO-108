package a.b.c.ch1;

public class Exam_Operator_2 {

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

		++aX;
		System.out.println(aX);


		int aXX = 100;
		System.out.println(aXX);

		int aa = aXX++; // int aa = aXX = aXX + 1		
		System.out.println(aa);		
		
		aa = ++aXX;
		System.out.println(aa);
	}

	public static void main(String args[]) {
	
		Exam_Operator eo = new Exam_Operator_2();
		System.out.println("eo >>> : " + eo);

		// Exam_Operator 클래스의 eo 참조변수로 inc_dec_Oper() 함수를 호출한다(invoke).
		eo.inc_dec_Oper();

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
}