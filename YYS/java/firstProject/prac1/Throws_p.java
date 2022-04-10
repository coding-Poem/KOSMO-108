package a.b.c.prac1;

public class Throws_p {

	int aM() throws ArithmeticException  {
		
		int z = bM();
		return z;
	}
	
	int bM() throws ArithmeticException {	
		
		int z = 0;		
		
		z = 1 / 0;			
		
		return z;
	}

	/*
	main() 함수로 시작하는 프로그램에서 
	함수의 호출 순서에 의해 수행 되다가
	에러가 발생할 경우 
	에러가 발생한 라인이 있는 함수 부터 
		에러를 던저셔(throws)  ~~
		main() 함수에서 예외 처리를 하면 된다. 
	*/

	// main() 함수가 시작점 이다. 
	// public static void main(String[] args) throws ArithmeticException  {
	public static void main(String[] args)  {
		
		/* Throws_p 클래스에 생성자와 참조변수 선언
		  해당 참조변수에 리소스인 aM()을 사용하려고 하니
		  aM 자원은 bM 자원을 받아와야 하고
		  bM자원에서는 java runtime error가 출력된다.
		  이 때, throw 키워드를 사용하여 ArithmeticException에다가
		  던지고, 이 예외를 try~catch~finally(생략가능) 문을 이용하여,
		  catch에서 예외를 출력시킨다.
		*/
		try{
			Throws_p et = new Throws_p();
			int z = et.aM();
			
			System.out.println("z >>> : " + z);			
		}catch (ArithmeticException a){
			System.out.println("에러가 a >>> : " + a);
			// 에러가 a >>> : java.lang.ArithmeticException: / by zero
		}
		System.out.println("main 함수 끝");
	}
}