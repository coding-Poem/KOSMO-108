package a.b.c.prac1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;


public class FileWriter_p {

	public static void main(String[] args) {
		// 파일 패스 공통 클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		
		// 파일 패스 및 사용할 파일 명까지 초기화
		String inFile=filePath+"/"+"FileWriter_p.java";
		String outFile=filePath+"/"+"FileWriter_p.bak";
		
		// 지역변수 디폴트 값으로 초기화
		FileReader fr=null;
		FileWriter fw=null;
		File f=null;
		int data=0;
		boolean bFile=false;
		
		try {
			f=new File(inFile);
			System.out.println("f >>> : "+f);
			
			// 파일이 있는지 없는지 여부 체크 하는 boolean
			bFile=f.exists();
			System.out.println("bFile >>> : "+bFile);
			
			if(bFile){
				// 파일을 읽기 위해서
				fr=new FileReader(f);
				System.out.println("fr >>> : "+fr);
				
				// 파일을 쓰기 위해서
				fw=new FileWriter(outFile, true);
				// Constructs a FileWriter object 
				// given a File object.
				System.out.println("fw >>> : "+fw);
				
				// 파일을 읽어서 파일에 쓰기
				// public int read() throws IOException
				while((data=fr.read()) != -1){
					System.out.print((char)data);
					fw.write(data);
				}
				
				// io를 닫을때는 연 순서 반대로 닫기!!!!
				// fr => fw 순서대로 열었으니
				// fw => fr 순서대로 닫아야 함.
				fw.close();
				fr.close();
			}else{
				System.out.println("파일이 없습니다. >>> : ");		
			}
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
			
		}finally{
			if (fw!=null){
				try {fw.close(); fw=null; }catch(Exception e){}
				// .close와 null 꼭 둘다 쓰기, 가끔 close 안 될 때도 있음.
			}
			if (fr!=null){
				try {fr.close(); fr=null;}catch(Exception e){}
			}
			// fw => fr 순으로
			
		}

	} // main method

} // FileWriter_p class
