package a.b.c.ch2.aaaa;

/*
인터페이스 interface 
	1.	생성자를 가질수 없다.
	2.	new 연산자로 인스턴스 할 수 없다.
	3.	함수는 모두 추상함수이다. abstract 키워드가 생략 된 형태이다.
		함수는 굳이 abstarct 키워드를 사용하지 않는다.
	4.	변수는 모두 상수이다.
		변수는 굳이 static final 키워드를 사용하지 않는다.

	5.  static 함수 가능 
	6.	default 함수 가능 
*/
public interface Exam_Inter {

	//public String str;
	/*
	C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Inter.java
	Exam_Inter.java:13: error: = expected
			public String str;
							 ^
	1 error
	*/
	public /* static final 생략된 것이다. */String str = "난 상수이다";
	public static final String STR = "난 상수이다";
	/*
	클래스에서 기본 메소드를 찾을 수 없습니다. 다음 형식으로 기본 메소드를 정의하십시오.
    public static void main(String[] args)
    */

	// 생성자
	/*
	public  Exam_Inter() {
		
	}
	*/

	// 인터페이스 클래스 new 연산자로 인스턴스 하기 
	// Exam_Inter ei = new Exam_Inter();
	public /*abstract 키워드 생략*/ void aM();
	public abstract void bM();
}

/*
package a.b.c.ch2.aaaa;
public interface Exam_Inter {

}

C:\00.KOSMO108\10.JExam\ch2>javap a.b.c.ch2.aaaa.Exam_Inter
Compiled from "Exam_Inter.java"
public interface a.b.c.ch2.aaaa.Exam_Inter {
}
*/

/*
package a.b.c.ch2.aaaa;
public interface Exam_Inter {

	// 생성자 
	public Exam_Inter() {
		
	}
}

C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Inter.java
Exam_Inter.java:7: error: <identifier> expected
        public Exam_Inter() {
                         ^
1 error
*/

/*
public interface Exam_Inter {
	// 인터페이스 클래스 new 연산자로 인스턴스 하기 
	Exam_Inter ei = new Exam_Inter();
}

C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Inter.java
Exam_Inter.java:18: error: Exam_Inter is abstract; cannot be instantiated
        Exam_Inter ei = new Exam_Inter();
                        ^
1 error
*/