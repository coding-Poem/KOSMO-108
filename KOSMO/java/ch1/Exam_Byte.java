package a.b.c.ch1;

public class Exam_Byte {

	public static void main(String args[]) {

		System.out.println("byte의 크기는 1 바이트 >>> : " + Byte.BYTES);
		// BYTES : The number of bytes used to represent a byte value in
		// two's complement binary form
		System.out.println("byte의 사이즈 8 비트 >>> : " + Byte.SIZE);
		// SIZE : The number of bits used to represent a byte value in two's
		// complement binary form.

		byte bMax = Byte.MAX_VALUE;
		System.out.println("byte의 최대값 :: Byte.MAX_VALUE >>> : " + bMax);
		// MAX_VALUE : A constant holding the maximum value a byte can have 2^7-1.
		
		byte bMin = Byte.MIN_VALUE;
		System.out.println("byte의 최소값 :: Byte.MIN_VALUE >>> : " + bMin);
		// MIN_VALUE : A constant holding the minimum value a byte can have -2^7

		//byte b_1 = 128;
		//System.out.println("b_1 >>> : " + b_1);

		//byte b_2 = -129;
		//System.out.println("b_2 >>> : " + b_2);


	
	}
}