package a.b.c.prac1;

public class String_p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s0=new String("VELOG");
		String s1=new String("_POSTING");
		
		System.out.println("s0 >>> : "+s0);
		System.out.println("s1 >>> : "+s1);
		System.out.println("System.identityHashCode(s0) >>> : "+System.identityHashCode(s0));
		System.out.println("System.identityHashCode(s1) >>> : "+System.identityHashCode(s1));
		
		//public String concat(String str)
		// VELOG_POSTING
		String s2=s0.concat(s1);
		System.out.println("s2 >>> : "+s2);
		System.out.println("System.identityHashCode(s2) >>> : "+System.identityHashCode(s2));		
	
	
	/*
	      출력 결과	 
	   s0 >>> : VELOG
	   s1 >>> : _POSTING
       System.identityHashCode(s0) >>> : 366712642
       System.identityHashCode(s1) >>> : 1829164700
	   s2 >>> : VELOG_POSTING
	   System.identityHashCode(s2) >>> : 2018699554 
	 */
	
	String sb0=new String("VELOG_POSTING");
	System.out.println("sb0 >>> : "+sb0);
	System.out.println("System.identityHaschCode(sb0) sb0 >>> : "+System.identityHashCode(sb0));
	} 
}
