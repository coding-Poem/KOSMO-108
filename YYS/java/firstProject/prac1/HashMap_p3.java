package a.b.c.prac1;

import java.util.HashMap;

public class HashMap_p3 {

	public static void main(String[] args) {
			HashMap hMap=new HashMap();			
			int idx=0;
			int idx_1=0;
			int val=0;
			int val_1=4;
			
			String s="";
			String s1="";
			
			// String.valueOf(idx);
			for (idx=0; idx<10; idx++){
				s=String.valueOf(idx);
				hMap.put(s, val);
				val++;
			}
			
			System.out.println("hMap >>> "+hMap);
			// hMap >>> {0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 
			// 6=6, 7=7, 8=8, 9=9}

			
			for (idx_1=6; idx_1<10; idx_1++) {
				s1=String.valueOf(idx_1);
				hMap.put(s1, val_1);
				val_1--;
			}
			System.out.println("hMap >>> "+hMap);
			// hMap >>> {0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 
			// 6=4, 7=3, 8=2, 9=1}
	
	} // main method

} // HashMap_p3 class
