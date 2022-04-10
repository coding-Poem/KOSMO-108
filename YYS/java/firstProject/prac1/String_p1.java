package a.b.c.prac1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class String_p1 {
	public static final String MEMBER_NUM="M";
	public static final String BOARD_NUM="B";
	
	public static String mNum(String nCnt){
		int nn=nCnt.length();
		for (int j=nn; j<4; j++){
			//s=String.valueOf(j);
			nCnt="0"+nCnt;
			System.out.println("ÇöÀç nCnt >>>>>>>>>>>"+nCnt);
		}
		return nCnt;
	}

	
	public static String mNum_1(String nCnt){
		
		int nn=nCnt.length();
		System.out.println("mNum_1(String nCnt) nCnt.length(); >>>"+nn);
		
		if(1==nn){
			nCnt="000"+nCnt;
		}else if(2==nn){
			nCnt="00"+nCnt;
		}else if(3==nn){
			nCnt="0"+nCnt;
		}
		
		return nCnt;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("new SimpleDateFormat(yyyy-MM-dd) >>> "+sdf);
		String d=sdf.format(new Date());
		System.out.println("sdf.format(new Date()) >>> "+d);
		
		String mnum="";
		String nCnt="";
		
		for (int i=1; i<101; i++){
			nCnt=String.valueOf(i);
			mnum=String_p1.MEMBER_NUM+d+String_p1.mNum(nCnt);
			System.out.println("mnum >>> : "+mnum);
		}
		/*
		for (int i=1; i<101; i++){
			nCnt=String.valueOf(i);
			mnum=String_p1.MEMBER_NUM+d+String_p1.mNum_1(nCnt);
			System.out.println("mnum >>> : "+mnum);
		}
		*/
		
	} // main method 

} // String_p1 class
