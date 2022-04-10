package a.b.c.ch1;

// 자바 변수 : 상수, 클래스변수, 전역변수, 멤버변수, 지역변수

// 변수의 유효 범위 
public class Exam_Var_3 {
	// 자바의 정식 용어 : 자바 클래스에 내부에 선언하는 변수는 Filed 필드라고 부른다.
	
	// 멤버변수 : 클래스 블럭 내부 와 함수 블럭 외부에 선언하는 변수이다. 
	// 멤버변수의 종류에는 4가지가 있다.
	/*
		상수
		클래스변수
		전역변수 
		멤버변수
	*/
	// static 붙어서 클래스 변수, 스태틱 변수 
	static int i;
	// 상수
	public static final int CONSTRUCTOR_VARIABLE = 10;
	// 클래스 변수, 스태틱 변수
	static int i_var_staticVariable;
	// 전역 변수
	public int i_var_GlobalVarialbe;
	// 멤버 변수
	int i_var_MemberVarialbe;


	// 메인 함수 콘솔 어플리케이션의 시작점이다. 
	public static void main(String args[]) {
	
		// main() 함수 블럭 안에 있다.
		// 함수 블럭 안에서 선언하는 변수는 지역 변수 local variable 라고 부른다.
		int ii = 1;
		System.out.println("Exam_Var_3.i >>> : " + Exam_Var_3.i);
		// System.out.println("Exam_Var_3.ii >>> : " + Exam_Var_3.ii);
		System.out.println("ii >>> : " + ii);
	} // end of main()
} // end of Exam_Var_2 class