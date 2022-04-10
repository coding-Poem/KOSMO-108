package a.b.c.ch1;

public class Exam_FlowControl_1 {

	public static void main(String args[]) {

		int x = 1;
		int y = 2;

		boolean xyBool = x < y;
		System.out.println("xyBool >>> : "+ xyBool);

		// if 문은 true  일 때만 수행된다.
		// ______________________________________________________
		// if 문의 소괄호 안의 표현식(산식)의 결과가 true 일 때만 수행된다.
		// ______________________________________________________
		// x < y, 1 < 2 의 연산이 잘 않될 경우의 수도 있다. 
		if (xyBool) {
			System.out.println("true");
		}

		if (x < y) {
			System.out.println("x < y >>> : true");
		}

		if (1 < 2) {
			System.out.println("1 < 2 >>> : true");
		}
	}
}