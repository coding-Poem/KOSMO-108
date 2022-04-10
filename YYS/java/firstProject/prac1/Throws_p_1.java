package a.b.c.prac1;

public class Throws_p_1 {
	int aM() throws Exception{
		// throws Exception 생략가능
		int z = bM();
		return z;
	}
	int bM() throws Exception{
		int z=0;
		z=1/0;
		return z;
	}

	public static void main(String[] args) {
		Throws_p_1 tp=new Throws_p_1();
		
		try {
			 int z = tp.aM();
		/*
		 * try~catch문을 실행하지 않고 throws Exception
		 * 을 사용할 경우 다음과 같은 에러가 나타난다.
		 * 
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		 *	Unhandled exception type Exception
		 *
		 *	at a.b.c.prac1.Throws_p_1.main(Throws_p_1.java:16)
		 * */
			 System.out.println("z >>> : "+z);
		}catch(Exception e){
			// () 소괄호 안에 Exception e 안 넣으면
			/*
			 * Syntax error on token "(", 
			 * FormalParameter expected after this token
			 * e cannot be resolved to a variable
			 * */
			System.out.println("에러가 e >>> : "+e);
			// 에러가 e >>> : java.lang.ArithmeticException: / by zero
		}
		System.out.println("\n try~catch문 끝");
	} // main method
} // Throws_p_1 class
