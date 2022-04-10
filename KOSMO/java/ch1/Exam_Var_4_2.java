package a.b.c.ch1;


public class Var_4_2 {

	void charMethod() {
		System.out.println("Exam_Var_4_2.charMethod() 함수 시작");

		// char 자료형 초기기 하기 
		// char c = '';
		// char c = "";
		char c = ' ';
		System.out.println("c >>> : " + c);

		// -----------> 묵시적 형변환이 자동으로 발생된다.
		// byte char short int long float double
		// <---------- 명시적으로 형변환을 해야 한다.

		// 기초자료형에서 숫자로 사용되는 데이터 타입은 서로 데이터를 주고 받을 수 있다.
		// 기초자료형은 부호비트를 가지고 있다. 
		// 자바에서는 자료형은 변환하는 형변환을 허용한다. 연산자는 () 소괄호 이다.
		/*
		묵시적 형변환	implicit casting
			: 작은 자료형에서 큰 자료형으로 대입할 때 자동으로 형변환이 일어난다.
		명시적 형변환	explicit casting
			: 큰 자료형에서 작은 작은 자료형으로 대입할 때는 큰 자료형을 작은 자료형으로 변환해서 대입을 해야한다.
		*/

		char ch1 = 'A';
		System.out.println("ch1 >>> : " + ch1);

		// ch1을 명시적으로 형변환을 한 것이다.
		int intCh1 = (int)ch1;
		System.out.println("intCh1 >>> : " + intCh1);
		 
		//int intCh1=ch1;
		// 이렇게 선언하면 2byte인 char가 int형으로 형변환하는 것이기 때문에
		// 묵시적 형변환이 맞고, 묵시적 형변환이 자동으로 발생해야 함.

		//int intCh1=(int)ch1;
		// 그러나 자동으로 되는 걸, 굳이 (int)라는 캐스팅 연산자를 붙여주었기 때문에
		// 묵시적이 아닌 명시적인 형봔환이 된거라고 볼 수 있다.

		// ch1이 묵시적으로 자동 형변환이 일어 난 것이다.
		int intCh2 = ch1;
		System.out.println("intCh2 >>> : " + intCh2);
		
		// intCh1을 명시적으로 형변환을 한 것이다.
		char ch1_1 = (char)intCh1;
		System.out.println("ch1_1 >>> : " + ch1_1);

		// 쉽게 이야기 하면 (자료형)을 쓰면 명시적 형변환이라고 한다.
		// 큰 자료형에서 작은 자료형으로 넘어갈 때, 명시적 형변환을 해야 하기때문에
		// 캐스팅연산자를 붙여줘야 한다.

		// 작은 자료형에서 큰 자료형으로 넘어갈 때는 묵시적 형변환이 자동으로 된다.
		// 그러나 이 때, 굳이 (자료형)을 붙여주면, 소스코드에서 사람이 보기 때문에
		// 명시적 형변환이 되는 것이다.
	}

	public static void main(String args[]) {

		new Exam_Var_4_2().charMethod();
	} // end of mai()
} // end of Exam_Var_4_2 