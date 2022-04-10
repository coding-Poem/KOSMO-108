package a.b.c.ch5;

public class Exam_Throws {

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
		// TODO Auto-generated method stub
		
		try{
			Exam_Throws et = new Exam_Throws();
			int z = et.aM();
			
			System.out.println("z >>> : " + z);			
		}catch (ArithmeticException a){
			System.out.println("에러가 a >>> : " + a);
		}
	}
}
