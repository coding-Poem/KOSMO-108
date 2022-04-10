package a.b.c.prac1;

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;

public class ArrayList_p2 {
	public void arrayList_p_21(ArrayList<HelloVO> aList){
		// 매개변수로 ArrayList<클래스이름> 참조변수로 설정
		// aList => {{VELOG_0 VELOG00_0 벨로그_0},{VELOG_1 VELOG00_1 벨로그_1},{VELOG_2 VELOG00_2 벨로그_2}}
		System.out.println("\n aList.size() >>> : "+aList.size());
		// 3
		for (int i=0; i<aList.size(); i++) {
			// aList.size()
			System.out.println("aList.get("+i+") >>> : "+aList.get(i));
			// aList의 i번째 원소의 주소값 출력 {VELOG_i VELOG00_i 벨로그_i} 주소값 출력 
			
			
			HelloVO _hvo=aList.get(i);
			// aList의 i번째 원소를 HelloVO 클래스의 참조변수
			// String s="벨로그";
			// HelloVO 객체에 _hvo라는 변수로 지정
			// VELOG_i VELOG00_i 벨로그_i
			System.out.print(_hvo.getMid()+" ");
			System.out.print(_hvo.getMpw()+" ");
			System.out.println(_hvo.getMname());
		}
	}
	
	public void arrayList_p_22(String mid, String mpw, String mname){
		// 매개변수  mid, mpw, mname에
		// 들어온 인수로 초기화
		System.out.print(mid+" ");
		System.out.print(mpw+" ");
		System.out.println(mname);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// main 함수에서 mid, mpw, name 지정
		String mid="VELOG_";
		String mpw="VELOG00_";
		String mname="벨로그_";
		
		// ArrayList<HelloVO> 생성자를 만들어 new 키워드로
		// 인스턴스 후에, aList를 참조변수로 지정
		ArrayList<HelloVO> aList=new ArrayList<HelloVO>();
		
		for (int i=0; i<3; i++) {
			// HelloVO() 생성자를 만들어 new 키워드로
			// 인스턴스 후에, hvo를 참조변수로 지정
			HelloVO hvo = new HelloVO();
			
			hvo.setMid(mid+i);
			hvo.setMpw(mpw+i);
			hvo.setMname(mname+i);
			// 현재 for문 블록 밖에서
			// mid, mpw, mname을 지정했음
			// 지정한 멤버변수에 i를 더해서 세터메서드에 
			// 입력
			
			aList.add(hvo);
			// HelloVO() 생성자 참조변수
			// hvo의 주속값을 ArrayList<Hello>()
			// 생성자의 참조변수 aList에 추가
			// 쉽게 말해 배열에 원소를 추가하는 것		
		}
		
		ArrayList_p2 al2=new ArrayList_p2();
		System.out.println("\n al2.arrayList_p_21(aList); 실행");
		al2.arrayList_p_21(aList);
		// aList => {{VELOG_0 VELOG00_0 벨로그_0},{VELOG_1 VELOG00_1 벨로그_1},{VELOG_2 VELOG00_2 벨로그_2}}
		
		ArrayList_p2 al3=new ArrayList_p2();
		System.out.println("\n al3.arrayList_p_22(mid, mpw, mname); 실행");
		al3.arrayList_p_22(mid, mpw, mname);
	}
}