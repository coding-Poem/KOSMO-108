package a.b.c.prac1;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMap_p1 {

	public static void main(String[] args) {
		/*
		 * 
		 * 제너릭 에서의 타입 : 제너릭에서 선언한 Object의 역할을 타입이라고 한다.
		 * 
		 *	<T> : Type
		 *	<E> : Element
		 *	<K> : Key
		 *	<V> : Value
		 *	<N> : Number
		 *
		 *	public V put (K key, V value) // jdk 1.8 // 두 번째 오는 매개변수가 리턴형이다.
		 *  public V get(Object Key) // Value 리턴형을 받는다.
		 * 
		 * 	public Object put(Object Key, Object value)
		 *  public Object get(Object Key)
		 * 
		 * */
	

		// ArrayList의 경우
		int idx=0;
	
		ArrayList aList = new ArrayList();
		for (int val=100; val<110; val++){
			aList.add(val);
		}
		System.out.println("aList >>> : "+aList+"\n");
		
		for (idx=0; idx<10; idx++){
			System.out.println("aList의  index(key) ="+idx+": value="+aList.get(idx));
		}

		
		// HashMap의 경우
		HashMap hMap=new HashMap();
		
		hMap.put("사과","apple");
		hMap.put("바나나","banana");
		hMap.put("멜론","melon");
		hMap.put("복숭아","peach");
		
		/*
		System.out.println("\n 사과는 영어로 >>>> : "+hMap.get("사과"));
		// apple
		
		System.out.println("\n 바나나는 영어로 >>>> : "+hMap.get("바나나"));
		System.out.println("\n 멜론은 영어로 >>>> : "+hMap.get("멜론"));
		System.out.println("\n 복숭아는 영어로 >>>> : "+hMap.get("복숭아"));
		*/
		
		hMap.put("사과","맛있다.");
		
		// System.out.println("\n Value로 apple에서 맛있다 입력 후 , 사과는 >>>> : "+hMap.get("사과")+"\n");
		// 새로운 값을 넣으니까 apple이 아니라 맛있다가 출력됨.
		// 맛있다.
		

		// HashMap은 index가 없다.
		
		idx=0;
		for(idx=0; idx<=3; idx++){
			System.out.println("hMap의 "+idx+"번째 값 >>> "+hMap.get(idx));
			// 전부 null로 출력된다.
		}
		
		System.out.println("\n HashMap은 Key로 찾아야한다.\n");
		
		// 출력하고 싶으면 키를 순차적으로 저장하여 출력한다.
		String[] sList={"사과","바나나","멜론","복숭아"};
		
		
		idx=0;
		String s="";
		for(idx=0; idx<=3; idx++){
			s=sList[idx];
			System.out.println("hMap의 Key : "+s+"\n hMap의 Value : "+hMap.get(s));
		}

		
		// 맛있다. , banana, melon, peach 
	} // main method

} // HashMap_p1 class
