package a.b.c.prac1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import a.b.c.common.FilePath;

public class InStrReadTest_p {

	public static void main(String[] args) {
		/*
		 * InputStreamReader isr=
		 * 	new InputStreamReader(
		 *  new FileInputStream("InStrReadTest_p.java"));
		 *  while ((data=isr.read())!=-1)
		 *  {
		 *  	// 읽어온 데이터를 문자로 형변환 해서 콘솔에 출력한다.
		 *  	System.out.print((char)data);
		 *  }
		 * 
		 * byte로 불러올 경우, 한글의 크기가 맞지 않아 깨지는 현상이 발생하는데,
		 * InputStreamReader 클래스를 통해 처리하면
		 * byte가 char로 바뀌어 글자가 깨지지 않는다.
		 * 
		 * */
		
		// 파일 패스 공통클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		
		// 파일 패스 및 사용할 파일 명까지 초기화
		String inFile=filePath+"/"+"InStrReadTest_p.java";
		
		File ff=null;
		FileInputStream fis=null;
		InputStreamReader isr=null;
		// byte -> char 변환하는 io 보조스트림 클래스
		BufferedReader br=null;
		
		int data=0;
		boolean bFile=false;
		
		try{
			ff=new File(inFile);
			System.out.println("ff >>> : "+ff);
			bFile=ff.exists();
			System.out.println("bFile >>> : "+bFile);
			
			if(bFile){
				fis=new FileInputStream(ff);
				System.out.println("fis >>> : "+fis);
				isr=new InputStreamReader(fis);
				// FileInputStream으로 들어온 파일 클래스 참조변수를
				// byte에서 char로 변환하는 클래스의 참조변수로 선언
				br=new BufferedReader(isr);
				
				while((data=br.read())  !=-1){
					// 읽어온 데이터를 문자로 형변환 해서 콘솔에 출력한다.
					System.out.print((char)data);
				}
				
			}else{
				System.out.println("해당 경로에 파일이 존재하지 않습니다. >>> : ");			
			}
			
			br.close(); br=null;
			isr.close(); isr=null;
			fis.close(); fis=null;
			
			
		}catch(Exception e){
			System.out.println("e >>> : "+e.getMessage());
		}finally{
			if(br!=null){
				try{br.close(); br=null;}catch(Exception e){}
				}
			if(isr!=null){
				try{isr.close(); isr=null;}catch(Exception e){}
				}
			if(fis!=null){
				try{fis.close(); fis=null;}catch(Exception e){}
				}
			
		}
	}

}
