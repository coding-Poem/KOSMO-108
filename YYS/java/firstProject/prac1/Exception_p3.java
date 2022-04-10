package a.b.c.prac1;

public class Exception_p3 {

	public static void main(String[] args) {
		/*
		 * Exception 클래스는 모든 Except 클래스의 
		 * 최상위 클래스이다.
		 * 
		 * 각각 어떤 오류가 나는지 확인해보도록 하자.
		 * 
		 * 실험 케이스 1 : {args0 : 2}, {args1 : 1}
		 * x/y = 2로 정상 출력
		 * 
		 * 실험 케이스 2 : {args0 : 1}, {args1 : 2}
		 * x/y = 0 으로 출력
		 * 
		 * 실험 케이스 3 : {args0 : 2.5}, {args1: 1.5}
		 * Exception :: 에러 로그 찍기 >>> : java.lang.NumberFormatException: For input string: "2.5"
		 * 2.5는 parseInt 불가 >>>  NumberFormatException가 출력 된다.
		 * 
		 * 실험 케이스 4 : {args0 : 2}, {args1 : zero}
		 * 마찬가지로, zero는 parseInt 불가  >>> java.lang.NumberFormatException: For input string: "zero"
		 *  
		 * 실험 케이스 5 : {args0 : 2}, {args1 : 영}
		 * 마찬가지로, 영은 parseInt 불가 >>> java.lang.NumberFormatException: For input string: "영"
		 * 
		 * 실험 케이스 6 : 아무값도 넣지 않기
		 * 아무 값도 들어오지 않음 >>> java.lang.ArrayIndexOutOfBoundsException: 0
		 * 
		 * 실험 케이스 7 : {args0 : 2}, {args1 : 0}
		 * 분모에 0이 들어올 수 없음 >>> java.lang.ArithmeticException: / by zero
		 * runtime error
		 * 
		 * 실험 케이스 8 : {args0 : 0}, {args1 : 2}
		 * x/y=0 정상적으로 잘 출력 됨.
		 * 
		 * 실험 케이스 9 : {args0 : -5}, {args1: -7}
		 * x/y=0 으로 출력됨.
		 * 
		 * 실험 케이스 10 : {args0 : -10}, {args1 : 5}
		 * x/y=-2으로 잘 출력됨.
		 * 
		 * 10가지 실험 케이스 전부
		 * finally finish와 try~catch~finally finish가 잘 출력 되는 것을 확인 할 수 있다.
		 */
		try {
			String args0=args[0];
			String args1=args[1];
			
			int x=Integer.parseInt(args0);
			int y=Integer.parseInt(args1);
			
			int z = x/y;
			System.out.println("x/y = "+z);
		}catch(Exception e){
			// Exception은 Except에 있어서 최상위 클래스
			// Throwable은 Error와 Exception 클래스의 부모
			System.out.println("\n Exception :: 에러 로그 찍기 >>> : "+e);
		}finally{
			System.out.println("\n finally finish");
		}
		System.out.println("\n try~catch~finally finish");
	}

}
