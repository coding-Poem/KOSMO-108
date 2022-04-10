// 패키지는 자바소스 최 상단에 기술하기 
// 패기지 키워드 패키지명을 기술하고 문자종결 연산자로 ; (세미콜론) 문장을 종결해야 한다.
package a.b.c.d;

// 자바에서 사용하는 한줄 주석 
/*
	자바에서 사용하는 여러줄 주석 
	주석은 컴파일 과 실행에 아무 영향을 주지 않는다.
	주석 용도는 
	그 파일이 무엇을 하는지
	해당 기능이 무엇을 하는지 기술하는 것이다.
*/

/*
콘솔 어플리케이션 HelloPack_1.java 로 
	public static void main(String args[]){} 
	main() 함수로 시작하라고 하는 것이군 
콘솔에 "패키지는 디렉토리이다" 문자열을 출력 하시오 
	System.out.println("패키지는 디렉토리이다");
단 패키지는 a.b.c.d 를 사용한다.
	패키지는 자바소스 최 상단에 쓴다.
*/


public class HelloPack_1{

	public static void main(String args[]){
		
		System.out.println("패키지는 디렉토리이다");
	}
}

/*
C:\00.KOSMO108\10.JExam>javac -d "C:\00.KOSMO108\10.JExam" HelloPack_1.java

C:\00.KOSMO108\10.JExam>javap a.b.c.d.HelloPack_1
Compiled from "HelloPack_1.java"
public class a.b.c.d.HelloPack_1 {
  public a.b.c.d.HelloPack_1();
  public static void main(java.lang.String[]);
}

C:\00.KOSMO108\10.JExam>java a.b.c.d.HelloPack_1
패키지는 디렉토리이다
*/