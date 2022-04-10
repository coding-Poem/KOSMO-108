package a.b.c.prac1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class HashMap_p6 {
	public ArrayList<HashMap<String, String>> hasMapGeneric(){
		HashMap<String, String> hm0 = new HashMap<String, String>();
		hm0.put("이름","홍길동");
		hm0.put("번호","010");
		hm0.put("주소","대한민국 서울");
		
		HashMap<String, String> hm1=new HashMap<String, String>();
		hm1.put("이름","철수");
		hm1.put("번호","011");
		hm1.put("주소","대한민국 부산");
		
		HashMap<String, String> hm2=new HashMap<String, String>();
		hm2.put("이름","영희");
		hm2.put("번호","016");
		hm2.put("주소","대한민국 인천");
		
		ArrayList<HashMap<String, String>> aList=new ArrayList<HashMap<String, String>>();
		aList.add(hm1);
		aList.add(hm2);
		aList.add(hm2);
		
		return aList;
		
	}

	public static void main(String[] args) {
		HashMap_p6 hMap= new HashMap_p6();
		System.out.println("1. HashMap_p6 hMap= new HashMap_p6();");
		
		ArrayList<HashMap<String, String>> aList1=hMap.hasMapGeneric();
		System.out.println("2. ArrayList<HashMap<String, String>> aList1=hMap.hasMapGeneric();");
		System.out.println("3 .aList1.size >>> : "+aList1.size());
		
		for (int i=0; i<aList1.size(); i++){
			HashMap<String, String> hm=aList1.get(i);
			System.out.println("aList1.get(i) >>> : "+hm);
			Iterator<String> keys=hm.keySet().iterator();
			// String으로 담았기 때문에, 다운캐스팅을 쓸 필요가 없음
			// Set<K> 로 받음.
			// 이를 Iterator<E> 참조변수로 저장
			System.out.println("hm.keySet() >>> : "+hm.keySet());
			System.out.println("Iterator<String> keys >>> "+keys);
			
			while (keys.hasNext()){
				String key=keys.next();
				String value="";
				System.out.println("key >>> : "+key);
				if ("이름".equals(key)){
					value=hm.get(key);
					System.out.println("이름.equals(key) >>> : "+value+"\n");
				}
				if ("번호".equals(key)){
					value=hm.get(key);
					System.out.println("번호.equals(key) >>> : "+value+"\n");
				}
				if ("주소".equals(key)){
					value=hm.get(key);
					System.out.println("주소.equals(key) >>> : "+value+"\n");
				}
			}
		}

	}

}
