package a.b.c.ch1;


public class Exam_For_2 {

	public static void main(String args[]) {

		/*
		자바에서 for 문 초기화 식에서 항상 초기화 값을 0으로 하는데
		그 이유는 for 대부분 배열 데이터를 처리하는데 사용하기 때문 이다.
		배열의 인덱스는 0 부터 시작하기 때문이다. 
		*/
		for (int i=0; i < 3 ; i++ ){
			System.out.println("i >>> : " + i);
		}	

		for (int i=1; i < 3 ; i++ ){
			System.out.println("i >>> : " + i);
		}
		
		for (int i=1; i <= 3 ; i++ ){
			System.out.println("i >>> : " + i);
		}

		for (int i=1; (i-1) < 3 ; i++ ){
			System.out.println("i >>> : " + i);
		}
	}
}