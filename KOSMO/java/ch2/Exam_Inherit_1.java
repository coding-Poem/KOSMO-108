package a.b.c.ch2;

import a.b.c.ch2.aa.Class_A;

/*
super		슈퍼 키워드 :	상속 관계에 있는 부모 클래스의 자원을 가르킨다.
super()		슈퍼 함수 :	상속 관계에 있는 부모 클래스의 오버로딩된 생성자를 가르킨다.
						생성자 블럭 첫 번째 라인에서만 사용해야 한다. 

*/
public class Exam_Inherit_1 extends Class_A{


	public Exam_Inherit_1(){
		super();
		System.out.println("Exam_Inherit_1() 생성자 >>> : " + super.class_a_2());
		// System.out.println("Exam_Inherit_1() 생성자 >>> : " + super);	
		/*
		C:\00.KOSMO108\10.JExam\ch2>javac -d . E*1.java Class_A.java
		Exam_Inherit_1.java:11: error: '.' expected
                System.out.println("Exam_Inherit_1() 생성자 >>> : " + super);
		*/
	}

	public Exam_Inherit_1(String s){
		super(s);
		System.out.println("Exam_Inherit_1(String s) 생성자 >>> : " + s);
	}

	/*
	public String toString(){
		return "Class_A().toString() 함수 >>> : ";
	}
	*/
	
	@Override
	public String toString(){
		return "Exam_Inherit_1().toString() 함수 >>> : ";
	}
	
	// 어노테이션 Annotation
	@Override
	public void class_a_1(){
		// System.out.println("Class_A().class_a_1() 함수 >>> : ");
		System.out.println("Exam_Inherit_1().class_a_1() 함수 >>> : ");
	}

	public static void main(String args[]) {

		Exam_Inherit_1 ei1 = new Exam_Inherit_1();
		System.out.println("ei1 참조변수 주소값 >>> : " + ei1);
		System.out.println("ei1.toString() >>> : " + ei1.toString());
		System.out.println("ei1.getClass().getName() >>> : " + ei1.getClass().getName());		
		ei1.class_a_1();

		Exam_Inherit_1 ei2 = new Exam_Inherit_1("상속클래스 >>> : ");
		System.out.println("ei2 참조변수 주소값 >>> : " + ei2);
	}
}