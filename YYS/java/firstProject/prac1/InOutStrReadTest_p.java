package a.b.c.prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import a.b.c.common.FilePath;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InOutStrReadTest_p {

	public static void main(String[] args) {
		// 파일 패스 공통클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		
		// 파일 패스 및 사용할 파일 명까지 초기화
		String inFile=filePath+"/"+"InOutStrReadTest_p.java";
		String outFile=filePath+"/"+"InOutStrReadTest_p.bak";
		
		File ff=null;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		int data=0;
		boolean bFile=false;
		
		try{
			ff=new File(inFile);
			System.out.println("new File(inFile) (ff) >>> : "+ff);
			bFile=ff.exists();
			System.out.println("ff.exists() (bFile) >>> : "+bFile);
			
			if(bFile){
				System.out.println("enter if(bFile)");
				fis=new FileInputStream(ff);
				System.out.println("new FileInputStream(ff) (fis) >>> : "+fis);
				isr=new InputStreamReader(fis);
				System.out.println("new InputStreamReader(fis) (isr) >>> : "+isr);
				
				br=new BufferedReader(isr);
				System.out.println("new BufferedReader(isr) (br) >>> : "+br);
				
				fos=new FileOutputStream(outFile);
				System.out.println("new FileOutputStream(outFile) (fos) >>> : "+fos);
				
				osw=new OutputStreamWriter(fos);
				System.out.println("new OutputStreamaWriter(fos) (osw) >>> : "+osw);
				
				bw=new BufferedWriter(osw);
				System.out.println("new BufferedWriter(osw) >>> : "+bw);
				
				while((data=br.read()) !=-1){
					// 읽어온 데이터를 문자로 형변환 해서 콘솔에 출력한다.
					System.out.print((char)data);
					bw.write(data);
				}
				// flush() 하기
				// osw.flush();
				bw.flush();
				
			}else{
				System.out.println("해당 경로에 파일이 존재하지 않습니다. >>> : ");
			}
			
			/*
			 * 입력순서
			 * 
			 * fis -> isr -> br -> fos -> osw -> bw 
			 * */
			
			// buffer stream
			bw.close(); bw=null;
			br.close(); br=null;
			
			// outputstreamwriter
			osw.close(); osw=null;
			isr.close(); isr=null;
			
			// file stream
			fos.close(); fos=null;
			fis.close(); fis=null;
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
			
		}finally{
			if(bw!=null){
				try{bw.close(); bw=null;}catch(Exception e){}
				}
			if(br!=null){
				try{br.close(); br=null;}catch(Exception e){}
				}
			if(osw!=null){
				try{osw.close(); osw=null;}catch(Exception e){}
				}
			if(isr!=null){
				try{isr.close(); isr=null;}catch(Exception e){}
				}
			if(fos!=null){
				try{fos.close(); fos=null;}catch(Exception e){}
				}
			if(fis!=null){
				try{fis.close(); fis=null;}catch(Exception e){}
				}
			
		}
		

	}

}
