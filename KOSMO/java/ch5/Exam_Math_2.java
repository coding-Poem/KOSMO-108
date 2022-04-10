package a.b.c.ch5;

import java.util.Scanner;

public class Exam_Math_2 {

	public static void main(String[] args) {
		System.out.println("1. main 함수 시작  \n");

		// public static double random()
		int answer = (int)(Math.random() * 100) + 1;
		System.out.println("\n 2. answer >>> : " + answer);
		
		int input = 0;
		int count = 0;
		System.out.println("\n 3. int input initialize check >>> "+input);
		System.out.println("\n 4. int count initialize chek >>> "+count);

				
		Scanner sc = new Scanner(System.in);
		System.out.println("\n 5. Scanner sc >>> "+sc);
		
		for (int i=0; i < 10; i++) {
			
			System.out.println("1 과 100 사이의 값을 입력하시오 >>> : ");
			
			System.out.println("count++ : count를 하나 올립니다.");
			count++;
			System.out.println("count >>> : " + count);
			
			input = sc.nextInt();
			System.out.println("input >>> : " + input);
			
			if (answer == input) {
				System.out.println("answer >>> : " + answer);
				System.out.println("input >>> : " + input);
				System.out.println("정답 !!! >>> : " + count + " 번");
				break;
			}else if (answer > input) {
				System.out.println("answer >>> : " + answer);
				System.out.println("input >>> : " + input);
				System.out.println("더 큰 수를 입력하시오 !!! >>> : \n");
			}else if (answer < input) {
				System.out.println("answer >>> : " + answer);
				System.out.println("input >>> : " + input);
				System.out.println("더 작은1 수를 입력하시오 !!! >>> : \n");
			}
			
			if (count == 10) {
				System.out.println("count >>> : " + count);
				sc.close();
				break;
			}
		}
		sc.close();
		
	}
}
