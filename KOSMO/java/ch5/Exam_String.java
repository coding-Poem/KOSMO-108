package a.b.c.ch5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_String {
	// 상수 
	public static final String MEMBER_NUM = "M";
	public static final String BOARD_NUM = "B";
	
	public static String mNum(String nCnt) {
		
		int nn = nCnt.length();
		
		for (int i = nn; i < 4; i++) {
		
			nCnt = "0" + nCnt;
		}		
		
		return nCnt;
	}
	
	public static String mNum_1(String nCnt) {
		
		int nn = nCnt.length();
		
		if (1 == nn) {
			nCnt = "000" + nCnt;
		}else if (2 == nn){
			nCnt = "00" + nCnt;
		}else if (3 == nn){
			nCnt = "0" + nCnt;
		}
				
		return nCnt;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 202107230001 : 회원번호 만들기 : 년월일 + 시퀀스 (0001 ~ 9999)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		String d = sdf.format(new Date());
		System.out.println("d >>> : " + d);
		
		String mnum = "";
		String nCnt = "";
		
		for (int i=1; i < 1001; i++) {
			
			nCnt = String.valueOf(i);
			
			mnum = 	  Exam_String.MEMBER_NUM // M
					+ d // 20220224
					+ Exam_String.mNum_1(nCnt);
			
			System.out.println("mnum >>> : " + mnum);			
		}
	}

}
