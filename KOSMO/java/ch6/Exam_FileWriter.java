package a.b.c.ch6;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;

public class Exam_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 파일 패스 공통클래스에서 불러오기 
		String filePath = FilePath.FILE_PATH_CH6;

		// 파일 패스 및 사용할 파일 명까지 초기화 
		String inFile = filePath + "/" + "Exam_FileWriter.java";
		String outFile = filePath + "/" + "Exam_FileWriter.bak";
		
		// 지역변수 디폴트 값으로 초기화 
		FileReader fr = null;
		FileWriter fw = null;
		File f = null;		
		int data = 0;
		boolean bFile = false;
				
		try {
			
			f = new File(inFile);
			
			// 파일이 있는지 여부 체크 하는 boolean 
			bFile = f.exists();
			System.out.println("bFile >>> : " + bFile);
			
			// 파일이 있을 때만 수행 한다. 
			if(bFile) {

				// 파일을 읽기 위해서
				fr = new FileReader(f);				
				System.out.println("fr >>> : " + fr);
				
				// 파일을 쓰기 위해서 
				fw = new FileWriter(outFile, true);
				System.out.println("fw >>> : " + fw);
				
				// 파일을 읽어서 파일에 쓰기
				// public int read() throws IOException				
				while((data = fr.read()) !=-1) {
					System.out.print((char)data);
					fw.write(data);
				}
				
				// io 를 닫을 때는 여는 순서의 반대로 닫는다.
				// 정상적으로 수행이 되었을 때 수행되는 루틴 
				fw.close();
				fr.close();				
			}else {
				System.out.println("파일이 없습니다. >>> : ");
			}
					
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			
			if (fw !=null) {
				try { fw.close(); fw=null; }catch(Exception e) {}
			}

			if (fr !=null) {
				try { fr.close(); fr=null; }catch(Exception e) {}
			}
		}
	}
}
