package a.b.c.prac1;

/* 
 * 유의해야 할점 
 * static long : round(double a)
 * static int : round(float a)
 * round 함수 인수에 어떤 데이터 타입이 들어가냐에 따라
 * 반환되는 기초자료형 변수가 다름.
*/ 


import java.text.DecimalFormat;

public class Math_p {
	void math_test(double args){
		System.out.println("math_test(double args) method 시작 \n");
		System.out.println("1. args >>> "+args);
		System.out.println("2. Math.round(args) >>> "+Math.round(args));
		System.out.println("3. args*100 >>> "+Math.round(args*100));
		System.out.println("4. args*100/100.0 >>> "+Math.round(args*100)/100.0);
		System.out.println("5. args*1000 >>> "+Math.round(args*1000));
		System.out.println("6. args*1000/1000.0 >>> "+Math.round(args*1000)/1000.0);
		System.out.println("7. args*100000 >>> "+Math.round(args*100000));
		System.out.println("8. args*100000/100000.0 >>> "+Math.round(args*100000)/100000.0);
		System.out.println("\n String 클래스의 format 메서드로 반올림하기  ");
		System.out.println("9. args .2f >>> "+String.format("%.2f", args));
		System.out.println("10. args .3f >>> "+String.format("%.3f", args));
		System.out.println("11. args .5f >>> "+String.format("%.5f", args));
		System.out.println("\n DecimalFormat df = new DecimalFormat(\"#.###\"); ");
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println("12. df >>> "+df.format(args));
		System.out.println("\n 13. Math.floor(args) >>> "+Math.floor(args));
	}

	public static void main(String[] args) {
		double e=Math.E;
		double pi=Math.PI;
		
		new Math_p().math_test(e);
		
		new Math_p().math_test(pi);

		// 흔히 아는 내용이랑 살짝 달라서 api보기
		// round : 반올림 : 전달 받은 실수를 소수점 첫 번째 자리에서 반올림한 결과 반환
		double round = Math.round(10.1);
		System.out.println("round >>> : " + round);
		// ceil : 올림 : 전달 받은 실수보다 크거나 같은 정수 중 가장 작은 정수 반환
		double ceil = Math.ceil(10.1);
		System.out.println("ceil >>> : " + ceil);
		
		// floor : 내림  : 전달 받은 실수보다 작은 정수 중 가장 큰 정수 반환
		double floor = Math.floor(10.9);
		System.out.println("floor >>> : " + floor);
		
		// pow : 제곱연산 :
		double pow = Math.pow(5, 2);
		System.out.println("pow >>> : " + pow);	
		
		// abs: 절대값 :
		System.out.println("Math.abs(-10) >>> : " + Math.abs(-10));
		System.out.println("Math.abs(0) >>> : " + Math.abs(0));
		System.out.println("Math.abs(10) >>> : " + Math.abs(10));
	
		// max : 큰 값 :
		int max = Math.max(2, 5);
		System.out.println("max >>> : " + max);
		
		// min : 작은 값 :
		int min = Math.min(3, 2);
		System.out.println("min >>> : " + min);
	
	}

}
