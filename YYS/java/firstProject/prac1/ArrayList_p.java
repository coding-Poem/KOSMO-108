package a.b.c.prac1;

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;

public class ArrayList_p{
	public void arrayListTest_1(){
		ArrayList<HelloVO> aList = new ArrayList<HelloVO>();
		// ArrayList<HelloVO> 생성자를 new 키워드로 인스턴스한다.
		// 이 때 배열은 초기화 되어 배열의 size는 0, 배열은 [] : empty ArrayList가 된다.
		// aList는 지역변수이자 참조변수이다.
		// < > 는 제너레이션이다.
		// ArrayList<HelloVO>는 데이터는 HelloVO만 사용하라고
		// 제너레이션을 선언한 것이다.
		System.out.println("\n 1st for keyword \n");
		
		for (int i=0; i<3; i++) {
			HelloVO hvo = new HelloVO();
			// HelloVo 생성자를 new키워드로 인스턴스하였다.
			System.out.println("\n i >>> : "+i+", hvo 참조변수 주소값 >>>"+hvo);
			
			hvo.setMid("VELOG_ID"+i);
			hvo.setMpw("VELOG_PW"+i);
			hvo.setMname("JAVA_SERIES"+i);
			
			System.out.println("aList.size() >>> : "+aList.size());
			// aList.size() 의 size i+1개
			// i+1인 이유 배열은 인덱스가 0부터 시작되기 때문
			System.out.println("aList >>> : "+aList);
			// 참조변수의 주소값이 출력된다.
			aList.add(hvo);
			// 참조변수(HelloVO()) 주소값을 aList(ArrayList<HelloVO>())에 추가한다.
			// 배열에 하나의 데이터가 더 들어오는 것이다.
			System.out.println("\n After input hvo in ArrayList \n");
			System.out.println("aList.size() >>> : "+aList.size());
			System.out.println("aList >>> : "+aList);
			// hvo 참조변수 주소값이 ArrayList<HelloVO> 에 원소로 들어감
		}
		
		System.out.println("\n 2nd for keyword \n");
		
		for (int i=0; i<aList.size(); i++) {
			System.out.println("\n aList.get("+0+") >>> : "+aList.get(i));
			
			HelloVO _hvo =aList.get(i);
			System.out.print(_hvo.getMid()+" ");
			System.out.print(_hvo.getMpw()+" ");
			System.out.println(_hvo.getMname());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		new ArrayList_p().arrayListTest_1();		
	}

}
