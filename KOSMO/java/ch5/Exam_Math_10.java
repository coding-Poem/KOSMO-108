package a.b.c.ch5;

import java.math.BigDecimal;

public class Exam_Math_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// double x = 1.12345678922222;
		// double y = 1.2343456789111;
		String x = "1.12345678922222";
		String y = "1.2343456789111";

		// 빅데시말 사용할 때 문자숫자로 초기화 해야 한다.
		// 숫자로 초기화 하면 형변환이 생기는 경우 연산이 잘 못될 가능성이 있다. 
//		BigDecimal b1 = new BigDecimal("1.12345678922222");
//		BigDecimal b2 = new BigDecimal("1.2343456789111");
		
		BigDecimal b1 = new BigDecimal(x);
		// BigDecimal b1 = new BigDecimal(String.valueOf(x));		
		System.out.println("b1 >>> : " + b1);
		
		BigDecimal b2 = new BigDecimal(y);
		// BigDecimal b2 = new BigDecimal(String.valueOf(y));
		System.out.println("b2 >>> : " + b2);
		
		// public BigDecimal add(BigDecimal augend)
		// 더하기 
		BigDecimal badd = b1.add(b2);
		System.out.println("badd >>> : " + badd);
		/*
		double x = 1.12345678922222;
		double y = 1.2343456789111;
		b1 >>> : 1.12345678922222003137676438200287520885467529296875
		b2 >>> : 1.23434567891110003046151177841238677501678466796875
        badd >>> : 2.35780246813332006183827616041526198387145996093750
        
        String x = "1.12345678922222";
		String y = "1.2343456789111";
		b1 >>> : 1.12345678922222
		b2 >>> : 1.2343456789111
		badd >>> : 2.35780246813332
		*/
		badd = badd.setScale(3, BigDecimal.ROUND_DOWN);
		System.out.println("badd >>> : " + badd);
		
		// 빼기
		BigDecimal bsub = b1.subtract(b2);
		System.out.println("bsub >>> : " + bsub);		
		bsub = bsub.setScale(3, BigDecimal.ROUND_HALF_EVEN);
		System.out.println("bsub >>> : " + bsub);
		
		// 곱하기 
		BigDecimal bmul = b1.multiply(b2);
		System.out.println("bmul >>> : " + bmul);		
		bmul = bmul.setScale(3, BigDecimal.ROUND_DOWN);
		System.out.println("bmul >>> : " + bmul);
		
		// 나누기 
		// BigDecimal bdiv = b1.divide(b2);
		BigDecimal bdiv = b1.divide(b2, 3, BigDecimal.ROUND_DOWN);
		System.out.println("bdiv >>> : " + bdiv);		
//		bdiv = bdiv.setScale(3, BigDecimal.ROUND_DOWN);
//		System.out.println("bdiv >>> : " + bdiv);
		
	}
}
