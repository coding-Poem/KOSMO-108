package a.b.c.codepoem;

import java.util.ArrayList;

import a.b.c.codepoemVO.CodingPoemVO;

public class CodingPoem {
	
	public int[] pickRandomNumber() {
		
		int  lo[]= null; 
		lo=new int[2];
		
		System.out.println("===========================================");
		for(int i=0; i<lo.length; i++) {
			int i1 = (int)((Math.random()*6)+1);
			
			System.out.println("무작위 숫자 뽑기");
			System.out.println("(int)(Math.random()*6)+1 :: i1 >>> : " +i1);
			
			lo[i] = i1;
			
			for(int j=0; j<i; j++) {
				System.out.println("for jjjj >>> : " + lo[j]);
				System.out.println("for iiii >>> : " + lo[i]);
				if(lo[i]==lo[j]) {
					System.out.println("중복 발생 >>> : " + lo[i] +" : "+ + lo[j]);
					i--;
					break;
				}
			System.out.println("\n\n\n");
			System.out.println("최종 결과 >>> : " +lo[0] +" : "+ lo[1]);
			System.out.println("===========================================\n");
			}
		}
		return lo;
	} 
	
	//사실 얘 필요없음. 왜 했지????
	public ArrayList<Integer> wrappingNumber(int[] arr) {
		ArrayList<Integer> aList = null;
		aList = new ArrayList<Integer>();
		System.out.println("===========================================\n");
		for(int i=0; i<arr.length; i++) {
			System.out.println("뽑은 숫자 넣기");
			System.out.println("li[i] >>> : " + arr[i]);
			aList.add(arr[i]);
			System.out.println("aList.length >>> : " + aList.size());
			}
		System.out.println("===========================================\n");
		return aList;
	}
	
	public CodingPoemVO pickPerson(ArrayList<Integer> arr, CodingPoemVO cpvo) {
		
		//밖에서 키인 된 값 = cpvo
		//랜덤번호 2개를 바인딩한 값을 담을 것 = _cpvo
		
		//랜덤번호 2개를 바인딩 한 값을 담을 _cpvo선언
		CodingPoemVO _cpvo = null;
		_cpvo = new CodingPoemVO();  
		
		String p1 = null; 
		String p2 = null; 
		String p3 = null; 
		String p4 = null; 
		String p5 = null; 
		String p6 = null; 
		
		//String p1 = "박건원";
		//String p2 = "강민";
		//String p3 = "김별";
		//String p4 = "박성훈";
		//String p5 = "성연재";
		//String p6 = "윤요섭";
		
		//여기서 2명을 뽑고 html에서 버튼 눌렀을 때, VO클래스에 있는 2명을 가져온다
		
		//이거 for문으로 만들 수 있을 것 같은데 어떻게 하지??
		
		//arr.get(0)
		if(arr.get(0)==1) {
			p1 = cpvo.getP1();
			_cpvo.setP1(p1);
		}
		if(arr.get(0)==2) {
			p2 = cpvo.getP2();
			_cpvo.setP2(p2);
		}
		if(arr.get(0)==3) {
			p3 = cpvo.getP3();
			_cpvo.setP3(p3);
		}
		if(arr.get(0)==4) {
			p4 = cpvo.getP4();
			_cpvo.setP4(p4);
		}
		if(arr.get(0)==5) {
			p5 = cpvo.getP5();
			_cpvo.setP5(p5);
		}
		if(arr.get(0)==6) {
			p6 = cpvo.getP6();
			_cpvo.setP6(p6);
		}
		
		//arr.get(1)
		if(arr.get(1)==1) {
			p1 = cpvo.getP1();
			_cpvo.setP1(p1);
		}
		if(arr.get(1)==2) {
			p2 = cpvo.getP2();
			_cpvo.setP2(p2);
		}
		if(arr.get(1)==3) {
			p3 = cpvo.getP3();
			_cpvo.setP3(p3);
		}
		if(arr.get(1)==4) {
			p4 = cpvo.getP4();
			_cpvo.setP4(p4);
		}
		if(arr.get(1)==5) {
			p5 = cpvo.getP5();
			_cpvo.setP5(p5);
		}
		if(arr.get(1)==6) {
			p6 = cpvo.getP6();
			_cpvo.setP6(p6);
		}
		System.out.println("보내는 VO에 담긴 p1 >>> : "+cpvo.getP1());
		System.out.println("보내는 VO에 담긴 p2 >>> : "+cpvo.getP2());
		System.out.println("보내는 VO에 담긴 p3 >>> : "+cpvo.getP3());
		System.out.println("보내는 VO에 담긴 p4 >>> : "+cpvo.getP4());
		System.out.println("보내는 VO에 담긴 p5 >>> : "+cpvo.getP5());
		System.out.println("보내는 VO에 담긴 p6 >>> : "+cpvo.getP6());
		
		//랜덤이 담긴 VO
		return _cpvo;
	}

	public static void main(String[] args) {

	}

}
