package a.b.c.ch4;
// a.b.c.ch4는 클래스의 경로 

import java.util.ArrayList;
// java.lang 패키지가 아니므로 import 키워드
// import는 패키지가 다른 경우, 사용한다. (import 패키지.클래스이름;)
// ArrayList 배열클래스를 불러온다. (데이터 타입과 관련없이 어느 타입의 데이터도 집어넣을 수 있음).
import java.util.Scanner;
// java.lang 패키지가 아니므로 import 키워드
// Scanner 클래스를 불러온다. 
// A Scanner breaks its input into tokens using 
// a delimiter pattern, 
// which by default matches whitespace.

import a.b.c.ch3.HelloVO;
// a.b.c.ch3 패키지에 있는 HelloVO 크래스를 호출한다.
// 현재 패키지는 a.b.c.ch4이므로, 패키지가 다르기 때문에 호출해야한다.

public class LoginTest {
	// LoginTest는 클래스 이름
	
	public int loginTest(HelloVO hvo) {
		// loginTest는 LoginTest 클래스 안에 있는 함수 이름
		// 리턴형 키워드가 int라  인수도 int, 매개변수도 int,
		// 리턴값도 int여야 한다.
		// 구현부가  있는 함수이다.
		
		int nCnt = 0;
		// int 데이터 타입(기초자료형 4byte)에 nCt라는 변수를 0으로 초기화한다.
		
		LoginService ls = new LoginServiceImpl();		
		// LoginSerivce 인터페이스 클래스(LoginServiceImpl클래스의 부모 클래스)
		// 에 참조변수 ls를 선언한다.
		// 생성자는 LoginServiceImpl클래스에 기본생성자로 new 키워드를 통해 인스턴스한다.
		// JVM이 new 키워드를 보고 생성자를 생성한다.
		// 생성자는 멤버변수를 초기화 한다.
		
		ArrayList<HelloVO> aList = ls.loginTest(hvo);
		// ArrayList<HelloVO> 배열클래스에 aList 참조변수에
		// ls 참조변수의 loginTest 함수에 hvo인수를 넣는다.
		
		if (aList !=null && aList.size() > 0) {
		// 만약 aList가 null이 아니면서 동시에
		// aList의 size (배열의 길이)가 0보다 클때만 수행하도록 한다.
			
			for (int i=0; i < aList.size(); i++) {
				// int i를 for문 안에서 지정해주고, 0으로 초기화 한다.
				// 이 때 , i가 List 배열의 길이보다 작으면
				// i를 하나씩 증감하고, 그렇지 않으면  반복문을 중단한다.
				// ㅑ<aList.size()인 이유는 배열의 인덱스는 0부터 시작한다.
				// 따라서, i<=aList.size()가 아닌 i<aList.size()로 조건식을 구성한다.
				
				HelloVO _hvo = aList.get(i);
				// for문 구현부 내에서 aList의 i번째 원소를 HelloVO 클래스에 _hvo 참조변수에 대입힌다.
				
				if (   "KID".equals(_hvo.getMid().toUpperCase()) 
					&& "KPW".equals(_hvo.getMpw().toUpperCase())) {
					// 만약, "KID"와 _hvo 참조변수의 getMid()를 모두 대문자로 반환한게 같다면
					// 그리고 동시에 "KPW"와 _hvo.getMpw()를 모두 대문자로 반환한게 같다면
					// 조선문을 실행하도록 한다.
					// 이 때, _hvo.getMid는 HelloVO 클래스의  this.mid이고,
					// _hvo.getMpw는 HelloVO 클래스의 this.mpw 이다.
					
					nCnt++;
					// 해당 조건문이 True일 경우, nCnt 변수를 하나 증감한다.
				}
			}			
		}
		
		return nCnt;
		// public int loginTest(HelloVO hvo)의 리턴값으로
		// nCnt가 반환된다.
		// 만약  aList !=null && aList.size() > 0 이 True이고
		// "KID".equals(_hvo.getMid().toUpperCase()) 
		// && "KPW".equals(_hvo.getMpw().toUpperCase()))가 Ture이면
		// nCnt가 0으로 리턴되어 나오지않는다. 그러나 위의 조건문 소괄호 내의 내용이 하나라도 False라면
		// nCnt는 0으로 리턴되어 나온다.
	}
	
	
	public static void main(String[] args) {
		
		String mid = "";
		// mid 문자열의 변수를 초기화 한다.
		String mpw = "";
		// mpw 문자열의 변수를 초기화 한다.
		
		System.out.println("데이터를 입력하시오 >>> : ");
		// "데이터를 입력하시오 >>> : "를 출력시켜 보여준다.
		Scanner sc = new Scanner(System.in);
		// 입력된 값을 Scanner 클래스에 입력 후, new 키워드를 통해
		// JVM이 생성자를 인스턴스하게 만든다.
		// 이 때, Scanner 클래스에 sc 참조변수에 해당 내용을 대입한다.
		
		System.out.println("아이디 >>> : ");
		// "아이디  >>> : "를 출력시킨다.
		mid = sc.next();
		// sc 참조변수에 입력된 값을 String mid변수에 대입한다. 
		// String : next()
		// Finds and returns the next complete token from this scanner.
		// public String next()
		
		System.out.println("패스워드 >>> : ");
		// "패스워드 >>> : "를 출력시킨다.
		mpw = sc.next();
		// sc 참조변수에 입력된 다음 값을 String mpw 변수에 대입한다.
		
		
		HelloVO hvo = new HelloVO();
		// HelloVO 클래스에 기본 생성자를 인스턴스 한다음, HelloVO 클래스에 hvo 참조변수에 대입한다.
		// JVM이 new키워드를 보고 인스턴스한다.
		hvo.setMid(mid);
		// 참조변수 hvo는 매개변수가 없는 생성자기 때문에, 
		// 해당 클래스의 setMid 메서드에 mid를 인수로 넣어주어
		// HelloVO 클래스의 this.mid에 인수값을 대입한다.
		hvo.setMpw(mpw);
		// 참조변수 hvo는 매개변수가 없는 생성자기 때문에,
		// 해당 클래스의 setMpw 메서드에 mpw를 인수로 넣어주어
		// HelloVO 클래스의 this.mpw에 인수값을 대입한다.
			
		LoginTest lt = new LoginTest();
		// 현재, LoginTest에 기본 생성자를 new 키워드로 인스턴스 한다.
		// JVM이 new 키워드를 보고 생성자를 인스턴스한다.
		// LoginTest 클래스에 lt 참조변수에 생성된 기본생성자를 대입한다.
		
		// public int loginTest(HelloVO hvo)
		int nCnt = lt.loginTest(hvo);
		// 현재 클래스에서 생성된 lt 참조변수에 loginTest 메서드에
		// HelloVO 클래스에서 생성된 기본 생성자가 대입된 참조변수를 
		// 인수로 대입한 뒤, int nCnt에 이를 대입한다.
		System.out.println("nCnt >>> : " + nCnt);
		// nCnt를 출력시켜 로그를 찍어 확인한다.
		
		if (nCnt == 1) {
			// nCnt가 1일 경우, if 조건문을 실행하도록 한다.
			System.out.println("로그인 성공 >>> : ");
			// nCnt가 1일 경우, 로그인 성공을 출력시킨다.
		}else {
			System.out.println("로그인 실패 >>> : ");
			// nCnt가 1이 아닐 경우, 로그인 실패를 출력시킨다.
		}
			
	}
}
