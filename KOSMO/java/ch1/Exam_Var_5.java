package a.b.c.ch1;

/*
1. 문자열		문자의 배열
	자바에서는 String 클래스로 문자열을 다룬다.
	String 클래스는 char의 배열이다. 
2. 배열 
	데이터를 순차적(시퀀스 sequence, index, 첨자)으로 나열해 놓은 것 
*/
public class Exam_Var_5 {


	public void stringTest(){
		
		/*
		1. 문자열을 다루는 클래스 String 선언하고
		2. String 클래스의 변수명을 str 선언하고
		3. = : 대입연산자 선언하고
		4. "abc" 문자열을 str 변수에 대입을 한다. 
		*/
		String str = "abc";
		System.out.println("str >>> : " + str);

		// public char charAt(int index)
		char ch0 = str.charAt(0);
		char ch1 = str.charAt(1);
		char ch2 = str.charAt(2);
		
		// abc 에 없는 데이터인데 컴파일 할 때는 에러가 나지 않는다.
		//char ch3 = str.charAt(3);

		System.out.println("ch0 >>> : " + ch0);
		System.out.println("ch1 >>> : " + ch1);
		System.out.println("ch2 >>> : " + ch2);

		// abc 에 없는 데이터인데 컴파일 할 때는 에러가 나지 않고
		// 실행할 때 에러가 발생된다.
		// System.out.println("ch3 >>> : " + ch3);

		String str2 = "박건원";
		System.out.println("str2 >>> : " + str2);
		char ch20 = str2.charAt(0);
		char ch21 = str2.charAt(1);
		char ch22 = str2.charAt(2);
		System.out.println("ch20 >>> : " + ch20);
		System.out.println("ch21 >>> : " + ch21);
		System.out.println("ch22 >>> : " + ch22);
	}		

	public static void main(String args[]) {

		new Exam_Var_5().stringTest();
	} // end of mai()
} // end of Exam_Var_5 