package a.b.c.ch1;

/*
하기	main() 함수에 초기화 된 지역변수 5개를 16진수로 콘솔에 출력하시오 
단:	함수를 만들어서 main() 함수에서 각 함수를 호출해서 실행 시키시오
	콘솔에 16진수를 출력할 때는 0x 를 붙여서 출력하시오
함수 이름 toHex_S0(), toHex_S1(), toHex_S2(), toHex_S3(), toHex_S4()

16:45 까지 하기 
*/
public class Exam_For_6_1 {

	public void toHex_Str(String str) {
		System.out.println("Exam_For_6.toHex_S0() 함수 진입 >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}
	
	public static void main(String args[]) {
		
		// 영문자 소문자
		String s0 = "abcdefghijklmnopqrstuvwxyz";
		// 영문자 대문자 
		String s1 = s0.toUpperCase();
		// 숫자 
		String s2 = "0123456789";
		// 연산기호
		String s3 = "*+-/";
		// 특수 문자
		String s4 = "!@#%%^&*";

		if (args.length == 1){

			String s = args[0];
			s = s.toUpperCase();

			if ("A".equals(s)){
				new Exam_For_6_1().toHex_Str(s0);
			}
			if ("B".equals(s)){
				new Exam_For_6_1().toHex_Str(s1);
			}
			if ("C".equals(s)){
				new Exam_For_6_1().toHex_Str(s2);
			}
			if ("D".equals(s)){
				new Exam_For_6_1().toHex_Str(s3);
			}
			if ("E".equals(s)){
				new Exam_For_6_1().toHex_Str(s4);
			}
		}else{
			System.out.println(   "A : 영문자 소문자 \n"
								+ "B : 영문자 대문자 \n"
								+ "C : 숫자 \n"
								+ "D : 연산 기호 \n"
								+ "E : 특수 문자 \n"
								+ "를 입력하시오 ");

		}
	}
}
