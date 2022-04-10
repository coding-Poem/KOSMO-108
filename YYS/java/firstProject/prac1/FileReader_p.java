package a.b.c.prac1;

import java.io.File;
import java.io.FileReader;

import a.b.c.common.FilePath;

public class FileReader_p {

	public static void main(String[] args) {
		// 지역변수, 객체, 참조변수
		// 객체 null 초기화
		FileReader fr = null;
		
		try{
			String filePath=FilePath.FILE_PATH_PRAC1;
			filePath=filePath+"/"+"FileReader_p.java";
			System.out.println("filePath >>> : "+filePath);
			
			File f=new File(filePath);
			
			boolean bFile=f.exists();
			System.out.println("bFile >>> : "+bFile);
			
			if(bFile){
				fr=new FileReader(f);
				System.out.println("fr >>> : "+fr);
				
				// public int read() throws IOException
				int data=0;
				while((data=fr.read()) !=-1){
					System.out.print((char)data);
				}
				
				// 정상적으로 수행이 되었을 때 수행되는 루틴
				// FileInputStream I/O 객체를 닫는다.
				// FileReader로 객체를 열었으니
				// 닫아줍니다.
				fr.close();				
			}else {
				System.out.println("파일이 없습니다. >>> ");
			}
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally{
			if (fr !=null){
				// 가비지 컬렉터가 fr.close 문을 보고도 안 닫아줬거나
				// 혹은 catch 문으로 갔을 경우 null인지 아닌지 확인
				try {
					fr.close(); fr=null;}catch(Exception e){}	
			}
		}
	} // main method

} // FileReader_p class
