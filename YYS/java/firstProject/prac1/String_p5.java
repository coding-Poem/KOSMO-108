package a.b.c.prac1;

public class String_p5 {

	public static void main(String[] args) {
		// STT (Speech-to=Text)
		// TTS (Text-to-Speech)
		String sVal="Hello Java Testing";
		boolean bool=sVal.contains("Hello");
		boolean bool_1=sVal.equals("Hello");
		System.out.println("bool >>> : "+bool);
		// bool >>> : true
		
		String sVall="학교종이 땡땡땡 어서 모이자";
		bool=sVall.contains("학교종");
		/*
		 * boolean
		 * 
		 * contains(CharSequence s)
		 * 
		 * Returns true if and only 
		 * if this string contains the specified 
		 * sequence of char values.
		 * 
		 * eqauls는 문자열을 비교하는데
		 * 
		 * contains는 문자의 특정 시퀀스를 비교함.
		 * 
		 * */
		System.out.println("bool >>> : "+bool);
		// bool >>> : true
		bool=sVall.contains("땡땡땡");
		System.out.println("bool >>> : "+bool);
		// bool >>> : true
		
		// compareTo()
		// 리턴 값 : 0, 음수, 양수의 int
		// 0 : 두 개의 문자열이 동일
		// 양수: compareTo()를 호출하는 객체가 인자보다 사전적으로 순서가 앞설 때
		// 음수: 인자가 객체보다 사전적으로 순서가 앞설 때
		String s1="Hello";
		String s2="Hello";
		String s3="World";
		System.out.println("s1.compareTo(s1) >>> : "+s1.compareTo(s2));
		// Hello와 Hello 비교
		// s1.compareTo(s1) >>> : 0
		System.out.println("s1.compareTo(s3) >>> : "+s1.compareTo(s3));
		// Hello와 World 비교
		// s1.compareTo(s3) >>> : -15
		System.out.println("s3.compareTo(s1) >>> : "+s3.compareTo(s1));
		// World와 Hello 비교
		// s3.compareTo(s1) >>> : 15
		
	}

}
