package a.b.c.prac1;

public class StringTest {
	public static void main(String[] args) {
		String s=new String();
		String s1="null";

		System.out.println("\n s1==null >>> "+s1==null);
		// false
		
		try {
			System.out.println("\n s.equals(s) >>> : "+s1.equals(null));
			// false
			System.out.println("\n s==null >>> "+s==null);
			// false
		}
		catch(Exception e){
			System.out.println("\n e.getMessage() >>> "+e.getMessage());
			// null
		}
		System.out.println("\n s1.equals(s1) >>> "+s1.equals(s1));
		// true 
	}
}
