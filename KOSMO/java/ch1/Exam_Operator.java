package a.b.c.ch1;

public class Exam_Operator {

	public static void main(String args[]) {
	
		/*
			증감 연산자 increment and decrement operators
			++x		x 를 먼저 1 증가 시킨 후 그 값을 사용	
			--x		x 를 먼저 1 감소 시킨 후 그 값을 사용	
			x++		x 값를 먼저 사용한 후 1 증가 
			x--		x 값를 먼저 사용한 후 1 감소 
		*/

		int aX = 10;
		System.out.println(aX);
		
		aX++; // aX = aX + 1 --> 10 = 10 + 1;
		System.out.println(aX);

		++aX;
		System.out.println(aX);


		int aXX = 100;
		System.out.println(aXX);

		int aa = aXX++; // int aa = aXX = aXX + 1		
		System.out.println(aa);		
		
		aa = ++aXX;
		System.out.println(aa);

		
	}
}