package a.b.c.ch1;


public class Exam_For_3 {

	public static void main(String args[]) {
		
		for (int i=0; i <= 10 ; i += 2 ){
			System.out.print(i + " ");
		}	
		System.out.println();

		for (int i=0; i <= 10 ; i += 3 ){
			System.out.print(i + " ");
		}	
		System.out.println();
		
		for (int i=10; i >= 0; i-- ){
			System.out.print(i + " ");
		}	
	}
}
/*
C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_For_3.java && java a.b.c.ch1.Exam_For_3
0 2 4 6 8 10
0 3 6 9
10 9 8 7 6 5 4 3 2 1 0
*/