package a.b.c.ch2;


// 생성자 : Constructor 
// 생성자의 모습 
/*
	클래스이름 () {
		
	}
*/
// 생성자는 클래스를 메모리에 올릴때 자바 버철머신이 사용하는 함수로 
// 자바 소스에 생성자의 코드 블럭이 있으면 그 생성자를 사용하고
// 자바 소스에 생성자의 코들 블럭이 없으면 jvm 생성자를 만들어서 사용한다.
public class Exam_Constructor {

	String s;
	int i;

	public static void main(String args[]) {
		
		System.out.println("Hello Java!!");
	}
}
/*
C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_Constructor
Compiled from "Exam_Constructor.java"
public class a.b.c.ch2.Exam_Constructor {
=============================================================
  public a.b.c.ch2.Exam_Constructor(); : 기본 생성자, default Contructor 
  이것을 jvm 이 생성해서 멤버필드를 초기화 한다.
=============================================================  
  public static void main(java.lang.String[]);
}
*/