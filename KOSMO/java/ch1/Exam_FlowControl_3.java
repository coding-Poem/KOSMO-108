package a.b.c.ch1;

public class Exam_FlowControl_3 {

	public int add(int x, int y) {		
		return x + y;
	}

	public static void main(String args[]) {

		// 메인 함수의 파라미터인 String args[] 배열을 명령행 인수 라고 부른다.
		// 명령행 인수가, String 배열의 갯수가 2개 일 때만 if 문이 수행된다.
		if (args.length == 2){

			// String 문자열 클래스의 참조변수 s0 에 명령행 인수 첫 번째 값을 할당한다.
			String s0 = args[0];
			// String 문자열 클래스의 참조변수 s1 에 명령행 인수 두 번째 값을 할당한다.
			String s1 = args[1];
			
			// public static int parseInt(String s)
			// parseInt(String s) : 문자 숫자를 숫자로 바꾸는 함수 
			// 문자 숫자 : "1" "2",  
			// "일" : 문자
			int x = Integer.parseInt(s0);
			int y = Integer.parseInt(s1);

			Exam_FlowControl_3 ef3 = new Exam_FlowControl_3();
			System.out.println("ef3 참조변수 주소값 >>> : " + ef3);
			
			int addSum = ef3.add(x, y);
			System.out.println("addSum >>> : " + addSum);

		}else{
			System.out.println("연산할 수를 잘 입력하시오 >>> : ");
		}
	}
}

/*
C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_FlowControl_3.java

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_3 1 2
ef2 참조변수 주소값 >>> : a.b.c.ch1.Exam_FlowControl_2@15db9742
addSum >>> : 3

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_3 1
연산할 수를 잘 입력하시오 >>> :

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_3
연산할 수를 잘 입력하시오 >>> :

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_3 1 2 3
연산할 수를 잘 입력하시오 >>> :

*/