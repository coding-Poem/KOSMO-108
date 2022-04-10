/*
package a.b.c.prac1;
 *
 * 요구사항
 * 
 * 0. NameSpace 외부에서 불러서 사용할 거 정하기(사용할 리소스 생각)
 * 1. 클래스 만들고 함수 만들기
 * 2. 함수에 들어갈 변수 정해서
 * 3. main method 지역변수 초기화 시켜 놓기
 * 4. try catch finally로 예외 처리하기
 * 5. Scanner로 받을 값 어떻게 처리할지 고민해보기
 * (charAt)사용
 * 
 * 

import java.util.Scanner;
import java.math.BigDecimal;


public class YS_Calcu2 {
	
	public BigDecimal operator(BigDecimal x, BigDecimal y, BigDecimal o){
		// 인수가 잘 들어왔는지 확인하기
		System.out.println("oprator method안에 x >>> "+x);
		System.out.println("oprator method안에 y >>> "+y);
		System.out.println("oprator method안에 o >>> "+o);
		
		// if문으로 무슨 연산을 할 건지 확인하기
		return ans;
	}

	public static void main(String[] args) {
		// main method 지역변수 초기화
		Scanner sc=null;
		String x="";
		String y="";
		String o="";
		String oo="";
		char co=' ';
		int i=0;
		// '\u0000';
		
		try {
			sc=new Scanner(System.in);
			System.out.println("연산에 사용할 처음 값을 입력해주세요.");
			x=sc.next();
			System.out.println("연산에 사용할 두 번째 값을 입력해주세요.");
			y=sc.next();
			
			System.out.println("입력하신 첫 번째 값은  :"+x+", 두번째 값은 "+y+"입니다.");
			
			System.out.println("연산할 연산자를 + - * / 중에 입력하세요.");
			o=sc.next();
			co=o.charAt(0);
			// 입력된 첫 번째 글자를 뽑는다.
			System.out.println("입력하신 연산자는 >>> "+co);
			
			BigDecimal b1=new BigDecimal(x);
			System.out.println("입력하신 첫 번째 값 재확인 >>> : "+b1);
			
			BigDecimal b2=new BigDecimal(y);
			System.out.println("입력하신 두 번째 값 재확인 >>> : "+b2);
			
			i=co;
			System.out.println("입력한 연산자를 정수로 변환한 값 >>> : "+i);
			oo=Integer.toBinaryString(i);
			System.out.println("정수를 2바이트 코드로 변환한 값 >>> : "+oo);
			
			sc.close();
		}catch(Exception e){
			
		}finally{
			if(sc!=null){
				sc.close();
			}
			System.out.println("계산기 프로그램을 종료합니다.");
		}
	}
}
*/
