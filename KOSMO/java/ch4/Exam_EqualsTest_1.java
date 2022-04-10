package a.b.c.ch4;

public class Exam_EqualsTest_1 {

	public static void main(String[] args) {
		
		String s = new String("abc");
		String s1 = new String("abc");		
		System.out.println("s >>> : " + s);
		System.out.println("s1 >>> : " + s1);
		System.out.println("System.identityHashCode(s) s >>> : " + System.identityHashCode(s));
		System.out.println("System.identityHashCode(s1) s1 >>> : " + System.identityHashCode(s1));
		
		System.out.println("s == s1 ::: " + (s == s1));
		System.out.println("s.equals(s1) ::: " + s.equals(s1));
		
		Integer i = new Integer(100);
		Integer i1 = new Integer(100);			
		System.out.println("i >>> : " + i);
		System.out.println("i1 >>> : " + i1);
		System.out.println("System.identityHashCode(s) i >>> : " + System.identityHashCode(i));
		System.out.println("System.identityHashCode(s1) i1 >>> : " + System.identityHashCode(i1));		
				
		System.out.println("(i == i1) ::: " + (i == i1));
		System.out.println("i.equals(i1) ::: " + i.equals(i1));		
	}
}
