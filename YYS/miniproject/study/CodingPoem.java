package a.b.c.study;

import java.util.ArrayList;

public class CodingPoem {
	public ArrayList<String> random(ArrayList<String> aList){
		// 3. return 받을 배열 만들어놓기
		ArrayList rList=new ArrayList();
				
		//  String 초기화
		String s="";
		String s1="";
		
		for(int i=0; i<2; i++){
			// 0부터 5까지 정수로 반환 받기
			int r=(int)(Math.random()*6);
			
			/* ######  i가 0일때는 수행되지 않는 지역 ####### */
			if(i==1){
				// i가 1일 때, i가 0 일때 당첨자와 같지 않도록 확인해줍니다.
				
				s1=aList.get(r);
				// aList.get(r)로 random 숫자인 r번째 배열의 값을 s1에 대입합니다.
				
				if(s.equals(s1)){
					// 새로 대입된 s1값과 이전 값인 s가 같은 경우에만 수행되는 로직입니다.
					System.out.println("똑같아요 ㅠㅠ  >>> : "+aList.get(r));
					if(r==5) {
						// 배열의 마지막 인덱스가 5이므로, r=0으로 0번째 인덱스 값을 출력시키기 
						// 위한 로직
						r=0;
					}else{
						r=r+1;
						// r이 5가 아닐 경우, 그 다음 사람을 출력시키기 위한 로직
					}
				}
			}
			/* ######################################### */
			
			// System.out.println("당첨자 >>> : "+aList.get(r));
			
			s=aList.get(r);
			// aList의 r번재 값은 s로 저장합니다.
			
			rList.add(s);
			// rList에 당첨자를 추가시킵니다.
		}
		return rList;
	}
	
	/*
	public static void main(String[] args) {
		ArrayList<String> aList=new ArrayList();
			//{"윤요섭","박건원","강민","김별","성연제","박성훈"};	
		
		// 1. coding-Poem 스터디 구성원 배열에 추가하기
		aList.add("윤요섭");
		aList.add("박건원");
		aList.add("김별");
		aList.add("성연제");
		aList.add("박성훈");
		aList.add("강민");
		
		// 2. random함수로 배열을 리턴받아옵니다.
		ArrayList rList=random(aList);
		
		if(rList!=null && rList.size()>0) {
			// rList가 null이 아니고, rList.size가 0보다 클 경우에만 수행시킵니다.
		    for(int r=0; r<rList.size(); r++){
		    	System.out.println("다음주 "+(r+1)+"번째 당첨자 >>> : "+rList.get(r));
		    	// 반복문으로 1번째, 2번째 당첨자를 출력시킵니다.
		    	}
		}else{
			System.out.println("배열을 못받아왔어요 >>> : "+rList);
		}
	}
	*/
}
