package a.b.c.ch1;


public class Exam_Array {

	// 콘솔 어플리케이션의 시작점이다.
	public static void main(String args[]) {
	
		// 배열을 사용해 보기. 
		// int 형 1차원 배열을 선언한다.
		// int 는 기초자료형인데 이것을 배열로 선언하면 객체로 변한다.
		int iReferenceVariable[] = new int[3];
		System.out.println("참조변수의 주소값 >>> : " + iReferenceVariable);
		/*
		C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_Array
		[I@15db9742
		[	1차원 배열 연산자 표시 
		I	int 형
		@	구분자
		15db9742	숫자
		*/

		// double 형 2차원 배열을 선언한다.
		// double 는 기초자료형인데 이것을 배열로 선언하면 객체로 변한다.
		double dReferenceVariable[][] = new double[3][2];
		System.out.println("참조변수의 주소값 >>> : " + dReferenceVariable);
		/*
		[[D@6d06d69c
		[[	2차원 배열 연산자 표시 
		D	double 형
		@	구분자
		6d06d69c	숫자
		*/
	} // end of main() 
} // end of Exam_Array class