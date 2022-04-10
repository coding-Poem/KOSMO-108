package a.b.c.ch1;

// char 자료형 공부하기 
public class Exam_Var_4 {

	void charMethod() {
		System.out.println("Exam_Var_4.charMethod() 시작 >>> : \n");

		char c1 = 'A';
		System.out.println("c1 >>> : " + c1);
		System.out.println("(int)c1 >>> : " + (int)c1);
		int c2 = (int)c1;
		System.out.println("c2 >>> : " + c2);

		// static String	toBinaryString(int i)
		// Returns a string representation of the integer argument as an unsigned integer in base 2.
		// String s_1 = java.lang.Integer.toBinaryString(int i); 
		String s_1 = Integer.toBinaryString(c2); 
		System.out.println("s_1 >>> : " + s_1);

		// static String	toHexString(int i)
		// Returns a string representation of the integer argument as an unsigned integer in base 16.
		String s_2 = Integer.toHexString(c2);
		System.out.println("s_2 >>> : " + s_2);

		// static String	toOctalString(int i)
		// Returns a string representation of the integer argument as an unsigned integer in base 8.
		String s_3 = Integer.toOctalString(c2);
		System.out.println("s_3 >>> : " + s_3);

		System.out.println("Exam_Var_4.charMethod() 끝 >>> : ");	
	}

	public static void main(String args[]) {
		System.out.println("Exam_Var_4.main() 시작 >>> : \n");
		System.out.println("main() 함수는 콘솔 어플리케이션을 시작 시키고  >>> : \n");
		System.out.println("함수를 호출하는 역활만 한다.  >>> : \n");
		
		Exam_Var_4 ev4 = new Exam_Var_4();
		System.out.println("ev4 참조변수 주소값  >>> : " + ev4);
		ev4.charMethod();

		System.out.println("Exam_Var_4.main() 끝 >>> : ");	
	} // end of mai()
} // end of Exam_Var_4 