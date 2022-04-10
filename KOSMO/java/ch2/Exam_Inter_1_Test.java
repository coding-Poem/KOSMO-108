package a.b.c.ch2;

import a.b.c.ch2.aaaa.Exam_Inter_1;
import a.b.c.ch2.aaaa.Exam_Inter_3;
import a.b.c.ch2.aaaa.Exam_Inter_1_Class;

public class Exam_Inter_1_Test {

	public static void main(String args[]) {

		// 2. 부모클래스 참조변수 = new 자식클래스
		Exam_Inter_1 ei1 = new Exam_Inter_1_Class();
		System.out.println("ei1 참조변수 주소값 >>> : " + ei1);
		// System.out.println("ei1.aM() >>> : " + ei1.aM());
		/*
		C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Inter_1_Test.java Exam_Inter_1_Class.java Exam_Inter_1.java
		Exam_Inter_1_Test.java:13: error: 'void' type not allowed here
                System.out.println("ei1.aM() >>> : " + ei1.aM());
                                   ^
		1 error
		*/

		Exam_Inter_3 ei3=new Exam_Inter_1_Class();

		ei1.aM();
		ei1.bM();
		ei1.cM();
		ei1.dM();
		ei3.eM();
	}
}
