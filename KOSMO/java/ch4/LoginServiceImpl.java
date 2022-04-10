package a.b.c.ch4;
//package는 클래스의 경로를 의미한다.
//a.b.c.ch4에 클래스가 있다.

import java.util.ArrayList;
//java.lang은 자바에 기본적으로 내장이 되어있지만
//java.util은 자바에 기본적으로 내장이 되어있지 않으므로 import 키워드로 불러온다.
//import 패키지.클래스이름;

import a.b.c.ch3.HelloVO;
// LoginServiceImpl 클래스는 a.b.c.ch4 패키지에 있으나,
// HelloVO 클래스는 a.b.c.ch3 패키지에 있다.
// 따라서, import 키워드로 호출하여 준다.

public class LoginServiceImpl implements LoginService {
// LoginService 인터페이스 클래스의 상속을 받은  LoginServiceImpl 클래스이다.
// 부모 클래스의 함수가 구현부가 없는 추상함수 여서, @Override 재정의 Annotation을 통해
// loginTest 함수에 구현부를 정의해주어야 한다.

	@Override
	public ArrayList<HelloVO> loginTest(HelloVO hvo) {
		//  매개변수에서 들어오는 HelloVO 클래스의 인수 배열을
		//  매개변수로 hvo로 초기화 해준다.
		
		
		// 비즈니스 로직을 거쳐서 데이터베이스에 다녀오는 로직이 들어올 예정이다.
		ArrayList<HelloVO> aList = null;
		// ArrayList<HelloVO> 클래스의 aList 참조변수를 초기화해준다. 
		aList = new ArrayList<HelloVO>();
		// new 키워드로 ArrayList<HelloVO> 클래스 생성자를 만들어 
		// 인스턴스한다. 이를  aList로 선언한다. 
		
		aList.add(hvo);
		// aList에 매개변수 hvo를 추가한다.
		
		return aList;
		// aList로 리턴하여 준다.
		
	}

}
