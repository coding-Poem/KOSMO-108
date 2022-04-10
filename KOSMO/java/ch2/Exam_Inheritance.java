package a.b.c.ch2;

class A_4 extends java.lang.Object{

	// 생성자
	A_4(){
		System.out.println("A_4() 생성자 >>> : ");
	}

	void a_4(){
		System.out.println("A_4().a_4() 함수 >>> : ");
	}
}

class A_3 extends A_4 {

	// 생성자
	A_3(){
		System.out.println("A_3() 생성자 >>> : ");
	}

	void a_3(){
		System.out.println("A_3().a_3() 함수 >>> : ");
	}
}

class A_2 extends A_3 {

	// 생성자
	A_2(){
		System.out.println("A_2() 생성자 >>> : ");
	}

	void a_2(){
		System.out.println("A_2().a_2() 함수 >>> : ");
	}
}

// A_2 부모 클래스 , A_1 자식 클래스 
class A_1 extends A_2 {

	// 생성자
	A_1(){
		System.out.println("A_1() 생성자 >>> : ");
	}

	void a_1(){
		System.out.println("A_1().a_1() 함수 >>> : ");
	}

}

public class Exam_Inheritance {

	public static void main(String args[]) {
	
		Exam_Inheritance ei = new Exam_Inheritance();
		System.out.println("ei 참조변수 주소값 >>> : " + ei);
		//ei.a_1();
		/*
		C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Inheritance.java
		Exam_Inheritance.java:35: error: cannot find symbol
						ei.a_1();
						  ^
		  symbol:   method a_1()
		  location: variable ei of type
		*/

		/*
		1.	A_1 클래스를 사용하려고 클래스를 선언한다.
		2.	참조변수 a1 을 선언한다.
		3.	= 대입 연산자
		4.	new 연산자를 보고 jvm 생성자 A_1()을 찾아서 
			해당 객체를 메모리 올리고 A_1() 생성자는 멤버변수를 초기화 한다. 
		5.	A_1() 객체를 찾아서 메모리에 올리려고하는데 A_2 클래스를 상속하고 있다.
			class A_1 extends A_2
		6. jvm 은 A_1() 클래스 그냥 두고 A_2() 클래스를 메모리에 올리려고 하는데
			A_3 클래스를 상속하고 있다.
			class A_2 extends A_3 
		7. jvm 은 A_2() 클래스 그냥 두고 A_3() 클래스를 메모리에 올리려고 하는데
			A_4 클래스를 상속하고 있다.
			class A_3 extends A_4
		8.	jvam 은 A_4 클래스를 찾아서 Default 로 상속하고 있는 java.lang.Object 클래스를 
			메모리에 올리고 넛 
		9. A_4 클래스를 찾아서 메모리에 올리고 순차적으로 상속 당한 클래스를 메모리에 올린다.			
		*/
		A_1 a1 = new A_1();
		System.out.println("a1 참조변수 주소값 >>> : " + a1);
		a1.a_1();
		a1.a_2();
		a1.a_3();
		a1.a_4();
	}
}