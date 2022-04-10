package a.b.c.ch5;

public class Exam_Throw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			throw new Exception("오류 메시지");
			// Exception e = new Exception("오류 메시지");
			// throw e;
		}catch(Exception e) {
			System.out.println("e >>> : " + e);	
			// 공부할 때 에러 메시지는 getMessage() 함수로 출력한다.
			System.out.println("e.getMessage() >>> : " + e.getMessage());
			// e.printStackTrace();
		}
		
		System.out.println("try-catch 블럭 이후 >>> : ");
	}

}
