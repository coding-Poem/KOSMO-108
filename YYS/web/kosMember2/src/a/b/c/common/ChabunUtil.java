package a.b.c.common;

public abstract class ChabunUtil {
	public static final String BIZ_GUBUN_MEMBER="M";
	
	public static String numPad(String t, String c){
		for(int i=c.length(); i<4; i++){
			c="0"+c;
		}
		String ymd=DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}
	
	public static String getMemChabun(String type){
		String commNum=ChabunQuery.getMemChabunQuery();
		return BIZ_GUBUN_MEMBER.concat(ChabunUtil.numPad(type, commNum));
	}
	
	public static void main(String[] args) {
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("d"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("m"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("y"));
		System.out.println(" >>> : "+ChabunUtil.getMemChabun("n"));
	}
}
