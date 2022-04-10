package a.b.c.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_TEST 	= "T"; 
	public static final String T6_TEST="T6";
	
	// type : 
	// D : YYYYMMDD 
	// M : YYYYMM 
	// Y : YYYY
	// N : 
	public static String numPad(String t, String c){
		System.out.println("<<< :: ChabunUtil.numPad() >>> :  t, c " + t + ", " + c);
	
		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	public static String getTestChabun(String type) {
		System.out.println("ChabunUtil.getTestChabun(String type) >>> :  type : "+ type);
		
		String commNum = ChabunQuery.getTestChabunQuery();			
		System.out.println("ChabunUtil.getTestChabun() >>> :  commNum " + commNum);
		
		return BIZ_GUBUN_TEST.concat(ChabunUtil.numPad(type, commNum));
	}
	
	public static String getT6Chabun(String type){
		System.out.println("ChabunUtil.getT6Chabun(String type) >>> : type : "+type);
	
		String commNum=ChabunQuery.getT6ChabunQuery();
		System.out.println("ChabunUtil.getT6Chabun(String type) >>> :  commNum " + commNum);
		
		
		return T6_TEST.concat(ChabunUtil.numPad(type, commNum));
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(">>> : " + ChabunUtil.getTestChabun("d"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("m"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("y"));
		System.out.println(">>> : " + ChabunUtil.getTestChabun("n"));
	}
	*/
}
