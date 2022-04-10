package a.b.c.prac1;

import java.util.HashMap;
import java.util.Iterator;

// HashMap과 Iterator는 java.util에 있으므로,
// import 해준다.


public class HashMap_p5 {

	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("이름","홍길동");
		hm.put("번호","010");
		hm.put("주소","대한민국");
		String name=hm.get("이름");
		String num=hm.get("번호");
		String addr=hm.get("주소");
		
		System.out.println("HashMap에 입력한 이름, 주소, 번호 확인해보기 \n");
		System.out.println("이름 >>> : "+name);
		System.out.println("번호 >>> : "+num);
		System.out.println("주소 >>> : "+addr);
		
		// Iterator 이터레이터 : 자료를 순차적으로 접근할 수 있도록 처리하는 객체 : 반복자
		Iterator keys = hm.keySet().iterator();
		
		// keySet() : Returns a Set view of the keys contained in this map.
		System.out.println("hm.keySet() >>> : "+hm.keySet());
		// 말 그대로 키들의 집합인데,
		// HashMap의 구조는 ArrayList와 다르게 index의 순서가 없음.
		// 따라서, 이름, 번호, 주소 순서대로 키값이 집합이 되는 것이 아니라,
		// 키 들을 집합으로 묶는 것이라 순서대로 묶이지 않을 수도 있음.
		// 중요한 것은 키를 셋으로(집합) 묶을 수 있다는 것임.
		
		System.out.println("Iterator keys >>> : "+keys);
		
		// Iterator 참조변수 keys를 이용해서 이터레이터에 들어 있는 데이터를
		// hasNext() 함수로 확인한다.
		// has : 커서 함수 깜빡거리면서 true, false인지 확인하는 작업
		// Next : 다음 걸로 넘어가게 해주는 키워드
		// hasNext() : 다음걸로 넘어가며, 커서함수를 깜빡이며, true인지 false인지 확인한다.
		// has와 Next는 둘이 한 세트
		
		while (keys.hasNext()){
			String key=(String)keys.next();
			// HashMap은 Object이기 때문에 다운 캐스팅을 해주어야 한다.
			System.out.println("\n while(keys.hasNext()) 안의 key >>> : "+key);
			String value="";
			System.out.println("value 초기화 >>>> : "+value+"\n");
			// value를 출력하기 전에 초기화 해놓는다.
			if ("이름".equals(key)){
				// 이름과 key가 같다면 if 조건문을 실행하라
				value=(String)hm.get(key);
				System.out.println("이름.equals(key) >>> : "+value+"\n");
			}
			if ("번호".equals(key)){
				value=(String)hm.get(key);
				System.out.println("번호.equals(key) >>> : "+value+"\n");
				
			}
			if ("주소".contentEquals(key)){
				value=(String)hm.get(key);
				System.out.println("주소.equals(key) >>> : "+value+"\n");
			}
			System.out.println(key+ " : " + value);
		}	
	}
}
