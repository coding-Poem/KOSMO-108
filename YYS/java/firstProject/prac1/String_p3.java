package a.b.c.prac1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class String_p3 {
	public static String yearMonthDate(){
		System.out.println("yearMonthDate 함수 시작>>>");
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	public static void main(String[] args) {
			Scanner sc=null;
		try{
			sc=new Scanner(System.in);
			String s="";
			String s1="";
			String s2="";
			String s3="";
			String s4=".pdf";
			String s5="";
			int a=0;
			int b=0;

			System.out.println("파일 이름을 입력하세요.");
			s=sc.next();
		
			System.out.println("입력한 파일의 이름 >>> : "+s);
			
			a=s.length();
			System.out.println("입력한 파일의 길이 >>> : "+a);
			System.out.println("입력한 파일의 이름 한 글자씩 보기");
			for (int i=0; i<s.length(); i++){
				System.out.println("s.charAt("+i+") ==> "+s.charAt(i));
			}
			
		
			b=s.indexOf('.');
			System.out.println(" 파일 확장자 dot이  있는 index 위치 >>> : "+b);
		
			s1=s.substring(0,b);
			System.out.println("dot 뒤에 있는 글자 >>> : "+s1);
		
			s2=String_p3.yearMonthDate();
			System.out.println("오늘 년 월 일 >>> : "+s2);
		
			s3=s2.concat(s1);
			System.out.println("오늘일자 + 파일이름 >>> "+s3);
			
			s5=s3.concat(s4);
			System.out.println("오늘일자+파일이름+확장자 >>> "+s5);
			
			sc.close();
			}catch(Exception e){
				System.out.println("에러 내용 >>> : "+e.getMessage());
			}finally{
				System.out.println("오늘 날짜+파일이름+pdf 생성기 종료합니다.");
				if(sc!=null){
					sc.close();
				}				
			}
	}
}
