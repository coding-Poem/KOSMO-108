package a.b.c.ch1;

// 107 쪽
// 반목문 : for, while 조건식에는 false 를 사용하면 않된다.
// 분기문 : if 문 조건식에는 false 사용이 가능하다.
public class Exam_while {

	public static void main(String args[]) {
		
		boolean bool = false;
		while (bool){
			System.out.println(">>>");
		}

		// 지역변수 
		int num = 1;
		int sum = 0;
		int count = 0;

		while (num <= 10){
		
			count++;
			sum += num;
			
			System.out.println(count + "번째 연산 >>> : " + sum + " ");
			if (sum > 20){				
				break;
			}

			num++;
		}

		System.out.println("1부터 " + count + " 까지의 합은 " + sum + " 입니다.");
		System.out.println(count + " 번 연산 했습니다.");
	}
}