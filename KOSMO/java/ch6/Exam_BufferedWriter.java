package a.b.c.ch6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;

//Ex_BufferedWriter.java 화일을 읽어서 
//Ex_BufferedWriter.bak 파일 만들기 
public class Exam_BufferedWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 파일 패스 공통클래스에서 불러오기 
		String filePath = FilePath.FILE_PATH_CH6;

		// 파일 패스 및 사용할 파일 명까지 초기화 
		String inFile = filePath + "/" + "Exam_BufferedWriter.java";
		String outFile = filePath + "/" + "Exam_BufferedWriter.bak";
		
		// 사용할 지역변수 초기화 하기 
		BufferedReader inbuf = null;
		BufferedWriter outbuf = null;
		FileReader fr = null;
		FileWriter fw = null;
		File f = null;		
		int data = 0;
				
		try {
			
			f = new File(inFile);
			
			// 파일이 있는지 여부 체크 하는 boolean 
			boolean bFile = f.exists();
			System.out.println("bFile >>> : " + bFile);
			
			// 파일이 있을 때만 수행 한다. 
			if (bFile) {
				
				// 파일을 읽기 위해서 
				fr = new FileReader(f);
				inbuf = new BufferedReader(fr);
				
				// 파일을 쓰기 위해서 
				fw = new FileWriter(outFile, true);
				outbuf = new BufferedWriter(fw);
				
				// 파일을 읽어서 파일에 쓰기 
				while ((data=inbuf.read()) != -1) {
					System.out.print((char)data); // 콘솔에 프린드 하세요 
					outbuf.write(data); // Ex_BufferedWriter.bak
				}
				outbuf.flush(); // buffer클래스는 무조건 flush() 를 해야 한다. 
				
				outbuf.close();	outbuf=null;	
				inbuf.close(); inbuf=null;
				
				fw.close(); fw=null;
				fr.close(); fr=null;
				
			}else {
				System.out.println("사용하려는 해당 데이터(파일이)가 없습니다. ");
			}
				
		}catch (Exception e) {
			System.out.println("에러가 e.getMessage() >>> : " + e.getMessage());
		}finally{
			if (inbuf !=null){
				try{inbuf.close(); inbuf=null;}catch(Exception e){}
			}
			if (outbuf !=null){
				try{outbuf.close(); outbuf=null;}catch(Exception e){}
			}	
			if (fr !=null){
				try{fr.close(); fr=null;}catch(Exception e){}
			}
			if (outFile !=null){
				try{fw.close(); fw=null;}catch(Exception e){}
			}	
		}		
	}
}
