package a.b.c.ch2.scr;

// a.b.c.ch2.vo.MemberVO 에 있는 클래스를 
// a.b.c.ch2.scr.MemberScr 클래스에서 사용하려고 불러온다.

// 생성자를 만드는 규칙 
// 클래스이름 () {}
/*
	1. 클래스이름 선언 (내가 사용하려고 하는 클래스이름과 동일하게 선언한다).
	2. () 소괄호에 매개변수를 사용할 수 있다. 
	3. {} 블럭에서 클래스를 인스턴스 하면서 맨 먼저 해야할 함수(동작을) 선언한다.
	4. 생성자는 멤버변수를 초기화 한다.
*/
import a.b.c.ch2.vo.MemberVO;

// 회원가입 프로그램
public class MemberScr {
	
	public static void main(String args[]) {
		MemberVO mvo=new MemberVO();
		System.out.println("mov 참조변수 주소값 >>> : "+mvo);

		MemberVO mvo_1 = new MemberVO("HGD", "HGD00", "홍길동", "010-1234-5678","사랑시 행복구");
		System.out.println("mvo_1 참조변수 주소값  >>> : " + mvo_1);
	}
}
/*
a.b.c.ch2.vo.MemberVO  클래스를 import 하지 않고 컴파일 했을 때 에러가 발생한다.
-----------------------------------------------------------------------
C:\00.KOSMO108\10.JExam\ch2>javac -d . MemberScr.java MemberVO.java
MemberScr.java:9: error: cannot find symbol
                MemberVO mvo = new MemberVO();
                ^
  symbol:   class MemberVO
  location: class MemberScr
MemberScr.java:9: error: cannot find symbol
                MemberVO mvo = new MemberVO();
                                   ^
  symbol:   class MemberVO
  location: class MemberScr
2 errors
*/

/*
C:\00.KOSMO108\10.JExam\ch2>javac -d . M*.java

C:\00.KOSMO108\10.JExam\ch2>javac -d . M*r.java M*O.java
*/