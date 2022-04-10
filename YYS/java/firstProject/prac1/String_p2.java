package a.b.c.prac1;

import java.util.Scanner;

public class String_p2 {

	public static void main(String[] args) {
		String s="";
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		int i=0;
		int z=0;
		int z1=0;
		System.out.println("파일의 이름을 입력하세요.");
		Scanner sc=new Scanner(System.in);
		s=sc.next();
		
		System.out.println("입력한 파일 >>> "+s);
		
		//====================charAt 실습=========================
		System.out.println("charAt 실습");
		System.out.println("한 글자씩 출력하기 (반환 되는 자료형 : char)");
		System.out.println("사람이 직접 한 글자씩 출력하면서 눈으로 확인하기");
		i=s.length();
		System.out.println("입력한 파일의 길이 >>> "+i);
		
		for (int j=0; j<i; j++){
			System.out.println("s.charAt( "+j+" ) index(key) "+s.charAt(j)+"  value");
		}
		//====================charAt 끝===========================
		
		//===================substring 실습=========================
		System.out.println("substring 실습");
		System.out.println("어느 위치에 뭐가 있을지 하나만 찾아보기");	
		s2=s.substring(1);
		System.out.println("index 1이후에 있는 값은 >>> : "+s2);
		System.out.println("substring으로 찾은 값의 길이 >>> : "+s2.length());
		
		System.out.println("어느 위치에 뭐가 있을지 여러개 찾아보기");	
		s2=s.substring(2,5);
		// 3번째 값부터 6번째 값까지 출력해라
		System.out.println("들어온 값의 3번째 값부터 6번째 까지 값 >>> : "+s2);
		System.out.println("3~6까지 값의 길이 >>> : "+s2.length());
		//===================substring 끝==========================
		
		//===================indexOf 실습===========================
		System.out.println("indexOf 실습");
		System.out.println("찾고자하는 값의 위치 알기");
		z=s.indexOf(".");
		// char String int 다 된다.
		System.out.println("찾고자하는 값의 위치(index) >>>> "+z);
		System.out.println("찾고자하는 값의 위치(index)의 값(value) >>>> "+s.substring(z));
		System.out.println("만약 -1이 나오면 못 찾은 것이다.");
		
		System.out.print("뒤에서 부터 찾는 방법");
		z1=s.lastIndexOf(".");
		System.out.println("찾고자하는 값의 위치(index) >>>> "+z1);
		System.out.println("찾고자하는 값의 위치(index)의 값(value) >>>> "+s.substring(z1));
		//===================indexOf 끝===========================
		
		
		sc.close();

	}

}
