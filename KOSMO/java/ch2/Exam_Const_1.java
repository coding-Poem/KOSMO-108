package a.b.c.ch2;

/*
this	디스 키워드	
		자기 자신 클래스를 가르킨다.
		this.getClass().getName();
this()	디스 함수
		자기 클래스에서 오버로딩된 생성자를 가르킬 때 (호출할 때) 사용한다.
*/
public class Exam_Const_1 {

	String s;
	int i;

	// 프로그래머가 기본 생성자를 소스 코드에 작성했다.
	public Exam_Const_1() {
		// this("김영하", 22);
		System.out.println("Exam_Const_1() 생성자 >>> : ");
		System.out.println("Exam_Const_1() 생성자 >>> s ::: " + s);
		System.out.println("Exam_Const_1() 생성자 >>> i ::: " + i);
	}

	public Exam_Const_1(String s, int i) {
		/*
				this() :	디스 함수는 생성자 블럭 안에서 꼭 첫 번째 문장으로 수행 되어야 한다.
			 				디스 함수는 생성자 블럭 안에서 사용한다.
							클래스 내부에 오버로드되어 overload 선언된 생성자를 호출한다.
				constructor overloading	:	생성자의 시그니처 signature 가 같고 매개변수가 다른 것 
				함수의 시그니처		: 접근제한자 수정자 리턴형 함수이름 
									[public | protected | default | private]
									[static | final]
									[void | 데이터자료형]
									함수이름 
									(매개변수)
				생성자 오버로딩		: 
				함수 오버로딩	: 
		*/
		// System.out.println("Exam_Const_1(String s, int i) 생성자 >>> : ");
		this();
		/*
		C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_Const_1.java
		Exam_Const_1.java:21: error: call to this must be first statement in constructor
						this();
							^
		1 error
		*/
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> : ");
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> s ::: " + s);
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> i ::: " + i);
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> this.s ::: " + this.s);
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> this.i ::: " + this.i);
		this.s = s;
		this.i = i;
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> this.s ::: " + this.s);
		System.out.println("Exam_Const_1(String s, int i) 생성자 >>> this.i ::: " + this.i);

	}

	// 매개변수가 2개 있는 생성자
	public static void main(String args[]) {
	
		/*
			1. Exam_Const_1 : 사용자정의 클래스 Exam_Const_1 를 사용하기 위해서 선언 했다.
			2. ec	: 선언한 Exam_Const_1 클래스를 사용하기 위해서 참조변수 ec 를 선언 했다.
			3. =	: 대입 연산자
			4. new	: 뉴 키워드, 뉴 인스턴스연산자, 뉴 연산자 
					: new 키워드 뒤에오는 생성자 = 클래스이름 + () 메모리에 올려주세요 
					: 메모리에 올리는 것은 자바 버철머신이다.
			5. Exam_Const_1()	:	생성자 이다. 
								:	인스턴스하는 클래스의 멤버변수를 초기화 한다.
								:	default value 또는 생상자의 인수로 있는 변수 값으로 초기화 한다.
			6. Exam_Const_1() 생성자는 Exam_Const_1 소스 코드에서 작성된
				public Exam_Const_1() {} 기본 생성자를 호출한다.
				멤버 필드에 선언된 String s, int i 를 default value 로 초기화 한다.
		*/
		Exam_Const_1 ec = new Exam_Const_1();

		// 소스 코드상에서 매개변수가 2개 있는 생성자를 호출한다. 
		// public Exam_Const_1(String s, int i) {} 생성자를 호출한다.
		Exam_Const_1 ec_1 = new Exam_Const_1("신익현", 26);

	}
}
