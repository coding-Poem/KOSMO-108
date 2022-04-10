package a.b.c.prac1;

import java.util.ArrayList;
import java.util.HashMap;


public class HashMap_p4 {
	public ArrayList hashMap(){
		System.out.println("2. ArrayList hasMap method 시작");
		
		HashMap hm0=new HashMap();
		System.out.println("3. 1st HashMap 생성 >>> : "+hm0);
		hm0.put("국가","한국");
		hm0.put("번호",82);
		hm0.put("수도","서울");

		HashMap hm1=new HashMap();
		System.out.println("4. 2nd HashMap 생성 >>> : "+hm1);
		hm1.put("국가","일본");
		hm1.put("번호",81);
		hm1.put("수도","도쿄");
		
		HashMap hm2=new HashMap();
		System.out.println("5. 3rd HashMap 생성 >>> : "+hm2);
		hm2.put("국가","중국");
		hm2.put("번호",86);
		hm2.put("수도","베이징");
		
		ArrayList aList=new ArrayList();
		aList.add(hm0);
		aList.add(hm1);
		aList.add(hm2);
		
		return aList;
	}
	
	//public ArrayList<HashMap<String, String>> hashMapGeneric(){
		
		
		
		
	//}
	
	public static void main(String[] args) {
		HashMap_p4 hp=new HashMap_p4();
		System.out.println("1. hp >>> : "+hp);
		
		ArrayList aList=hp.hashMap();
		System.out.println("aList.size() >>> : "+aList.size());
		
		for (int i=0; i<aList.size(); i++){
			HashMap hm=(HashMap)aList.get(i);
			// aList의 첫 번째 원소를 꺼내온다.
			// 클래스 형변환을 한다. 
			
			Object obj1=hm.get("국가");
			// 배열의 원소에 있는 HashMap의 국가 키를 Object클래스 obj1 참조변수로
			// 선언한다.
			String name1=(String)obj1;
			// 클래스 형변환을 해준다.
			System.out.println("국가 >>> : "+name1);
			
			Object obj2=hm.get("번호");
			// 배열의 원소에 있는HashMap의 번호 키를 Object클래스 obj2 참조변수로
			// 선언한다.
			Integer num1=(Integer)obj2;
			System.out.println("번호 >>> : "+num1);
			
			Object obj3=hm.get("수도");
			String city1=(String)obj3;
			// 배열의 원소에 있는HashMap의 수도 키를 Object클래스 obj2 참조변수로
			// 선언한다.
			System.out.println("수도 >>> : "+city1);
			System.out.println();
		}
		

	} // main method

} // HashMap_p4 class
