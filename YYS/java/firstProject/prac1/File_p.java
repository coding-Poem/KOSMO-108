package a.b.c.prac1;

import java.io.File;

public class File_p {

	public static void main(String[] args) {
		/*
		 *  java.io.File 클래스는 자바에서 파일 또는 폴더 객체를 다루는 클래스이다.
		 *  new File() : File 클래스의 인스턴스 생성(파일 또는 폴더를 생성하시오.)
		 *  
		 * */
		File f=new File("윤요섭");
		System.out.println("f >>> : "+f);
		// 윤요섭
		System.out.println("f.getName() >>> : "+f.getName());
		// 윤요섭
		
		try {
			boolean b=f.createNewFile();
			System.out.println("b >>> : "+b);
			// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\firstProject
			// 에 파일이 생성되있음.
			// 여기가 이클립스 최상위폴더임.
			
		}catch(Exception e){
			System.out.println("에러가 >>>> : "+e.getMessage());
		}
	}

}
