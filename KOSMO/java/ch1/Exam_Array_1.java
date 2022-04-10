package a.b.c.ch1;


public class Exam_Array_1 {

	// 콘솔 어플리케이션의 시작점이다.
	public static void main(String args[]) {
	
		// 배열을 사용해 보기. 
		// int 형 1차원 배열을 선언한다.
		// int 는 기초자료형인데 이것을 배열로 선언하면 객체로 변한다.
		/*
		1.	int 데이터 타입 자료형을 선언한다.
		2.	iReferenceVariable 참조변수를 선언한다.
		3.	[] 대괄호 braket 배열연산자 한개를 선언한다 --> 1차원 배열을 선언한다.
		4.	= 대입 연산자를 선언한다.
		5.	new 인스턴스 연산자를 선언한다. 
		6.	int 데이터 타입을 선언하고 [] 연산자에 숫자를 부여한다. 여기서는 3을 넣는다.
		7.	자버 버철머신이 int[3] 구문을 보고 
			int 형 데이터 상자를 3개를 만들고 거기에 default 값으로 초기화 한다.
			각 상자에 int 형의 디폴값이 0 이 초기화 된다.
		*/
		int iReferenceVariable[] = new int[3];
		System.out.println("참조변수의 주소값 >>> : " + iReferenceVariable);
		
		/*
		각 int 형 상자에 초기화 된 값을 
		0, 1, 2 index 값으로 호출해서 사용할 수 있다. 
		*/
		// iReferenceVariable[0];
		int iVal0 =  iReferenceVariable[0];
		int iVal1 =  iReferenceVariable[1];
		int iVal2 =  iReferenceVariable[2];
		System.out.println("iVal0 >>> : " + iVal0);
		System.out.println("iVal1 >>> : " + iVal1);
		System.out.println("iVal2 >>> : " + iVal2);


		// double 형 2차원 배열을 선언한다.
		// double 는 기초자료형인데 이것을 배열로 선언하면 객체로 변한다.
		// new double[3][2] 요기서 3 은 행의 값, 2 열의 값 <-- 219쪽
		double dReferenceVariable[][] = new double[3][2];
		System.out.println("참조변수의 주소값 >>> : " + dReferenceVariable);

		double dVal00 = dReferenceVariable[0][0];
		double dVal01 = dReferenceVariable[0][1];
		System.out.println("dVal00 >>> : " + dVal00);
		System.out.println("dVal01 >>> : " + dVal01);
		double dVal10 = dReferenceVariable[1][0];
		double dVal11 = dReferenceVariable[1][1];
		System.out.println("dVal10 >>> : " + dVal10);
		System.out.println("dVal11 >>> : " + dVal11);
		double dVal20 = dReferenceVariable[2][0];
		double dVal21 = dReferenceVariable[2][1];
		System.out.println("dVal20 >>> : " + dVal20);
		System.out.println("dVal21 >>> : " + dVal21);

	} // end of main() 
} // end of Exam_Array_1 class