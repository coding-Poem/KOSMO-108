package a.b.c.prac1;

import java.lang.reflect.Method;

public class ForName_p1 {
	public void classForName(){
		try {
			Class cl = Class.forName("a.b.c.prac1.ForNameSample");
			System.out.println("\n 1. cl >>> : "+cl);
			ForNameSample fs=(ForNameSample)cl.newInstance();
			System.out.println("\n 2. ForNameSample fs >>> : "+fs);
			System.out.println("\n 3. fs.aM()");
			fs.aM();
			System.out.println("\n 4. fs.bM()");
			fs.bM();
			System.out.println("\n 5. fs.cM()");
			fs.cM();
		
			// 클래스에 선언된 메소드 찾기
			Method m[]=cl.getDeclaredMethods();
			for (int i=0; i<m.length; i++){
				String findM=m[i].getName();
				System.out.println("\n m["+i+"].getName() >>> :: "+findM);
			}
		
			Class d=Class.forName("java.util.Date");
			java.util.Date dd=(java.util.Date)d.newInstance();
			System.out.println("\n 6. dd >>> : "+dd);
		
			Class aList=Class.forName("java.util.ArrayList");
			java.util.ArrayList aList_1=(java.util.ArrayList)aList.newInstance();
			// java.lang은 기존 내장이지만
			// java.util.클래스이름은 패키지가 다르므로
			// import 해서 사용해야 한다.
			// 그러나, Class.forName과 newInstance()으로
			// 하지 않아도 된다.
			
			System.out.println("\n 7. aList_1 >>> : "+aList_1);
			}catch(Exception e){
				System.out.println("\n 8. 에러 >>> : "+e);
			}
		}

	public static void main(String[] args) {
		new ForName_p1().classForName();
		// throws 사용 안 해도 잘 돌아감.
	}
}
