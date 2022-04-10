//안녕 한 명은 문자열을 콘솔에 출력하는 자바 프로그램을 작성하세요.
// 프로그램 이름: HelloYYS.java
// 파일은 c:\\00.KOSMO108\10.JExam에 저장한다.


// 1. HelloYYS 자바소스 구성하기

/*
 콘솔 어플리케이션: main() 메인 함수로 시작하는 프로그램
 public statci void main(String args[]){} <--
 자바에서는 무조건 따라해야 한다. (변경할 수 없다.)
 바꾸는 순간 프로그램이 실행되지 않음.
 */

public class HelloYYS{
	public static void main(String args[]){
		System.out.println("안녕 윤요섭");	
	} 
}

/*
public 접근 제어자
static 객체들이 생성되고 이용되는 과정에서 메모리의 기억장소를 이용
하는데, 매번 객체들이 생기고 저장되고 참조하는 과정이 일어난다.
이 때, static은 메소드가 메모리에 인스턴스되는 공간의 주소가
모두 똑같음을 의미한다.
void: main() 메소드 안에서 작업을 처리하고 main을 호출한
호출자에게 반환활(리턴 값) 결과값이 아무 것도 없다는 것을 의미한다.
main(String args[]): main() 메소드는 모든 자바 어플리케이션
프로그램에서 꼭 들어가야 하는 문장이며, 컴파일하여 실행시킬 경우
자바 런타임 인터프리터가 제일 먼저 이 main() 메소드를 찾아
실행을 하는 곳이다. main() 메소드는 String args[]라는 한 개의
파라미터 값을 갖도록 정의되어 있다. (=String 배열형)
*/


//2. HelloYYS.java 파일 저장하기
//C:\00.KOSMO108\10.JExam\HelloYYS.java


//3. 컴파일하기
/*
콘솔(cmd 창) 에서 HelloYYS.java 파일이 있는 폴더 찾아가기
C:\00.KOSMO108\10.JExam > javac 명령어 한칸띠고 프로그램 찾아가기
C:\00.KOSMO108\10.JExam > javac HelloYYS.java
C:\00.KOSMO108\10.JExam > dir HelloYYS.class
*/


//4. 실행 하기

/*
C:\00.KOSMO108\10.JExam > java 명령어 프로그램이름만
C:\00.KOSMO108\10.JExam > java HelloYYS
안녕 윤요섭
*/



