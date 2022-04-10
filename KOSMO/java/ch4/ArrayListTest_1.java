package a.b.c.ch4;

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;

// a.b.c.ch3.HelloVO.java

public class ArrayListTest_1 {

	
	public void arrayListTest_1() {
		
		// ArrayList aList = new ArrayList();
		
		// ArrayList 클래스를 선언 
		// 데이터는 HelloVO 만 사용하라고 제너레이션을 선언했다.
		ArrayList<HelloVO> aList = new ArrayList<HelloVO>();
		
		// for 문이 0 부터 3번 돈다.
		for (int i=0; i < 30; i++) {
			// 원래, 30000이였음.
			
			// HelloVO 클래스 인스턴스 한다.
			HelloVO hvo = new HelloVO();
			// HelloVO 클래스 참조변수 hvo 출력 
			System.out.println("\nhvo 참조변수 주소값 >>> : " + i  + " ::: " +  hvo + "\n");
			
			// hvo setter() 함수에 값 초기화 , 값 바인딩, 값 대입 
			hvo.setMid("CHEB_" + i);
			hvo.setMpw("CHEB00_" + i);
			hvo.setMname("차은비_" + i);
			
			// ArrayList 갯수 출력
			System.out.println("aList.size() >>> : " + aList.size());
			// ArrayList 참조변수 출력 
			System.out.println("aList >>> : " + aList);
			
			// ArrayList 에 aList 참조변수를  이용해서 add() 함수에 HelloVO 객체를 hvo 참조변수로 넣는다.
			// aList 참조변수가 가르키는 ArrayList 객체에  hvo 주소값이 바이딩된다.
			aList.add(hvo);
			// 문자열 출력 
			System.out.println("ArrayList 에 데이터 넣은 후 >>> : ");
			// ArrayList hvo 를 넣은 후 사이즈 출력 
			System.out.println("aList.size() >>> : " + aList.size());
			// ArrayList hvo 를 넣은 후  참조변수 출력 
			System.out.println("aList >>> : " + aList);
			
		}
		
		for (int i=0; i < aList.size(); i++) {
			System.out.println("aList.get(" + 0 + ") >>> : " + aList.get(i));
			
			HelloVO _hvo = aList.get(i);
			System.out.print(_hvo.getMid() + " ");
			System.out.print(_hvo.getMpw() + " ");			
			System.out.println(_hvo.getMname());			
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		new ArrayListTest_1().arrayListTest_1();
	}
}
