package a.b.c.prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;


public class BufferedWriter_p {

	public static void main(String[] args) {
		// 파일 패스 공통클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		
		// 파일 패스 및 사용할 파일 명가지 초기화
		String inFile=filePath+"/"+"BufferedWriter_p.java";
		String outFile=filePath+"/"+"BufferedWriter_p.bak";
		System.out.println("inFile >>> : "+inFile);
		System.out.println("outFile >>> : "+outFile);
		
		// 사용할 지역변수 초기화 하기
		BufferedReader inbuf=null;
		BufferedWriter outbuf=null;
		FileReader fr=null;
		FileWriter fw=null;
		File f=null;
		int data=0;
		
		try{
			f=new File(inFile);
			// input abstract pathname
			System.out.println("f >>> : "+f);
			
			// 파일이 있는지 여부 체크 하는 boolean
			boolean bFile=f.exists();
			System.out.println("boolean bFile >>> : "+bFile);
			
			if(bFile){
				System.out.println("enter if(bFile) block");
				
				// 파일을 읽기 위해서
				fr=new FileReader(f);
				System.out.println("new Filereader(f) >>> : "+fr);
				inbuf=new BufferedReader(fr);
				System.out.println("new BufferedReader(fr) >>> "+inbuf);
				
				// 파일을 쓰기 위해서
				fw= new FileWriter(outFile, true);
				System.out.println("new FileWriter(outFile, true) (fw) >>> : "+fw);
				outbuf=new BufferedWriter(fw);
				System.out.println("new BufferedWriter(fw) (outbuf) >>> : "+outbuf);
				
				// 파일을 읽어서 파일에 스기
				while((data=inbuf.read()) !=-1){
					System.out.print((char)data);
					// 콘솔에 프린트 하세요.
					outbuf.write(data);	
				}
				outbuf.flush();
				// buffer클래스는 무조건 flush() 를 해야한다.
				
				outbuf.close(); outbuf=null;
				inbuf.close(); outbuf=null;
				fw.close(); fw=null;
				fr.close(); fw=null;							
			}else{
				System.out.println("사용하려는 해당 데이터(파일이)가 없습니다.");
			}
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
					
		}finally{
			if (outbuf !=null) {
				try {outbuf.close(); outbuf=null;}catch(Exception e){}
			}
			if(inbuf !=null) {
				try {inbuf.close(); inbuf=null;}catch(Exception e){}
			}
			if (fr!=null) {
				try {fr.close(); fr=null;}catch(Exception e){}
			}
			if (outFile !=null) {
				// 여기서만, fw가 아니라 outFile로 확인한다.
				try {fw.close(); fw=null;}catch(Exception e){}
			}
		}

	} // main method

} // BufferedWriter_p class
