package a.b.c.ch2;

import java.util.Date;
import java.util.Calendar;

// this 키워드 : 자기 자신 클래스를 가르킨다. : Object 를 사용하는 모든 언어, 스크립트가 동일하게 적용된다.
public class Exam_This {
	
	String s;
	int i;

	// 생성자 
	Exam_This() {
		System.out.println("난 Exam_This 클래스의 매개변수 없는 기본 생성자이다.");
		System.out.println("this >>> : " + this.getClass().getName());
		System.out.println("this.s >>> : " + this.s);
		System.out.println("this.i >>> : " + this.i);
	}

	Exam_This(String ss) {
		System.out.println("난 Exam_This 클래스의 매개변수 String ss  가 있는 생성자이다.");
		System.out.println("ss >>> : " + ss);
		System.out.println("this >>> : " + this.getClass().getName());
	}

	public static void main(String args[]) {
		
		
		Exam_This et = new Exam_This();
		System.out.println("et 참조변수 주소값 >>> : " + et);	

		Exam_This et_1 = new Exam_This("신익현 탱큐");
		System.out.println("et_1 참조변수 주소값 >>> : " + et_1);	

		// public final Class<?> getClass()
		System.out.println("et.getClass() >>> : " + et.getClass());
		/*
		C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.Exam_This
		Compiled from "Exam_This.java"
		public class a.b.c.ch2.Exam_This {
		  public a.b.c.ch2.Exam_This();
		  public static void main(java.lang.String[]);
		}
		*/
		// 참조변수.getCalss().getName()  를 사용하면 참조변수의 클래스이름(풀네임, 네임스페이스)을 리턴한다.
		System.out.println("et.getClass().getName() >>> : " + et.getClass().getName());		
		
		
		String str = "abc";
		System.out.println("str >>> : " + str);
		System.out.println("str.getClass().getName() >>> : " + str.getClass().getName());		

	
		int iV[] = new int[]{1, 2};
		System.out.println("iV 참조변수 주소값 >>> : " + iV);
		System.out.println("iV.getClass().getName() >>> : " + iV.getClass().getName());

		int iV2[][] = new int[2][3];
		System.out.println("iV2 참조변수 주소값 >>> : " + iV2);
		System.out.println("iV2.getClass().getName() >>> : " + iV2.getClass().getName());	

		
		Date d = new Date();
		System.out.println("d 참조변수 주소값 >>> : " + d);
		System.out.println("d.getClass().getName() >>> : " + d.getClass().getName());			
	}
}
