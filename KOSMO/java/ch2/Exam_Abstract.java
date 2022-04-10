package a.b.c.ch2;

// 추상 키워드 : abstract

// 추상 클래스 
// 추상 클래스 = 변수 + 추상함수 + 일반함수 
abstract class Class_Abstract_2 {

	abstract int add();
	abstract String eat();

	int add_1(){
		return 1;
	}
}


// 일반 클래스에서 추상 클래스를 상속하면
// 추상 클래스에있는 추상 함수를 꼭 오버라이딩 해서
// 오버라이딩 한 함수에 {} 블럭 브레이스를 붙여서
// 블럭 내부에 하고 싶은 작업을 하게 한다.
class Class_Abstract_1 extends Class_Abstract_2{
	
	int add() {
		return 1 + 2;
	}

	String eat(){
		return "Class_Abstract_1.eat() >>> : ";
	}
}

public class Exam_Abstract {

	public static void main(String args[]) {
		
		Exam_Abstract ea = new Exam_Abstract();
		System.out.println("ea 참조변수 주소값 >>> : " + ea);

		Class_Abstract_1 ca1 = new Class_Abstract_1();
		int add = ca1.add();
		System.out.println("add >>> : " + add);
		String eat = ca1.eat();
		System.out.println("eat >>> : " + eat);
	}
}