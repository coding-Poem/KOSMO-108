package a.b.c.ch5;
// 정규표현식은 1.4부터 지원한다.
import java.util.StringTokenizer;

public class Exam_String_2 {
	
	public void charSplit(String sVal){
		
		System.out.println("charSplit(String sVal) sVal >>> : " + sVal);

		if (sVal !=null && sVal.length() > 0){
			
			String sChar[] = sVal.split("@"); // 델리미터 delimiter, 구분자
			
			for (int i=0; i < sChar.length; i++ ){
				System.out.println("sChar["+i+"] >>> : " + sChar[i]);
			}
		}
	}
	
	public void charToken(String sVal){
		System.out.println("charToken(String sVal) sVal >>> : " + sVal);

		if (sVal !=null && sVal.length() > 0){
			
			StringTokenizer st = new StringTokenizer(sVal, "@^ |");
			
			while (st.hasMoreTokens()) {
				System.out.println(">>> : " + st.nextToken());
			}
			// 반드시 hasMoreTokens()와 nextToken()는 짝궁으로 써야한다. (API참고) 
			
			for (int i=0; st.hasMoreTokens(); i++ ){
				System.out.println(i + "번째 : " + st.nextToken());
			}
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sVal = "a b^c,d ef,g|h^i,jk|l,m^no";
		System.out.println("sVal >>> : " + sVal);
		
		sVal = sVal.replace(',', '@');
		System.out.println("sVal >>> : " + sVal);	
		
	
		Exam_String_2 ex2 = new Exam_String_2();
		ex2.charSplit(sVal);
		ex2.charToken(sVal);
	
	}
}
