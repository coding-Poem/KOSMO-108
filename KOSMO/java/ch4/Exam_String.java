package a.b.c.ch4;

// 문자열 불변 immutalble 
// 스트링 클래스에 초기화 된 값을 절대 변경되지 않는다. 

public class Exam_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s0 = new String("java");
		String s1 = new String("android");
		
		System.out.println("s0 >>> : " + s0);
		System.out.println("System.identityHashCode(s0) s0 >>> : " + System.identityHashCode(s0));
		System.out.println("s1 >>> : " + s1);
		System.out.println("System.identityHashCode(s1) s1 >>> : " + System.identityHashCode(s1));
		
		// public String concat(String str)
		// javaandroid
		String s2 = s0.concat(s1);
		System.out.println("s2 >>> : " + s2); 
		System.out.println("System.identityHashCode(s2) s2 >>> : " + System.identityHashCode(s2));
		System.out.println(); 
		/*
		 	s0 >>> : java
			System.identityHashCode(s0) s0 >>> : 366712642
			
			s1 >>> : android
			System.identityHashCode(s1) s1 >>> : 1829164700
			
			s2 >>> : javaandroid
			System.identityHashCode(s2) s2 >>> : 2018699554 
		*/
		
		// int i = 12345;
		// String ss = i + "";
		
		// String -> StringBuffer -> StringBuilder		
		String sb0 = new String("abc");
		System.out.println("sb0 >>> : " + sb0);
		System.out.println("System.identityHashCode(sb0) sb0 >>> : " + System.identityHashCode(sb0));
		
		StringBuffer sb1 = new StringBuffer();
		System.out.println("StringBuffer sb1 >>> : " + System.identityHashCode(sb1));
		sb1.append(" and");
		sb1.append(" android");
		sb1.append(" programming is fun!!!!!");
		System.out.println("sb1 >>> : " + sb1);
		System.out.println("StringBuffer sb1 >>> : " + System.identityHashCode(sb1));

		// sb0 = sb1;
		// String 클래스와 StringBuffer 클래스를 다른 클래스이다.
		// 사용하려면 형변환을 해야 한다.
		sb0 = sb1.toString();
		System.out.println("sb0 >>> : "+sb0);
		
		System.out.println("sb0 >>> : " + sb0);
		System.out.println("System.identityHashCode(sb0) sb0 >>> : " + System.identityHashCode(sb0));	
	}
}
