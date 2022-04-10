package a.b.c.prac1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import a.b.c.common.FilePath;


public class BufferStream_p {

	public static void main(String[] args) {
		// 파일 패스 공통클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		System.out.println("filePath >>> : "+filePath);
		
		// 파일 패스 및 사용할 파일 명까지 초기화
		String inFile=filePath+"/"+"FileWriter_p.java";
		String outFile=filePath+"/"+"FileWriter_p.bak";
		
		//========초기화===================		
		BufferedInputStream inbuf=null;
		BufferedOutputStream outbuf=null;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		File f=null;
		int data=0;
		//================================
		
		try {
			f=new File(inFile);
			System.out.println("new File(inFile) >>> : "+f);
			
			// 파일이 있는지 여부 체크하는 boolean
			boolean bFile=f.exists();
			System.out.println("boolean bFile >>> : "+bFile);
			
			if(bFile){
				System.out.println("come in if(bFile)");
				// 파일을 읽기 위해서
				fis=new FileInputStream(f);
				System.out.println("new FileInputStream fis >>> : "+fis);
				inbuf=new BufferedInputStream(fis);
				System.out.println("new BufferedInputStream inbuf >>> : "+inbuf);
				
				// inbuf=new BufferedInputStream(new FileInputStream(new File(inFile)));
				// 이렇게 써도 무방하다. File => FileInputStream => BufferedInputStream 순으로
				// 안에서 밖으로, 그러나, 초보자는 지양하는 것이 좋다.
				
				// 파일을 쓰기 위해서
				fos=new FileOutputStream(outFile, true);
				System.out.println("new FileOutputStream(outFile, true) fos >>> : "+fos);
				outbuf=new BufferedOutputStream(fos);
				System.out.println("new BufferedOutputStream(fos) outbuf >>> : "+outbuf);
				
				// 파일을 읽어서 파일에 쓰기
				while((data=inbuf.read())!=-1){
					System.out.print((char)data);
					outbuf.write(data);
				}
				System.out.println("outbuf.flush 이전 >>> : "+outbuf);
				outbuf.flush();
				System.out.println("outbuf.flush 이후 >>> : "+outbuf);
				
				/*
				 * 열었던 순서
				 * 
				 * File -> FileInputStream
				 * -> BufferedInputStream -> FileOutStream 
				 * -> BufferedOutputStream
				 * 
				 * */
				
				// buffer
				outbuf.close(); outbuf=null;
				inbuf.close(); inbuf=null;

				fos.close(); fos=null;
				fis.close(); fis=null;

				
				/*
				 * 닫은 순서
				 * 
				 * BufferedInputStream -> BufferOutputStream
				 * -> FileInputStream ->FileOutStream
				 * 
				 * */
			
			}else{
				System.out.println("사용하려는 해당 데이터(파일)이 없습니다.");
			}
			
		}catch(Exception e){
			System.out.println("error >>>  : "+e.getMessage());
		}finally{
			if (inbuf != null){
				try{inbuf.close(); inbuf=null;}catch(Exception e){}
				
			}
			if (outbuf !=null){
				try {outbuf.close(); outbuf=null;}catch(Exception e){}
			}
			if (fis!=null){
				try{fis.close(); fis=null;}catch(Exception e){}
			}
			if (outFile !=null){
				try {fos.close(); fos=null;}catch(Exception e){}
			}
			
		}
		

	}

}
