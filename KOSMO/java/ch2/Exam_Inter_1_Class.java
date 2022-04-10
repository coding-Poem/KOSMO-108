package a.b.c.ch2.aaaa;

/*
상속 : 부모 자식
부모 : Exam_Inter_1 인터페이스 클래스 
자식 : Exam_Inter_1_Class 클래스 
*/

/*
상속 관계에서 인스턴스 하는 방법 4가지가 있다.
2번 사용하기
1. 자식클래스 참조변수 = new 자식클래스()
2. 부모클래스 참조변수 = new 자식클래스()

3, 4번은 해당사항 없음
3. 부모클래스 참조변수 = new 부모클래스()
4. 자식클래스 참조변수 = new 부모클래스();
*/


public class Exam_Inter_1_Class implements Exam_Inter_1, Exam_Inter_3{

	@Override
	public /*abstract 키워드 생략*/ void aM(){
		System.out.println("Exam_Inter_1 인터페이스에서 오버라이딩 해서 aM() {}  블럭을 만들고 재정의 하는 함수이다.");				
	}

	
	@Override
	public /* abstract */ void bM(){
		System.out.println("Exam_Inter_1 인터페이스에서 오버라이딩 해서 bM() {}  블럭을 만들고 재정의 하는 함수이다.");		
	}

	// 인터페이스 클래스에서 가져온 함수를 재정의해야 한다. 
	// 재정의 하라는 것은 {} 블럭 브레이스를 만들라는 뜻이다.
	// {} 블럭 내부에 원하는 내용을 기술 한다. 
	// 구현체를 만든다. 실현한다. Implemetation
	// 오버라이딩 한 함수에서 abstract 키워드를 제거하고 {} 블럭을 만든다.
	// public abstract void cM();
	@Override
	public /* abstract */ void cM() {
		System.out.println("Exam_Inter_1 인터페이스에서 오버라이딩 해서 cM() {}  블럭을 만들고 재정의 하는 함수이다.");
	}

	
	// 재정의 해야 한다.
	@Override
	public void dM(){
		System.out.println("Exam_Inter_2 인터페이스에 있는 추상함수이다.");
		System.out.println("Exam_Inter_1 인터페이스에 extends 키워드로 인터페이스 상속을 해주었다.");
		System.out.println("Exam_Inter_1 인터페이스에 dM() 함수를 오버라이딩 해주었다.");
		System.out.println("Exam_Inter_1_Class 클래스에서 오버라이딩해서 재정의 했다.");
	}
	
	// 재정의 해야 한다.
	@Override
	public void eM(){
		System.out.println("Exam_Inter_3 인터페이스에 있는 추상함수이다.");
	}
}
