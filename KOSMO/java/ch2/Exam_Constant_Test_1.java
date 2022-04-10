package a.b.c.ch2;

import a.b.c.ch2.common.Exam_Constant;

public class Exam_Constant_Test_1 extends Exam_Constant{

	public static void main(String args[]) {
		
		String fileUploadPath = Exam_Constant.FILE_UPLOAD_PATH;
		String imgUploadPath = Exam_Constant.IMG_UPLOAD_PATH;
		int fileUploadSize = Exam_Constant.FILE_UPLOAD_SIZE;
		int imgUploadSize = Exam_Constant.IMG_UPLOAD_SIZE;
		System.out.println("fileUploadPath	>>> : " + fileUploadPath);
		System.out.println("imgUploadPath	>>> : " + imgUploadPath);
		System.out.println("fileUploadSize	>>> : " + fileUploadSize);
		System.out.println("imgUploadSize	>>> : " + imgUploadSize);

	
		String jdbc_driver = Exam_Constant.JDBC_DRIVER;
		String jdbc_url = Exam_Constant.JDBC_URL;
		String jdbc_user = Exam_Constant.JDBC_USER;
		String jdbc_pwd = Exam_Constant.JDBC_PWD;
		System.out.println("jdbc_driver	>>> : " + jdbc_driver);
		System.out.println("jdbc_url	>>> : "	+ jdbc_url);
		System.out.println("jdbc_user	>>> : "	+ jdbc_user);
		System.out.println("jdbc_pwd	>>> : "	+ jdbc_pwd);
	}
}