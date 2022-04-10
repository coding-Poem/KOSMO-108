package a.b.c.ch5;

import java.math.BigDecimal;
import java.util.Scanner;

// 요구사항
/*
1. 사칙연산 : + - * /
2. BicDecimal 사용
3. 각 연산은 함수 구현, 함수 이름은 본인 만들어 보기 
4. 연산 결과는 main 함수에서 콘솔에 출력하기 
5. 입력은 Scanner 클래스 사용

13:00 까지 만들기 
*/
// 강민 계산기 
public class KM_Calcu_1 {
	
	public BigDecimal kmAdd(BigDecimal b1, BigDecimal b2) {	
		return b1.add(b2);
	}
	public BigDecimal kmSubtract(BigDecimal b1, BigDecimal b2) { 		
		return b1.subtract(b2);
	}
	public BigDecimal kmMultiply(BigDecimal b1, BigDecimal b2) {
		return b1.multiply(b2);
	}
	public BigDecimal kmDivide(BigDecimal b1, BigDecimal b2) {
		return b1.divide(b2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = null;
		
		String x = "";
		String y = "";
		String oper = "";
		char cOper = '\u0000';
				
		try {
		
			sc = new Scanner(System.in);
			
			System.out.println("연산할 x 값을 입력하시오 >>> : ");
			x = sc.next();
			System.out.println("x >>> : " + x);
			
			System.out.println("연산할 y 값을 입력하시오 >>> : ");
			y = sc.next();
			System.out.println("y >>> : " + y);
			
			System.out.println("연산할  연산자를  + - * /  입력하시오 >>> : ");
			oper = sc.next();
			cOper = oper.charAt(0);
			System.out.println("cOper >>> : " + cOper);
	
			// 입력변수를 빅데시말로 초기화해서 사용
			BigDecimal b1 = new BigDecimal(x); 						
			BigDecimal b2 = new BigDecimal(y);
			
			if (0x2B == cOper) {
				// +
				System.out.println("연산할  연산자는>>> : " + cOper);
				
				KM_Calcu_1 km_add = new KM_Calcu_1();
				BigDecimal badd = km_add.kmAdd(b1, b2);
				
				System.out.println(x + " + " + y + " = " + badd);			
			}
			if (0x2D == cOper) {
				// -				
				System.out.println("연산할  연산자는>>> : " + cOper);
				
				KM_Calcu_1 km_sub = new KM_Calcu_1();
				BigDecimal bsubtract= km_sub.kmSubtract(b1, b2);
				
				System.out.println(x + " - " + y + " = " + bsubtract);
			}
			if (0x2A == cOper) {
				// *				
				System.out.println("연산할  연산자는>>> : " + cOper);
				
				KM_Calcu_1 km_mul = new KM_Calcu_1();
				BigDecimal bmultiply = km_mul.kmMultiply(b1, b2);
				
				System.out.println(x + " * " + y + " = " + bmultiply);
			}
			if (0x2F == cOper) {				
				System.out.println("연산할  연산자는>>> : " + cOper);
				
				KM_Calcu_1 km_div = new KM_Calcu_1();
				BigDecimal bdivide = km_div.kmDivide(b1, b2);
				
				System.out.println(x + " / " + y + " = " + bdivide);
			}
			
			sc.close();
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			if (sc !=null) {
				sc.close();
			}
		}
	}
}
