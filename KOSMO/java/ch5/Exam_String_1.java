package a.b.c.ch5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_String_1 {
	
	public static String 년월일() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s0 = "kosmo108.java";
		// index = length() - 1;
		// length() = index + 1;
		System.out.println("s0.length() >>> : " + s0.length());
		for (int i=0; i < s0.length(); i++) {
			System.out.println("s0.charAt(" + i + ") >>> : " + s0.charAt(i));
		}
			
		String s01 = s0.substring(2);
		System.out.println("s0.substring(2) >>> : " + s01);
		
		String s02 = s0.substring(2, 13);
		System.out.println("s0.substring(2, 4) >>> : " + s02);
		System.out.println("s0.length() >>> : " + s02.length());
		
		
		int index = s0.indexOf('.');
		System.out.println("index >>> : " + index);
		if (index != -1) {
			System.out.println("s0.indexOf('.') >>> : " + index);
			String s03 = s0.substring(index+1);
			System.out.println("s0.substring(index+1) >>> : " + s03);	
			
			String fileName = s0.substring(0, index);
			
			String newFileName = fileName + "(1)" + "." + s03;
			String newFileName_1 = fileName + "_" +  Exam_String_1.년월일() + "." + s03;
			
			System.out.println("orginal fileName >>> : " + s0);
			System.out.println("new fileName >>> : " + newFileName);
			System.out.println("new fileName_1 >>> : " + newFileName_1);
		}
		
		
		int lastIndex = s0.lastIndexOf('o');
		System.out.println("s0.lastIndexOf('o') >>> : " + lastIndex);
		String s04 = s0.substring(lastIndex+1);
		System.out.println("s0.substring(lastIndex+1) >>> : " + s04);
		
	}
}
