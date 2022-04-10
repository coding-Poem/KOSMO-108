package a.b.c.ch2;


class Interface_B_Impl implements Interface_B{
								  
	public void inter_b(){
		System.out.println("Interface_B_Impl.inter_b() 함수 실행");
	}
}

interface Interface_B {
	
	public void inter_b();
}

class Interface_A_Impl implements Interface_A{

	public void inter_a(){
		System.out.println("Interface_A_Impl.inter_a() 함수 실행");
	}
}

interface Interface_A {
	
	public void inter_a();
}

public class Exam_Interface  {

	public static void main(String args[]) {
		
		// 부모_인터페이스클래스 선언 참조변수 = new 자식클래스();
		Interface_A ia = new Interface_A_Impl();
		ia.inter_a();

		// 자식클래스선언 참조변수 = new 자식클래스();
		Interface_A_Impl iai = new Interface_A_Impl();
		iai.inter_a();
	}
}