package a.b.c.prac1;

import java.math.BigDecimal;

public class Math_10 {

	public static void main(String[] args) {
		// 서울시청 위도, 경도 : 37.56632697499861, 126.97792762801669
		String x="37.56632697499861";
		String y="126.97792762801669";
		// double x = 1.1234567892222;
		// double y = 1.2343456789111";
		
		// BigDecimal 사용할 때 문자숫자로 초기화 해야 한다.
		// 숫자로 초기화 하면 형변환이 생기는 경우 연산이 잘 못될 가능성이 있다.
		BigDecimal b1=new BigDecimal(x);
		// BigDecimal b2=new BigDecimal(String.valueOf(y));
		System.out.println("b1 >>> : "+b1);
		// b1 >>> : 37.56632697499861
		BigDecimal b2=new BigDecimal(y);
		System.out.println("b2 >>> : "+b2);
		// b2 >>> : 126.97792762801669
		
		// BigDecimal에 double 자료형을 넣으면 안 되는 이유
		double dx=37.56632697499861;
		double dy=126.97792762801669;
		
		BigDecimal b11=new BigDecimal(dx);
		BigDecimal b22=new BigDecimal(dy);
		
		System.out.println("dx >>> : "+dx);
		// dx >>> : 37.56632697499861
		System.out.println("dy >>> : "+dy);
		// dy >>> : 126.97792762801669
		
		// add : BigDecimal vs Double
		BigDecimal badd=b1.add(b2);
		System.out.println("badd >>> : "+badd);
		// badd >>> : 164.54425460301530
		BigDecimal badd_D=b11.add(b22);
		System.out.println("badd_D >>> : "+badd_D);
		// badd_D >>> : 164.54425460301529682283216970972716808319091796875
		
		/*
		 * 연산 과정에 있어서 참조변수 주소값은 double로 참조변수를 만들거나,
		 * String 참조변수를 만들거나 주소 값은 똑같다. 그러나,
		 * 둘 다 더하기를 시도했을 때, 결과값이 다르다.
		 * */
		
		System.out.println("=======================================");
		System.out.println("== BigDecimal 참조변수 생성시 문자숫자 넣을 것 ==");
		System.out.println("== 절대로 double와 같은 자료형 넣지 말 것            ==");
		System.out.println("========================================");
		
		badd=badd.setScale(3, BigDecimal.ROUND_DOWN);
		System.out.println("badd.setScale(3, BigDecimal.ROUND_DOWN) >>> "+badd);
		// BigDecimal : setScale (종류별로 많음)
		// 그 중 하나가, BigDecimal : setScale(int newScale, int roundingMode)
		// The new setScale(int, RoundingMode) method should be 
		// used in preference to this legacy method.
		// 사전적인 의미로는 legacy는 유산인데, 여기 설명에서는 물려받아오다 이런 느낌인듯?
		// 전통적으로 이렇게 쓰는 것을 선호한다 카더라?
		
		// before setScale 3 badd >>> : 164.54425460301530
		// after setScale 3 badd >>> : 164.544
		// 소수점 세 번째 자리에서 자르는 것을 확인 할 수 있음.
		
		// 음수값 끼리 더해야 하는 경우? => 시간 부족하니 나중에 체크
		
		// 빼기
		BigDecimal bsub=b1.subtract(b2);
		// b1 - b2인지 , b2 - b1 인지
		// 두 수의 기호가 다를 경우는 어떻게 처리되는지?
		System.out.println("bsub >>> : "+bsub);
		BigDecimal bsub_D=b11.subtract(b22);
		System.out.println("bsub_D >>> : "+bsub_D);
		
		
		BigDecimal bmul=b1.multiply(b2);
		System.out.println("bmul >>> : "+bmul);
		BigDecimal bmul_D=b11.multiply(b22);
		System.out.println("bmul_D >>> : "+bmul_D);
		
		BigDecimal bdiv=b2.divide(b1);
		System.out.println("bdiv >>> : "+bdiv);
		BigDecimal bdiv_D=b22.divide(b11);
		System.out.println("bdiv_D >>> : "+bdiv_D);	
	}

}
