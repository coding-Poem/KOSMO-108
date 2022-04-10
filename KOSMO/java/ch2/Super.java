package a.b.c;

// Sub 부모클래스 
class Sub{

	public Sub(){
		System.out.println("Sub()  부모클래스 생성자 ");
	}

	public void subM(){
		System.out.println("subM()  함수 ");
	}
}

// Sub 부모클래스
// Super 자식클래스 
public class Super extends Sub{


	public void superM(){
		System.out.println("superM()  함수 ");
	}

	public Super(){
		System.out.println("Super()  자식클래스 생성자 ");
	}

	public static void main(String args[]) {

		// 부모클래스 참조변수 = new 부모클래스();
		// Sub s = new Sub();
		
		// 부모클래스 참조변수 = new 자식클래스();
		Sub ss = new Super();


	
	
		
	}
}