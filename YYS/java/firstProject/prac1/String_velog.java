package a.b.c.prac1;

import java.util.StringTokenizer;

public class String_velog {	
	public int workToken(String str) {
		
		int tCnt = 0;
		
		if (str !=null && str.length() > 0 ) {
			StringTokenizer st = new StringTokenizer(str, " ");
			tCnt = st.countTokens();	
		}
		
		return tCnt;
	}
	
	public int charToken(String str){
		int cCnt = 0;
		
		if (str !=null && str.length() > 0){
			
			StringTokenizer st = new StringTokenizer(str, " ");
			
			while (st.hasMoreTokens()) {
				System.out.println(">>> : " + st.nextToken());
				cCnt++;
			}
			// 반드시 hasMoreTokens()와 nextToken()는 짝궁으로 써야한다. (API참고) 
		}
		return cCnt;
	}	
	

	public static void main(String[] args) {
		String str = "The Curious Case of Benjamin Button";
		String_velog sv = new String_velog();
		
		int tCnt = sv.workToken(str);
		System.out.println("tCnt >>> : " + tCnt);
		
		int cCnt =sv.charToken(str);
		System.out.println("cCnt >>> : "+cCnt);
	}
}