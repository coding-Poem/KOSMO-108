package a.b.c.ch5;

public class Exam_TryCatch_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			String args0 = args[0];
			String args1 = args[1];
			
			int x = Integer.parseInt(args0);
			int y = Integer.parseInt(args1);
			
			int z = x / y;
			
			System.out.println("x / y = " + z);
		/*	
		}catch(NumberFormatException n) {
			System.out.println("NumberFormatException :: 에러 로그 찍기 >>> : " + n);
			
		}catch(ArithmeticException a) {
			System.out.println("ArithmeticException :: 에러 로그 찍기 >>> : " + a);
		*/	
		}catch(Exception e) {
			System.out.println("Exception :: 에러 로그 찍기 >>> : " + e);
			
		}finally {
			System.out.println("finally 블럭 >>> : ");
			System.out.println("에러 또는 정상 모두 수행한다. >>> : ");			
		}
		
		System.out.println("연산 후 수행되는 루틴이다. >>> : ");
	}
}
