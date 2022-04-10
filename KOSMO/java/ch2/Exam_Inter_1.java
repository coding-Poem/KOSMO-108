package a.b.c.ch2.aaaa;

// 인터페이스 하고 인터페이스를 상속할 때는 extends 키워드를 사용한다.
// 클래스에 인터페이스를 상속시킬 때 implements 키워드를 사용한다.
public interface Exam_Inter_1 extends Exam_Inter_2{

	public /* abstract 키워드 생략 */ void aM();
	public abstract void bM();
	public abstract void cM();
	// public void dM();
}

