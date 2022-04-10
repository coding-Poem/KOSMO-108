package a.b.c.ch1;

public class Exam_Operator {

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

	// 논리 연산 
	public void shortCircuit_Oper() {

		// 논리 연산 Logical Operators
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

	// 관계 연산
	public void relational_Oper() {

		// 관계 연산 Relational Operators
		boolean bool0 = 1 > 2;
		boolean bool1 = 'a' > 'b'; // 97 > 98 , 자바는 숫자를 int 만 안다. 연산을 하면 int형으로 형변환 한다.
		boolean bool2 = 'A' > 'b';
		// boolean bool3 = "A" > "B";
		/*
		Exam_Operator.java:130: error: bad operand types for binary operator '>'
                boolean bool3 = "A" > "B";
                                    ^
		first type:  String
		second type: String
		1 error
		*/
		// boolean bool4 = "A" > 'b';
		// boolean bool5 = "가" > "나";
		boolean bool6 = '가' > '나';
		System.out.println("bool0 >>> : " + bool0);
		System.out.println("bool1 >>> : " + bool1);
		System.out.println("bool2 >>> : " + bool2);
		// System.out.println("bool3 >>> : " + bool3);
		// System.out.println("bool4 >>> : " + bool4);
		// System.out.println("bool5 >>> : " + bool5);
		System.out.println("bool6 >>> : " + bool6);


		// == 상등 연산자, 등가 연산자 는 숫자 연산 만 한다.
		int iX = 10;
		int iY = 10;
		boolean bVal0 = iX == iY;
		System.out.println("bVal0 >>> : " + bVal0);
	
		// equals() 함수는 문자열 연산 만 한다.
		// java.lang.String
		// public boolean equals(Object anObject)
		// public boolean equalsIgnoreCase(String anotherString)
		String s0 = "abc";
		String s1 = "abc";
		String s2 = "Abc";
		String s3 = "Abc  ";
		boolean bVal4 = s0.equals(s1);
		System.out.println("bVal4 >>> : " + bVal4);
		boolean bVal5 = s0.equals(s2);
		System.out.println("bVal5 >>> : " + bVal5);
		boolean bVal6 = s0.equalsIgnoreCase(s2);
		System.out.println("bVal6 >>> : " + bVal6);
		boolean bVal7 = s0.equalsIgnoreCase(s3);
		System.out.println("bVal7 >>> : " + bVal7);		
	}

	public static void main(String args[]) {
	
		Exam_Operator eo = new Exam_Operator();
		System.out.println("eo >>> : " + eo);

		// Exam_Operator 클래스의 eo 참조변수로 inc_dec_Oper() 함수를 호출한다(invoke).
		eo.inc_dec_Oper();

		// Exam_Operator 클래스의 eo 참조변수로 ternary_Oper() 함수를 호출한다(invoke).
		eo.ternary_Oper();

		// Exam_Operator 클래스의 eo 참조변수로 shortCircuit_Oper() 함수를 호출한다(invoke).
		eo.shortCircuit_Oper();

		// Exam_Operator 클래스의 eo 참조변수로 relational_Oper() 함수를 호출한다(invoke).
		eo.relational_Oper();
	}
}