package a.b.c.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_T6 	= "T6"; 
	public static final String BIZ_GUBUN_M 	=  "M";
	
	// type : 
	// D : YYYYMMDD 
	// M : YYYYMM 
	// Y : YYYY
	// N :  
								// t = d,		
	public static String numPad(String t, String c){
		System.out.println("4444 :: ChabunUtil.numPad() >>> :  t, c " + t + ", " + c);
	
		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		                                       // d
		String ymd = DateFormatUtil.ymdFormats(t);
		// ymd = YYYYMMDD : 20220329
		System.out.println("6666 :: DateFormatUtil.numPad() >>> :  ymd " + ymd);
		
		// ymd.concat(c) : 202203290005
		return ymd.concat(c);
	}
	
											// d
	public static String getT6Chabun(String type) {
		System.out.println("1111 :: ChabunUtil.getTestChabun() >>> :  type " + type);
		
		String commNum = ChabunQuery.getT6ChabunQuery();	
		System.out.println("3333 :: ChabunUtil.getTestChabun() >>> :  commNum " + commNum);
		
		// ChabunUtil.getT6Chabun("d"); 
		
		// ChabunUtil.numPad(type, commNum) = 202203180005
		// BIZ_GUBUN_T6 : T
		// T202203180005
													// d   
		return BIZ_GUBUN_T6.concat(ChabunUtil.numPad(type, commNum));
		// T6202203290005 
	}
	
	public static String getMemChabun(String type) {
		System.out.println("1111 :: ChabunUtil.getMemChabun(String type) >>> :  type " + type);
		
				 
		String commNum = ChabunQuery.getMemChabunQuery();	
		System.out.println("3333 :: ChabunUtil.getMemChabunQuery(String type) >>> :  commNum " + commNum);
													// d   // 5
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, commNum));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(">>> : " + ChabunUtil.getMemChabun("d"));
		System.out.println(">>> : " + ChabunUtil.getMemChabun("m"));
		System.out.println(">>> : " + ChabunUtil.getMemChabun("y"));
		System.out.println(">>> : " + ChabunUtil.getMemChabun("n"));
	}
}
