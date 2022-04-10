package a.b.c.prac1;

public class ForNameSample {
	// 기본 생성자
	ForNameSample(){
		System.out.println("ForNameSample 기본 생성자 ");
		aM();
	}
	
	void aM(){
		System.out.println("ForNameSample 클래스의 aM() 메서드");
		bM();
	}
	
	void bM(){
		System.out.println("ForNameSample 클래스의 bM() 메서드");
		cM();
	}
	
	void cM(){
		System.out.println("ForNameSample 클래스의 cM() 메서드");
	}
	

	public static void main(String[] args) {
		new ForNameSample();
	}
}
