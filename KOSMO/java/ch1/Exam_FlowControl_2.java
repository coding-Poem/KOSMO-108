package a.b.c.ch1;

public class Exam_FlowControl_2 {

	public int add(int x, int y) {		
		return x + y;
	}

	public static void main(String args[]) {

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);

		Exam_FlowControl_2 ef2 = new Exam_FlowControl_2();
		System.out.println("ef2 참조변수 주소값 >>> : " + ef2);
		
		int addSum = ef2.add(x, y);
		System.out.println("addSum >>> : " + addSum);
	}
}

/*
C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_2 1 2
ef2 참조변수 주소값 >>> : a.b.c.ch1.Exam_FlowControl_2@15db9742
addSum >>> : 3

*/