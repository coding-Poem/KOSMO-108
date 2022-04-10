package a.b.c.ch1;

public class Exam_while_1 {

	public static void main(String args[]) {
		
		// 지역변수 
		int num = 1;
		int sum = 0;
		
		do{
			sum += num;
			num++;
		}
		while (num >= 10);

		System.out.println("1부터 10 까지의 합은 " + sum + " 입니다.");
	}
}