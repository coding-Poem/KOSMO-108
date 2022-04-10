// 패키지 선언
package a.b.c.ch5;

//임포트 선언
import java.util.StringTokenizer;

// 클래스 선언
public class Exam_String_4 {
	
	// 상수 선언
	// 멤버변수 선언	
	// 생성자 선언
	// 함수 선언 
	public int wordSplit(String str) {
	
		int sCnt = 0;		
		
		// 문자열 검증 Validation
		if (str !=null && str.length() > 0 ) {
			
			String s[] = str.split(" ");
			
			sCnt = s.length;	
		}
				
		return sCnt;
		// return str.split(" ").length;
	}
	
	public int workToken(String str) {
		
		int tCnt = 0;
		
		if (str !=null && str.length() > 0 ) {
			StringTokenizer st = new StringTokenizer(str, " ");
			tCnt = st.countTokens();	
		}
		
		return tCnt;
		// return new StringTokenizer(str, " ").countTokens();
	}
	
	public int aCount(String str) {
		
		int aCnt = 0;

		if (str !=null && str.length() > 0 ) {
			
			for (int i=0; i < str.length(); i++) {
			
				if ('a' == str.charAt(i)) {
					
					aCnt++;
				}
			}			
		}
		
		return aCnt;
	}
	
	// main() 함수 선언 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "The Curious Case of Benjamin Button";
		Exam_String_4 es4 = new Exam_String_4();
		
		int sCnt = es4.wordSplit(str);
		System.out.println("sCnt >>> : " + sCnt);
		
		int tCnt = es4.workToken(str);
		System.out.println("tCnt >>> : " + tCnt);
		
		int aCnt = es4.aCount(str);
		System.out.println("aCnt >>> : " + aCnt);
	
	}
}
