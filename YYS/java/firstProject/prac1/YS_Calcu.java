package a.b.c.prac1;

// 요구사항
// 1. 사칙연산 + - * /
// 2. BicDecimal 사용
// 3. 각 연산은 함수로 구현 (함수 이름은 본인이 만들어 보기)
// 4. 연산 결과는 main 함수에서 콘솔에 출력하기
// 5. 입력은 Scanner 클래스 사용

import java.math.BigDecimal;
import java.util.Scanner;
// java.util.Scanner : since 1.5
// java.lang 패키지가 아니므로, import 해온다.



public class YS_Calcu {
	BigDecimal bicd_oper_add(String input1, String input2, String c){		
		//======================
		System.out.println();
		System.out.print(input1+",");
		System.out.print(input1+",");
		System.out.print(c);
		System.out.println();
		// 잘 들어왔나 확인해보기 =====
		
		System.out.println("BigDecimal b1 = new BigDecimal(input1) 시작");
		BigDecimal b1 =new BigDecimal(input1);
		System.out.println("add 함수 안에 b1 >>> : "+b1);
		
		System.out.println("BigDecimal b2 = new BigDecimal(input2) 시작");
		BigDecimal b2 =new BigDecimal(input2);
		
		
		
		System.out.println("add 함수 안에 b2 >>> : "+b2);
		
	
		System.out.println("BigDecimal ans=b1.add(b2); 시작");
		BigDecimal ans=b1.add(b2);
		System.out.println("함수내에서 만든 답 >>> : "+ans);
		
		
		return ans;
	}
	
	BigDecimal bicd_oper_subtract(String input1, String input2, String c){
		
		//======================
		System.out.println();
		System.out.print(input1+",");
		System.out.print(input1+",");
		System.out.print(c);
		System.out.println();
		// 잘 들어왔나 확인해보기 =====
			
		System.out.println("BigDecimal b1 = new BigDecimal(input1) 시작");
		BigDecimal b1 =new BigDecimal(input1);
		System.out.println("subtract 함수 안에 b1 >>> : "+b1);
		
		System.out.println("BigDecimal b2 = new BigDecimal(input2) 시작");
		BigDecimal b2 =new BigDecimal(input2);
		System.out.println("subtract 함수 안에 b1 >>> : "+b2);
		
		System.out.println("BigDecimal ans=b1.subtract(b2); 시작");
		BigDecimal ans=b1.subtract(b2);
		System.out.println("함수내에서 만든 답 >>> : "+ans);
		
		return ans;
	}
	
	BigDecimal bicd_oper_multiply(String input1, String input2, String c){
		
		//======================
		System.out.println();
		System.out.print(input1+",");
		System.out.print(input1+",");
		System.out.print(c);
		System.out.println();
		// 잘 들어왔나 확인해보기 =====
		
		System.out.println("BigDecimal b1 = new BigDecimal(input1) 시작");
		BigDecimal b1 =new BigDecimal(input1);
		System.out.println("multiply 함수 안에 b1 >>> : "+b1);
		
		System.out.println("BigDecimal b2 = new BigDecimal(input2) 시작");
		BigDecimal b2 =new BigDecimal(input2);
		System.out.println("multiply 함수 안에 b2 >>> : "+b2);
		
		System.out.println("BigDecimal ans=b1.multiply(b2); 시작");
		BigDecimal ans=b1.multiply(b2);
		System.out.println("함수내에서 만든 답 >>> : "+ans);
					
		return ans;
	}
	
	BigDecimal bicd_oper_divide(String input1, String input2, String c){	
		//======================
		System.out.println();
		System.out.print(input1+",");
		System.out.print(input1+",");
		System.out.print(c);
		System.out.println();
		// 잘 들어왔나 확인해보기 =====
		
		System.out.println("BigDecimal b1 = new BigDecimal(input1) 시작");
		BigDecimal b1 =new BigDecimal(input1);
		System.out.println("divide 함수 안에 b1 >>> : "+b1);
		
		System.out.println("BigDecimal b2 = new BigDecimal(input2) 시작");
		BigDecimal b2 =new BigDecimal(input2);
		System.out.println("divide 함수 안에 b1 >>> : "+b2);
		
		System.out.println("BigDecimal ans=b1.divide(b2); 시작");
		BigDecimal ans=b1.divide(b2);
		System.out.println("함수내에서 만든 답 >>> : "+ans);
		
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("0. main 함수 시작");
		YS_Calcu ys= new YS_Calcu();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. sc >>> : "+sc);
		
		// 초기화
		String input1="";
		String input2="";
		String c1="";
		int c=0;
		//
		
		// float max, (2-2^-23) 2^127, min, 2^-126
		// double max, (2-2^-52) 2^1023, min,  2^-1074

		try{
			System.out.println("첫 번째 숫자를 실수범위 내에서 입력하세요.");
			input1=sc.next();
			System.out.println("두 번째 숫자를 실수범위 내에서 입력하세요.");
			sc.nextLine();
			input2=sc.next();
			
			// 내가 생각했던 방법
			System.out.println("더하기는 : 1을 입력하세요.");
			System.out.println("빼기는 : 2를 입력하세요.");
			System.out.println("곱하기는 : 3을 입력하세요.");
			System.out.println("나누기는 : 4를 입력하세요.");
			c=sc.nextInt();

			System.out.println("c >>> "+c);
			if (c<5) {
				if (c>0){
				if(c==1){
					c1=String.valueOf(c);
					BigDecimal ans1=ys.bicd_oper_add(input1, input2, c1);
					System.out.println("답 : >>> "+ans1);
				}
				if(c==2){
					c1=String.valueOf(c);
					BigDecimal ans1=ys.bicd_oper_subtract(input1, input2, c1);
					System.out.println("답 : >>> "+ans1);
				}
				if(c==3){
					c1=String.valueOf(c);
					BigDecimal ans1=ys.bicd_oper_multiply(input1, input2, c1);
					System.out.println("답 : >>> "+ans1);
				}
				if(c==4){
					c1=String.valueOf(c);
					BigDecimal ans1=ys.bicd_oper_divide(input1, input2, c1);
					System.out.println("답 : >>> "+ans1);
				}
			}
				else {
					System.out.print("더하기, 빼기, 곱하기, 나누기 숫자를 다시 확인하세요.");
				}
		}
			// 강사님은 charAt로 코드를 바꿔서 사용하셨다.
			// 연습해보기
			
			
			sc.close();
		}catch(Exception e){
			System.out.println("잘못 입력하셨습니다.");
		}finally{
			System.out.println("계산기 프로그램을 종료합니다.");
			if (sc!=null){
			  sc.close();
			 }
		} // finally
	} // main method

} // YS_Calcu class
