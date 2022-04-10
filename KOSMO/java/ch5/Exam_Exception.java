package a.b.c.ch5;

public class Exam_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// x, y 값을 명령행 인수로 받기  String[] args = {"", ""};
		
		// 예외처리 를 했다.
		try {
		
			String args0 = args[0];
			String args1 = args[1];

			int x = Integer.parseInt(args0);
			int y = Integer.parseInt(args1);
			
			int z = x + y;
			
			System.out.println("x + y = " + z);

		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
				
		System.out.println("더하기 프로그램을 만들었다. >>> : ");
	}

}
