package a.b.c.ch4;
// package는 클래스의 경로를 의미한다.
// a.b.c.ch4에 클래스가 있다.

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;
// java.lang은 자바에 기본적으로 내장이 되어있지만
// java.util은 자바에 기본적으로 내장이 되어있지 않으므로 import 키워드로 불러온다.
// import 패키지.클래스이름;

public interface LoginService {
	// interface 클래스 
	// interface 클래스는 내부에 추상함수로만 이루어져 있다. (구현부가 없는 함수 )
	// 생성자를 생성할 수 없어, new 키워드로 생성자를 생성할 수 없다.
	// implements로 상속받는 자식 클래스와 한 세트이다.

	public ArrayList<HelloVO> loginTest(HelloVO hvo);
	// public 접근제한자
	// ArrayList<HelloVO> 리턴형키워드
	// ArrayList 데이터는 HelloVO 만 사용하라고 제너레이션을 선언했다.
	// hvo와 ArrayList<HelloVO>의 데이터 타입이 같아야 한다.
}
