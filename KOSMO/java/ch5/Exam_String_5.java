package a.b.c.ch5;

public class Exam_String_5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		STT (Speech-to-Text)
//		TTS (Text-to-Speech)
		String sVal = "Hello Java Testing !! ";				
		boolean bool = sVal.contains("Hello");
		boolean bool_1 = sVal.equals("Hello");		
		System.out.println("bool >>> : " + bool);
		
		String sVal1 = "학교종이 땡땡땡 어서 모이자";
		bool = sVal1.contains("학교종");
		System.out.println("bool >>> : " + bool);
		bool = sVal1.contains("땡땡땡");
		System.out.println("bool >>> : " + bool);
		
		
		// compareTo()
		// 리턴 값 : 0, 음수, 양수의 int 
		// 0 : 두개의 문자열이 동일 
		// 양수 : compareTo()를 호출하는 객체가 인자보다 사전적으로 순서가 앞설 때 
		// 음수 : 인자가 객체보다 사전적으로 순서가 앞설 때 
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "World";
		System.out.println("s1.compareTo(s1) >>>  : " + s1.compareTo(s2));
		System.out.println("s1.compareTo(s3) >>>  : " + s1.compareTo(s3));
		System.out.println("s3.compareTo(s1) >>>  : " + s3.compareTo(s1));
	}
}
