package a.b.c.ch2;


public class Exam_Constructor_1 {

	String s;
	int i;

	// 매개변수가 없는 기본 생성자
	Exam_Constructor_1() {
		System.out.println("난 매개변수 없는 생성자이다.");
	}

	// 매개변수가 있는 생성자
	Exam_Constructor_1(String s) {
		System.out.println("난 매개변수 있는 생성자이다.");
		System.out.println("Exam_Constructor_1(String s) >>> : " + s);
	}

	public static void main(String args[]) {
		
		System.out.println("Hello Java!!");
		Exam_Constructor_1 ec1 = new Exam_Constructor_1();

		Exam_Constructor_1 ec2 = new Exam_Constructor_1("난 문자열이다.");
	}
}
/*
C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_Constructor_1
Compiled from "Exam_Constructor_1.java"
public class a.b.c.ch2.Exam_Constructor_1 {
  java.lang.String s;
  int i;
======================================================== 
  a.b.c.ch2.Exam_Constructor_1();

  소스 코드에 있는 매개변수 없는 생성자를 호출 한 것이다.
  // 매개변수가 없는 기본 생성자
	Exam_Constructor_1() {
	
	}

======================================================== 
  public static void main(java.lang.String[]);
}

*/
/*
C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_Constructor_1
Compiled from "Exam_Constructor_1.java"
public class a.b.c.ch2.Exam_Constructor_1 {
  java.lang.String s;
  int i;
  a.b.c.ch2.Exam_Constructor_1();
  a.b.c.ch2.Exam_Constructor_1(java.lang.String);
  public static void main(java.lang.String[]);
}

*/