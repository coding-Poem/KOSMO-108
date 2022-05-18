package a.b.c.com.kosmo.common;
import java.text.DecimalFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NumUtil {
	static Logger logger = LogManager.getLogger(NumUtil.class);
	public static String comma(String s){
		logger.info("NumUtil :: comma 함수 진입 >>> : ");
		logger.info("매개변수 String s >>>> : "+s);
		// 매개변수 String s >>>> : 5000
		int is=Integer.parseInt(s);
		logger.info("Integer.parseInt(s) >>> : "+is);
		// Integer.parseInt(s) >>> : 5000
		
		return new DecimalFormat("###,###").format(is);
	}
	
	public static void main(String args[]){
		logger.info("NumUtil.comma('5000') >>> : "+NumUtil.comma("5000"));
		// NumUtil.comma('5000') >>> : 5,000
	}
}
