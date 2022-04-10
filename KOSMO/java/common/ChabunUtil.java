package a.b.c.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_TEST 	= "T"; 
	
	// type : 
	// D : YYYYMMDD 
	// M : YYYYMM 
	// Y : YYYY
	// N : 
	public static String numPad(String t, String c){
		System.out.println("4444 :: ChabunUtil.numPad() >>> :  t, c " + t + ", " + c);
	
		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	public static String getTestChabun(String type) {
		System.out.println("1111 :: ChabunUtil.getTestChabun() >>> :  type " + type);
		
		String commNum = ChabunQuery.getTestChabunQuery();			
		System.out.println("3333 :: ChabunUtil.getTestChabun() >>> :  commNum " + commNum);
		
		return BIZ_GUBUN_TEST.concat(ChabunUtil.numPad(type, commNum));
	}
	
	public static String getT6Chabun(String type){
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(">>> : " + ChabunUtil.getTestChabun("d"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("m"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("y"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("n"));
	}
}
