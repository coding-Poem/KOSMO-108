package a.b.c.prac1;

public class Exam_EqualsTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=new String("abc");
		String s1=new String("abc");
		
		System.out.println("\n 1. s >>> : "+s);
		System.out.println("\n 2. s1 >>> : "+s1);
		System.out.println("\n 3. System.identityHashCode(s) >>> : "+System.identityHashCode(s));
		System.out.println("\n 4. System.identityHashCode(s1) >>> : "+System.identityHashCode(s1));
		System.out.println("\n 5. s==s1 :::"+s==s1);
		// false : 이유 : 두 객체의 참조변수 주소값이 다르기 때문
		System.out.println("\n 6. s.equals(s1) >>> : "+s.equals(s1));
		// true : 이유 : 내용(문자열)이 같기 때문
		// String 끼리의 비교 => String.equals(String)
		
		Integer i =new Integer(100);
		Integer ii=new Integer(100);
		
		
		System.out.println("\n 7. i >>> : "+i);
		System.out.println("\n 8. ii >>> : "+ii);
		System.out.println("\n 9. i.toString() >>> : "+i.toString());
		System.out.println("\n 10. ii.toString() >>> : "+ii.toString());
		System.out.println("\n 11. System.identityHashCode(i)  >>> : "+System.identityHashCode(i));
		System.out.println("\n 12. System.identityHashCode(ii) >>> : "+System.identityHashCode(ii));
		
		System.out.println("\n 13. (i==ii)>>> : "+(i==ii));
		// false : 이유 : 두 객체의 참조변수 주소값이 다르기 때문
		System.out.println("\n 14. i.eqauls(ii)>>> : "+i.equals(ii));
		// true : 이유 : 내용이 같기 때문 100, 100
		// boolean equals(Object obj)
		// public boolean equals(Object obj)
		// the same int value as this object.
		// api 설명에 보면 int value 값으로 boolean 값이 나온다고 나와있다.
		// 즉, i.toString()과 ii.toString()이 같기 때문에, true가 나오는 것이다.
		// API에 Object만보고 현혹되지 말고, 끝까지 읽어보도록 하자.!
	}

}
