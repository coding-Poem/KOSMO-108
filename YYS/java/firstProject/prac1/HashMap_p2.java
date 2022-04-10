package a.b.c.prac1;

import java.util.ArrayList;
import java.util.HashMap;


public class HashMap_p2 {

	public static void main(String[] args) {
		// HashMap 연습 2
		ArrayList aList=new ArrayList();
		System.out.println("aList >>> : "+aList);
		System.out.println("aList >>> : "+System.identityHashCode(aList));
		
		HashMap hp=new HashMap();
		System.out.println("HashMap >>> : "+hp);
		System.out.println("HasMap >>> : "+System.identityHashCode(hp));
		
		
		hp.put("오늘은","불타는 금요일");
		
		// Object 자료로 출력된다.
		// Object로 받아서 String 클래스 형변환을 통해 출력
		Object obj0=hp.get("오늘은");
		System.out.println("obj0 >>> : "+obj0);
		String s0=(String)obj0;
		System.out.println("s0 >>> : "+s0);
		
		System.out.println();
		
		// Object.toString() 사용
		String s2=hp.get("오늘은").toString();
		System.out.println("s2 >>> : "+s2);
		
		// String.valueOf(Object)
		String s3=String.valueOf(hp.get("오늘은"));
		System.out.println("s3 >>> : "+s3);
	}

}
