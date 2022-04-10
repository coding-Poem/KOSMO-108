package a.b.c.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {

						// YYYYMMDD : 20220318
	public static String ymdFormat(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
		// 20220329
	}
	
	public static String ymFormat(){
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	public static String yFormat(){
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	                                        // d
	public static String ymdFormats(String ymdFlag){
		System.out.println("5555 :: DateFormatUtil.ymdFormats() >>> :  ymdFlag " + ymdFlag);
	
		String y = "";
		
		if ("D".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymdFormat();
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymFormat();
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.yFormat();
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			y = "";
		}
		
		return y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
