package a.b.c.ch6;

import java.io.File;
import java.io.FileReader;

import a.b.c.common.FilePath;

public class Exam_FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		// 지역변수, 객체, 참조변수 
		// 객체 null 초기화 
		FileReader fr = null;
				
		try {
			
			String filePath = FilePath.FILE_PATH_CH6;			
			filePath = filePath + "/" + "Exam_FileReader.java";
			System.out.println("filePath >>> : " + filePath);
			
			File f = new File(filePath);
			
			boolean bFile = f.exists();
			System.out.println("bFile >>> : " + bFile);
			
			if(bFile) {
				fr = new FileReader(f);				
				System.out.println("fr >>> : " + fr);
				
				// public int read() throws IOException
				int data = 0;
				while((data = fr.read()) !=-1) {
					System.out.print((char)data);
				}
				
				// 정상적으로 수행이 되었을 때 수행되는 루틴
				// FileInputStream I/O 객체를 닫는다.
				fr.close();				
			}else {
				System.out.println("파일이 없습니다. >>> : ");
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			
			if (fr !=null) {
				try {
					fr.close(); fr=null;
				}catch(Exception e) {}
			}
		}
	}
}
