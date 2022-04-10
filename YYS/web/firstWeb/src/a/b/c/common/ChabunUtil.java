package a.b.c.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_T6 	= "T6"; 
	
	// type : 
	// D : YYYYMMDD 
	// M : YYYYMM 
	// Y : YYYY
	// N :  
								// t = d, c = 5			
	public static String numPad(String t, String c){
		System.out.println("4444 :: ChabunUtil.numPad() >>> :  t, c " + t + ", " + c);
	
		// c.length : 5 : 1 -> 4 : 0005
		// a : 1글자
		// 5: 1글자
		// 1 2 3
		// 5 -> 05 -> 005 ->0005
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
	
	public static String getT6Chabun(String type) {
		System.out.println("1111 :: ChabunUtil.getTestChabun() >>> :  type " + type);
		
				// 5
		String commNum = ChabunQuery.getT6ChabunQuery();	
		System.out.println("3333 :: ChabunUtil.getTestChabun() >>> :  commNum " + commNum);
		
		// ChabunUtil.getT6Chabun("d"); 
		
		// ChabunUtil.numPad(type, commNum) = 202203180005
		// BIZ_GUBUN_T6 : T
		// T202203180005
													// d   // 5
		return BIZ_GUBUN_T6.concat(ChabunUtil.numPad(type, commNum));
		// T6202203290005 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(">>> : " + ChabunUtil.getT6Chabun("d"));
		System.out.println(">>> : " + ChabunUtil.getT6Chabun("m"));
		System.out.println(">>> : " + ChabunUtil.getT6Chabun("y"));
		System.out.println(">>> : " + ChabunUtil.getT6Chabun("n"));
	}
}
