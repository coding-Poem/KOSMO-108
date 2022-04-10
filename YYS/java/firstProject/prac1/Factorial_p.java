package a.b.c.prac1;

import java.util.Scanner;

public class Factorial_p {
	static int cnt=0;
	
	public static int factorial(int n){
		cnt++;
		System.out.println("factorial 함수 "+cnt+"번재 실행 \n");
		if(n>0){
			System.out.println(" >>> : "+n);
			System.out.println(n+"*"+(n-1)+"\n");
			return n*factorial(n-1);
			// n이 0이 될 때 까지 계속 재귀 호출해라.
		}else{
			return 1;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("정수를 입력 하시오 >>> : ");
			int i=sc.nextInt();
			System.out.println("입력한 정수가 >>>> : "+i+"\n");
			System.out.println(i+"의 팩토리얼은 "+Factorial_p.factorial(i)+"입니다.");
			sc.close();
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally{
			if (sc!=null){
				try{sc.close(); sc=null;}catch(Exception e){}
			}
		}

	}

}
