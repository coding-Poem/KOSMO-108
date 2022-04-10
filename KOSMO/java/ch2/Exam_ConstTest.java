package a.b.c.ch2;

// 생성자를 사용하는 이유, 생성자가 하는 일 
// 멤버 필드 초기화 하기 
// 클래스를 인스턴할 때(메모리에 올릴 대, 상속할 때) 멤버변수를 초기화 하기 위해서 

class Exam_Const {

	String s;
	int i;
}

// *.java 화일 소스에 클래스가 두개 이상일 때는 
// main함수가 있는 클래스의 클래스 키워드 앞에 public 키워드를 붙이고
// 파일이름도 main함수가 있는 클래스이름으로 저장한다.
public class Exam_ConstTest {
	
	public static void main(String args[]) {
		
		Exam_Const ec = new Exam_Const();
		System.out.println("ec 참조변수 주소값 >>> :" + ec);
		System.out.println("ec.s >>> :" + ec.s);
		System.out.println("ec.i >>> :" + ec.i);
	}
}

/*
C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_ConstTest.java

C:\00.KOSMO108\10.JExam\ch2>java a.b.c.ch2.Exam_ConstTest
ec 참조변수 주소값 >>> :a.b.c.ch2.Exam_Const@15db9742
ec.s >>> :null
ec.i >>> :0

C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_ConstTest
Compiled from "Exam_ConstTest.java"
public class a.b.c.ch2.Exam_ConstTest {
======================================
  public a.b.c.ch2.Exam_ConstTest();
======================================
  public static void main(java.lang.String[]);
}

C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_Const
Compiled from "Exam_ConstTest.java"
class a.b.c.ch2.Exam_Const {
  java.lang.String s;
  int i;
======================================
  a.b.c.ch2.Exam_Const();
======================================
}
*/