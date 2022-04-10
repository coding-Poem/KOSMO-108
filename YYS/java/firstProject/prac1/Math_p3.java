package a.b.c.prac1;

import java.util.Scanner;

public class Math_p3 {

	public static void main(String[] args) {
		int answer = (int)(Math.random() * 100) + 1;
		System.out.println("answer >>> : " + answer);
		
		Scanner sc=new Scanner(System.in);
		
		int input = 0;
		boolean iBool;
		
		try {
			do {
				System.out.println("1 과 100 사이의 정수값을 입력하시오 >>> : ");
				input = sc.nextInt();
				if (input<=100 && input>=1){
					iBool=answer==input;
					System.out.println("정답이면 true, 아니면 false"+iBool);
					if (answer==input){
						System.out.println("정답입니다!! 축하드립니다!!");
						break;
					}else if(answer>input){
						System.out.println("땡!! 다시 입력하세요!!");
						System.out.println("HINT : 더 높은 숫자를 입력하세요.");
						sc.nextLine();
					}else if(answer<input){
						System.out.println("땡!! 다시 입력하세요");
						System.out.println("HINT : 더 낮은 숫자를 입력하세요.");
					}
				}
				else{
					System.out.println("잘못 입력한 값 >>> "+input);
					System.out.println("범위를 다시 확인하시고, 다시 입력해주세요.");
					sc.nextLine();
				}				
			}
		while (true);

		}catch(Exception e){
			System.out.println("정수를 입력하지 않아 게임을 종료합니다.");
		}finally{
			System.out.println("숫자 맞추기 게임을 종료합니다.");
			sc.close();
			// Scanner를 닫습니다.
		}
	}
}
