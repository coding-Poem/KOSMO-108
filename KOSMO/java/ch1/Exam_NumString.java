package a.b.c.ch1;

public class Exam_NumString {

	public static void main(String args[]) {
	
		// 문자 숫자 : 숫자를 문자열로 표현한 것 : 숫자를 떠블 쿼테이션으로 몪은 것 
		String sX = "1";
		String sY = "2";

		System.out.println(sX + sY);

		int iX = Integer.parseInt(sX);
		int iY = Integer.parseInt(sY);
		System.out.println(iX + iY);
		System.out.println("문자열 더하기 하면 숫자도 문자열이 된다. >>> : ");
		System.out.println("" + (iX + iY));
		System.out.println("" + iX + iY);

	}
}