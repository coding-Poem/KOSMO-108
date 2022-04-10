package a.b.c.prac1;

//import java.util.StringToTokenizer;

public class String_p4 {

	public void charSplit(String sVal){
		System.out.println("charSplit 함수 시작");
		if (sVal !=null && sVal.length()>0){
			sVal=sVal.replace('#', ' ');
			// #을 빈공간으로 바꾼다.
			// 주의해야 할 것은 char, char로 인수를 입력해야 한다.
				
			String sChar[]=sVal.split(" ");
			
			System.out.println("sChar.length >>> : "+sChar.length);
			for (int i=0; i<sChar.length; i++){
				String s=sChar[i];
				System.out.println("sChar["+i+"] >>> : "+s);
			}
		}
		
		
	}
	
	public static void main(String []args) {
		System.out.println("main 함수 시작");
		String sVal="A BC#D EF#G HI#J KL#M NO";
		System.out.println("sVal >>> : "+sVal);
		//String_p4 rv=new String_p4();
		

		
		

	} // main method

} // String_p4 class
