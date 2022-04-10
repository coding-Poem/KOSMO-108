package a.b.c.prac1;


import java.math.BigDecimal;

public class Math_9 {

	public static void main(String[] args) {
		
		// 오버 플로우
		// 자바 int형
		int m=0;
		m=Integer.MAX_VALUE;
		System.out.println("Integer.MAX_VALUE >>> "+m);
		// Integer.MAX_VALUE >>> 2147483647
		
		int x=50000;
		int y=50000;
		int z=x*y;
		System.out.println("z >>> : "+z);
		// z >>> : -1794967296
		
		// long 자료형으로 해결하기
		long l=0;
		l=Long.MAX_VALUE;
		System.out.println("Long.MAX_VALUE >>> : "+l);
		// Long.MAX_VALUE >>> : 9223372036854775807
		
		long x1=50000;
		long y1=50000;
		long z1=x1*y1;
		System.out.println("z1 >>> : "+z1);
		// z1 >>> : 2500000000
		
		/*
		char c=' ';
		c= (z1>m) ? <'T':'F'>;
		System.out.println(" ")
		*/
				
		// 부동 소수점 오류
		int x2=1;
		double y2=0.1;
		int num=7;
		double z2=x2-(num*y2); //0.3
		System.out.println("z2 >>> "+z2);
		//  0.29999999999999993
		// JVM이 int밖에 몰라서 이럼...

		// 해결방법 1: java.math.BigDecimal;
		BigDecimal b1= BigDecimal.valueOf(1);
		BigDecimal b2=BigDecimal.valueOf(0.7);
		System.out.println("b1.subtract(b2) >>> : "+b1.subtract(b2));
		
		// 두 번째 해결 방법 : JVM을 위해 INT로 해결
		// 1-(7*0.1) = 1- (7/10)
		// x2-(y2*10-num)/10
		
		//강사님 방법
		// double y3=x3*10;
		// double z3=(y3-num1)/10.0
		
	}

}
