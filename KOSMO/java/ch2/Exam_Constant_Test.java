package a.b.c.ch2;

import a.b.c.ch2.common.Exam_Constant;

public class Exam_Constant_Test {

	public static void main(String args[]) {
		
		// Exam_Constant ec = new Exam_Constant();
		/*
		C:\00.KOSMO108\10.JExam\ch2>javac -d . Exam_*_Test.java Exam_Constant.java
		Exam_Constant_Test.java:9: error: Exam_Constant is abstract; cannot be instantiated
						Exam_Constant ec = new Exam_Constant();
										   ^
		1 error		
		*/

		String fileUploadPath = Exam_Constant.FILE_UPLOAD_PATH;
		System.out.println("fileUploadPath >>> : " + fileUploadPath);
	}
}