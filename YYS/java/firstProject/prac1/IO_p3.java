package a.b.c.prac1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class IO_p3 {

	public static void main(String[] args) {
		String filePath="C:/00.KOSMO108/10.JExam/eclipse_java_work/firstProject/src/a/b/c/ch6";
		String fileName="Exam_IOTest_3.java";
		
		/*
		System.out.println("파일 경로를 입력하세요.");
		Scanner sc=new Scanner(System.in);
		
		filePath=sc.next();
		
		System.out.println("파일이름을 입력하세요.");
		sc.nextLine();
		
		fileName=sc.next();
		*/
		
		System.out.println("filePath >>> : "+filePath);
		System.out.println("fileName >>> : "+fileName);
		
		try{
			FileInputStream fis=new FileInputStream(filePath+"/"+fileName);
			System.out.println("fis >>> : "+fis);
			
			FileOutputStream fos=new FileOutputStream(filePath+"/"+"Exam_IOTest_3.java");
			System.out.println("fos >>> : "+fos);
			
			int data=0;
			while((data=fis.read()) !=-1){
				System.out.print((char)data);
				fos.write(data);
				System.out.print("====");
			}		
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}
		
		// sc.close();
		
		

	}

}
