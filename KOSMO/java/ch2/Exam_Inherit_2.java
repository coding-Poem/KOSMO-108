package a.b.c.ch2;

class Class_부모 extends java.lang.Object{

	Class_부모() {
		System.out.println("Class_부모() 생성자 >>> : ");
	}

	void 부모_1(){
		System.out.println("Class_부모().부모_1() 함수 >>> : ");
	}
} 

class Class_자식 extends Class_부모{

	Class_자식() {
		System.out.println("Class_자식() 생성자 >>> : ");
	}

	void 자식_1(){
		System.out.println("Class_자식().자식_1() 함수 >>> : ");
	}

}

public class Exam_Inherit_2 {

	void examIn() {
		System.out.println("Exam_Inherit_2.examIn() 함수 >>> : ");
	}
	public static void main(String args[]) {
		
		Exam_Inherit_2 ei2 = new Exam_Inherit_2();
		// System.out.println("ei2 참조변수 >>> : " + ei2);
		// ei2.examIn();

		/*
			클래스(자원)을 사용하려고 상속관계에 있는 클래스를 인스턴스 했다.
			객체지향 프로그램에서는 2번 사용해야 한다.
			1. 자식클래스 참조변수 = new 자식클래스();
			2. 부모클래스 참조변수 = new 자식클래스();

			3, 4번은 사용하지 않느다.
			3. 부모클래스 참조변수 = new 부모클래스();
			4. 자시클래스 참조변수 = new 부모클래스();
		*/

		// 자식클래스 자식클래스_참조변수 = new 자식클래스();
		// 자식클래스_참조변수로 자식클래스에 있는 자원 및 부모 클래스에 있는 자원을 사용할 수 있다.
		Class_자식 자식_1 = new Class_자식();
		System.out.println("자식_1 참조변수 주소값 >>> : " + 자식_1);
		자식_1.자식_1();
		자식_1.부모_1();
		System.out.println("=======================\n");


		// 부모클래스 부모클래스_참조변수 = new 자식클래스();
		// 부모클래스_참조변수로는 자기자신 클래스의 자원만 사용이 가능하다. 
		Class_부모 부모_1 = new Class_자식();
		System.out.println("부모_1 참조변수 주소값 >>> : " + 부모_1);
		부모_1.부모_1();
		부모_1.자식_1();
	}
}