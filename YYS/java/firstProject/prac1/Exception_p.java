package a.b.c.prac1;

public class Exception_p {

	public static void main(String[] args) {
		// Stirng[] args : 명령행 인수
		// 4, "육" 입력
		
		// 마우스 우클릭 후,
		// Run Configuration
		// name과 main  맞게 썻는지 확인하고,
		// arguments에서 입력
		try {
		String s0=args[0];
		String s1=args[1];
		
		int x=Integer.parseInt(s0);
		int y=Integer.parseInt(s1);
		// 해당 과정에서 에러가 났음. (예외처리)
		
		int z=x+y;
		
		System.out.println("x + y ="+z);
		}catch(Exception e){
			System.out.println("잘못 입력한 값  : "+e.getMessage());
			// 잘못 입력한 값  : For input string: "육"
			// java.lang.Throwable 부모 클래스
			// getMessage
			// public String getMessage()
			// Returns the detail message string of this throwable. 
			// java.lang.Exception 클래스
			// Exception 자식 클래스에서 Throwable 부모 클래스의 getMessage 가져와서 에러 내용 출력
		}finally {
		System.out.println("\n 더하기 프로그램을 종료합니다.");
		}

	}

}
