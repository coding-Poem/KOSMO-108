package a.b.c.ch5;

import java.lang.reflect.Method;
/*
 * forName() 메서드를 사용할 때는,
 * 다른 클래스를 불려오려면 반드시
 * 컴파일이 되어 있어야 불러올 수 있다.
 * 
 * */
public class Exam_ForName_1 {

	public void classForName() {
		
		try {
			Class cl = Class.forName("a.b.c.ch5.Exam_Invoke");
			System.out.println("cl >>> : " + cl);			
			Exam_Invoke ei = (Exam_Invoke)cl.newInstance();
			System.out.println("ei >>> : " + ei);
			ei.aM();
			ei.bM();
			ei.cM();
			
			// 클래스에 선언된 메소드 찾기 
			Method m[] = cl.getDeclaredMethods();
			for (int i=0; i < m.length; i++) {
				String findM = m[i].getName();
				System.out.println("m["+i+"].getName() >>> :: " + findM);
			}	
						
			Class d = Class.forName("java.util.Date");
			java.util.Date dd = (java.util.Date)d.newInstance();
			System.out.println("dd >>> : " + dd);
			
			Class aList = Class.forName("java.util.ArrayList");
			java.util.ArrayList aList_1 = (java.util.ArrayList)aList.newInstance();
			
			System.out.println("aList_1 >>> : " + aList_1);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e);
		}
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new Exam_ForName_1().classForName();
	}
}
