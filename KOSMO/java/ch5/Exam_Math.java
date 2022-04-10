package a.b.c.ch5;

import java.text.DecimalFormat;

public class Exam_Math {
	
	double de = Math.E;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java.lang.Math
		// public static final double E
		double e = Math.E;
		System.out.println("e >>> : " + e);
		System.out.println("e >>> : " + Math.round(e));
		
		System.out.println("e >>> : " + Math.round(e*100));
		System.out.println("e >>> : " + Math.round(e*100)/100.0);
		System.out.println("e >>> : " + Math.round(e*1000));
		System.out.println("e >>> : " + Math.round(e*1000)/1000.0);
		System.out.println("e >>> : " + Math.round(e*100000));
		System.out.println("e >>> : " + Math.round(e*100000)/100000.0);		
		
		System.out.println("e >>> : " + String.format("%.2f", e));
		System.out.println("e >>> : " + String.format("%.3f", e));
		System.out.println("e >>> : " + String.format("%.5f", e));	
		
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println("df >>> : " + df.format(1.234567));
		System.out.println("df >>> : " + df.format(e));
		
		System.out.println("Math.floor(e) >>> : " + Math.floor(e));
		
				
		System.out.println("Math.E >>> : " + Math.E);
		System.out.println("Math.E >>> : " + Math.round(Math.E));
		System.out.println("Math.E >>> : " + Math.floor(Math.E));
		
		// java.lang.Math
		// public static final double PI
		double pi = Math.PI;
		System.out.println("p1 >>> : " + pi);
		
		
		// round : 반올림 : 전달 받은 실수를 소수점 첫 번째 자리에서 반올림한 결과 반환
		double round = Math.round(10.1);
		System.out.println("round >>> : " + round);
				
		// ceil : 올림 : 전달 받은 실수보다 작은 정수 중 가장 작은 정수 반환
		double ceil = Math.ceil(10.1);
		System.out.println("ceil >>> : " + ceil);
		
		// floor : 내림 : 전달 받은 실수보다 작은 정수 중 가장 큰 정수 반환
		double floor = Math.floor(10.9);
		System.out.println("floor >>> : " + floor);
		
		// pow : 제곱연산 : (5, 2) -> 25
		double pow = Math.pow(5, 2);
		System.out.println("pow >>> : " + pow);		
		
		
		// abs : 절대값 반환 : absolute number
		System.out.println("Math.abs(-10) >>> : " + Math.abs(-10));
		System.out.println("Math.abs(0) >>> : " + Math.abs(0));
		System.out.println("Math.abs(10) >>> : " + Math.abs(10));
		
		// max : 큰값
		int max = Math.max(2, 2);
		System.out.println("max >>> : " + max);
		
		// min : 작은 값
		int min = Math.min(2, 2);
		System.out.println("min >>> : " + min);
	
	}
}
