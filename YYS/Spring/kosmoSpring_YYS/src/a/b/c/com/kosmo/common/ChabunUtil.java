package a.b.c.com.kosmo.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class ChabunUtil {
	public static final String BIZ_GUBUN_C = "C";
	public static final String BIZ_GUBUN_M 	= "M"; // 
	public static final String BIZ_GUBUN_KM = "KM"; // 
	public static final String BIZ_GUBUN_B 	= "B"; // 
	public static final String BIZ_GUBUN_RB = "RB"; // 
	public static final String BIZ_GUBUN_N 	= "NB"; // 
	
	static Logger logger = LogManager.getLogger(ChabunUtil.class);
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N : 
	public static String numPad(String t, String c){
		logger.info(" ChabunUtil :: numPad 함수 진입 >>> : ");
		for(int i=c.length(); i<4; i++){
			c="0"+c;
		}
		// c : 0001
		String ymd=DateFormatUtil.ymdFormats(t);
		logger.info("ymd >>> : "+ymd);
		
		logger.info("ymd.concat(c) >>> : "+ymd.concat(c));
		return ymd.concat(c);
	}
											// String type >>> : N, String memNum >>> : 1
	public static String getKosmoProductChabun(String type, String memNum) {
		logger.info(" ChabunUtil :: getKosmoProductChabun 함수 진입 >>> : ");
		logger.info("String type >>> : "+type);
		logger.info("String memNum >>> : "+memNum);
		
		
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
		// M202205120001
	}
	
	public static String getKosmoMemberChabun(String type, String memNum) {
		logger.info(" ChabunUtil :: getKosmoMemberChabun 함수 진입 >>> : ");
		logger.info("String type >>> : "+type);
		logger.info("String memNum >>> : "+memNum);
		
		
		return BIZ_GUBUN_KM.concat(ChabunUtil.numPad(type, memNum));
		// M202205120001
	}
	
	public static String getKosmoCartChabun(String type, String memNum){
		logger.info(" ChabunUtil :: getKosmoCartChabun 함수 진입 >>> : ");
		logger.info("String type >>> : "+type);
		logger.info("String memNum >>> : "+memNum);
		
		return BIZ_GUBUN_C.concat(ChabunUtil.numPad(type, memNum));		
	};
	
	public static String getKosmoBoardChabun(String type, String memNum){
		logger.info(" ChabunUtil :: getKosmoBoardChabun 함수 진입 >>> : ");
		logger.info("String type >>> : "+type);
		logger.info("String memNum >>> : "+memNum);
		
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, memNum));
	}
}
