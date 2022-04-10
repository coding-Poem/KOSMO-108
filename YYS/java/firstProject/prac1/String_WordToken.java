package a.b.c.prac1;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class String_WordToken {
	public void word_test_1(String str){
		System.out.println("word_test_1 시작");
		int si=0;
		int n=0;
		char c=' ';
		char c1=' ';
		boolean b=false;
		String s="";
		ArrayList aL=new ArrayList();
		
		si=str.length();
		System.out.println("str.length() >>> : "+si);
		
		for(int i=0; i<si; i++){
			c1=str.charAt(i);
			System.out.println("c1 >>> : "+c1);
			b= c1==' ';
			System.out.println("b >>> : "+b);
			if (b){
				s=str.substring(n,i);
				aL.add(s);
				n=i;
			}
		}
		
		System.out.println("aL.size() >>> "+aL.size());
		for (int k=0; k<aL.size(); k++){
			System.out.print(aL.get(k));
		}	
	} // word_test_1 method
	
	public void word_test_2(String str){
		System.out.println("word_test_2 시작");
		int si=0;
		int cnt=0;
		int fcnt=0;
		
		String s[]=null;
		if (str!=null && str.length() >0){
			s=str.split(" ");
			cnt=s.length;
			System.out.println("cnt >>> "+cnt);
		}
		
		StringTokenizer st=new StringTokenizer(str, " ");
		System.out.println("st >>> : "+st);
		fcnt=st.countTokens();
		System.out.println("fcnt >>> : "+fcnt);
		
	}

	public static void main(String[] args) {
		String str="The Curious Case of Benjamin Button";
		String_WordToken st=new String_WordToken();
		//st.word_test_1(str);
		st.word_test_2(str);
		

		
	} // main method

} // String_WordToken class
