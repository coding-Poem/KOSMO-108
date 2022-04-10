package a.b.c.ch5;

public class Exam_Math_6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 로또 번호를 생성해서 담으려고 배열을 만든다.
		// 번호가 6개 이니 방 6개로 만든다. 정수형
		int lo[] = new int[6];
		System.out.println("lo >>> : " + lo);
		for (int i=0; i < lo.length; i++) {
			System.out.println("lo[" + i + "] >>> : " + lo[i]);
		}
		
		// 6개 방에 로또 번호를 넣기 
		for (int i=0; i < lo.length; i++) {
		
			// Math.random() 함수 이용해서 로또 번호 생성
			// 1 ~ 45번까지 
			// 6개 방에 넣기 
			int ii = (int)(Math.random()*45) + 1; 
			System.out.println("\n================================================");
			System.out.println("(int)(Math.random()*45) + 1 :: ii >>> : " + ii);
			System.out.println("================================================");
			lo[i] = ii;
			System.out.println("lo[" + i + "] >>> : " + lo[i]);
			
			// 인덱스 	  0    1 	2 	3 	4 	5 
			// 값            	35    18   17   10  30  27
			// 먼저 생성된 로또 번호 lo[i]
			// 새로들어오 번호 같으면 먼저 만들어진 번호 삭제 
			for (int j=0;j < i; j++) {
				System.out.println("\nfor >>> : jjjjj :: " + lo[j]);
				System.out.println("for >>> : iiiii :: " + lo[i]);
				if (lo[j] == lo[i]) {
					System.out.println("if >>> : " + lo[j] + " : " + lo[i]);
					i--;
					break;					
				}
			} 
		}	
		
		System.out.println("\n================================================");
		for (int i=0; i < lo.length; i++) {
			System.out.print(lo[i] + " ");
		}					
	}
}
