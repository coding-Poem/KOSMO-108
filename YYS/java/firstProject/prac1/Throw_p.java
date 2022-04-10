package a.b.c.prac1;

public class Throw_p {

	public static void main(String[] args) {
		try {
			throw new Exception("\n 1. throw new Exception에서 만든 메시지");
			/*
			 * Exception e = new Exception("throw new Exception에서 만든 메시지");
			 * throw e;
			 * 
			 * 와 같은 의미임.
			 * */
		}catch(Exception er){
			// 1st 방법
			System.out.println("\n 2. er >>> : "+er);
			// er >>> : java.lang.Exception: throw new Exception에서 만든 메시지
			// 1. throw new Exception에서 만든 메시지
			
			// 2nd 방법
			System.out.println("\n 3. er.getMessage() >>> : "+er.getMessage());
			//  3. er.getMessage() >>> : 
			//  1. throw new Exception에서 만든 메시지
			
			// 3rd 방법
			// log 전부 확인하는 방법인데, 실제 현업에서 사용시
			// 너무 많은 내용이 출력되므로, 사용을 지양한다.
			// er.printStackTrace();	
			/*
			 * java.lang.Exception: 
 			 *	1. throw new Exception에서 만든 메시지
			 *	at a.b.c.prac1.Throw_p.main(Throw_p.java:7)
			 * 
			 * */
		}
		System.out.println("\n 4. try-catch 문 끝!");
	}

}
