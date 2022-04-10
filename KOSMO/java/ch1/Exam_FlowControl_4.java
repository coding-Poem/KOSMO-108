package a.b.c.ch1;

public class Exam_FlowControl_4 {

	public int add(int x, int y) {		
		return x + y;
	}

	public int subtract(int x, int y) {		
		return x - y;
	}

	public int multiply(int x, int y) {		
		return x * y;
	}

	public int divide(int x, int y) {		
		return x / y;
	}

	public static void main(String args[]) {

		// String args[] = new String[];
		// String args[] = new String[2];
		// C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_4 1 2
		// String args[] = new String[]{"1", "2"};
		// String args[] = {"1", "2"};

		// length() : String 클래스의 문자열의 길이를 구하는 함수 
		// length 필드 : 배열의 길이를 구하는 함수
		int argsLength = args.length;
		boolean aBool = argsLength == 2;
		System.out.println("aBool >>> : " + aBool);
		
		// 메인 함수의 파라미터인 String args[] 배열을 명령행 인수 라고 부른다.
		// 명령행 인수가, String 배열의 갯수가 2개 일 때만 if 문이 수행된다.
		// if (args.length == 2){
		if (aBool){

			// String 문자열 클래스의 참조변수 s0 에 명령행 인수 첫 번째 값을 할당한다.
			String s0 = args[0]; // "1"
			// String 문자열 클래스의 참조변수 s1 에 명령행 인수 두 번째 값을 할당한다.
			String s1 = args[1]; // "2"
			
			// public static int parseInt(String s)
			// parseInt(String s) : 문자 숫자를 숫자로 바꾸는 함수 
			// 문자 숫자 : "1" "2",  
			// "일" : 문자
			int x = Integer.parseInt(s0);
			int y = Integer.parseInt(s1);

			Exam_FlowControl_4 ef4 = new Exam_FlowControl_4();
			System.out.println("ef4 참조변수 주소값 >>> : " + ef4);
			
			int add = ef4.add(x, y);
			System.out.println("add >>> : " + add);
			
			int subtract = ef4.subtract(x, y);
			System.out.println("subtract >>> : " + subtract);
			
			int multiply = ef4.multiply(x, y);
			System.out.println("multiply >>> : " + multiply);
			
			int divide = ef4.divide(x, y);
			System.out.println("divide >>> : " + divide);

		}else{
			System.out.println("연산할 수를 잘 입력하시오 >>> : ");
		}
	}
}

/*
C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_FlowControl_4.java

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_4 1 2
ef4 참조변수 주소값 >>> : a.b.c.ch1.Exam_FlowControl_4@15db9742
add >>> : 3
subtract >>> : -1
multiply >>> : 2
divide >>> : 0
*/