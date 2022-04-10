package a.b.c.ch1;

public class Exam_Boolean {

	boolean bVal;

	public static void main(String args[]) {
	
		boolean bool = false;
		System.out.println("bool >>> : " + bool);
		bool = true;
		System.out.println("bool >>> : " + bool);
		bool = false;
		System.out.println("bool >>> : " + bool);

		System.out.println("new Exam_Boolean() >>> : " + new Exam_Boolean());

		System.out.println("new Exam_Boolean().bVal >>> : " 
							+ new Exam_Boolean().bVal);

		Exam_Boolean eb = new Exam_Boolean();
		System.out.println("eb >>> : " + eb);
		System.out.println("eb.bVal >>> : " + eb.bVal);
	}
}