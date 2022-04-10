package a.b.c.ch5;

import java.math.BigDecimal;

public class Exam_Math_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ¿À¹ö ÇÃ·Î¿ì 
		// ÀÚ¹Ù intÇü : 4byte : 32bit : 2,147,483,647
		//                            2,500,000,000
		//                   z >>> : -1,794,967,296
		int x = 50000;
		int y = 50000;		
		int z = x * y;
		System.out.println("z >>> : " + z);
					
		// 9,223,372,036,854,775,807L
		long x1 = 50000;
		long y1 = 50000;		
		long z1 = x1 * y1;
		System.out.println("z1 >>> : " + z1);
		
		
		// ºÎµ¿ ¼Ò¼öÁ¡ ¿À·ù 
		int x2 = 1;
		double y2 = 0.1;
		int num = 7;
		double z2 = x2 - num * y2; // 0.3
		System.out.println("z2 >>> : " + z2);
		// z2 >>> : 0.29999999999999993
	
		int x3 = 1;
		double y3 = x3 * 10;
		int num1 = 7;
		double z3 = (y3 - num1) / 10.0;
		System.out.println("z3 >>> : " + z3);
	
		// java.math.BigDecimal 
		// java.math.BigDecimal.add(BigDecimal augend) : µ¡¼À ¿¬»ê
		// java.math.BigDecimal.subtract(BigDecimal subtranhend) : »¬¼À ¿¬»ê
		// java.math.BigDecimal.multiply(BigDecimal multiplicand) : °ö¼À ¿¬»ê
		// java.math.BigDecimal.devide(BigDecimal divisor) : ³ª´°¼À ¿¬»ê
		// java.math.BigDecimal.remainder(BigDecimal divisor) : ³ª¸ÓÁö ¿¬»ê
		BigDecimal b1 = BigDecimal.valueOf(1);
		BigDecimal b2 = BigDecimal.valueOf(0.7);
		System.out.println("b1.subtract(b2) >>> : " + b1.subtract(b2));
		
	}
}
