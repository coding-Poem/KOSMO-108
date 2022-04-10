package a.b.c.prac1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import a.b.c.common.FilePath;


public class FileInputStream_p1 {

	public static void main(String[] args) {
		// 파일 패스 공통클래스에서 불러오기
		String filePath=FilePath.FILE_PATH_PRAC1;
		System.out.println("filePath >>> : "+filePath);
		// filePath >>> : C:/00.KOSMO108/10.JExam/eclipse_java_work
		// /firstProject/src/a/b/c/prac1
		
		// 파일 패스 및 사용할 파일 명까지 초기화
		String inFile=filePath+"/"+"FileInputStream_p1.java";
		String outFile=filePath+"/"+"FileInputStream_p1.bak";
		
		// 지역변수 디폴트 값을 초기화
		FileInputStream fis=null;
		FileOutputStream fos=null;
		File f=null;
		int data=0;
		boolean bFile=false;
		System.out.println("fis, fos, f, data, bFile >>> \n");
		System.out.print(fis+" ,");
		System.out.print(fos+" ,");
		System.out.print(f+" ,");
		System.out.print(data+" ,");
		System.out.print(bFile);
		System.out.println();
		
		try{
			f=new File(filePath);
			System.out.println("f = new File(filePath) >>> : "+f);
			
			bFile=f.exists();
			System.out.println("f.exists() >>> : "+bFile);
			
			// 파일이 있는지 여부 체크하는 boolean
			bFile=f.exists();
			System.out.println("bFile >>> : "+bFile);
			
			// 파일이 있는지 확인했으면 if문을 수행한다.
			if(bFile){
				// 파일을 읽기 위해서
				System.out.println("if문 안으로 들어왔다.");
				
				fis=new FileInputStream(inFile);
				System.out.println("FileInputStream 완료");
				System.out.println("fis >>> : "+fis);
				
				// 파일을 쓰기 위해서
				fos=new FileOutputStream(outFile, true);
				// Creates a file output stream to write to the file 
				// represented by the specified File object.
				System.out.println("fos >>> : "+fos);
				
				// 파일을 읽어서 파일에 쓰기
				// public int read() throws IOException
				while((data=fis.read()) != -1){
					System.out.print((char)data);
				}
				// io를 닫을 때는 여는 순서의 반대로 닫는다.
				// 집으로 들어갈 때 문여는 순서
				// 빌라 출입문 => 현관문 => 여닫이문(신발장문) => 방문		
				// 집에서 나올 때 순서
				// 방문 => 여닫이문(신발장문) => 현관문 => 빌라 출입문
				// fis -> fos 순으로 코드를 입력하였으니,
				// fos -> fis 순으로 문을 닫는다.
				fos.close();
				fis.close();
			}else{
				System.out.println("파일이 없습니다. >>> : ");
			}
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally {
			if (fos != null){
				// 혹시나 close가 안 됐을 수도 있다. 가비지 컬렉터 마음이기 때문에
				// 프로그래머가 부탁하는 입장이기 때문에....
				try {fos.close(); fos=null;}catch(Exception e){}
			}
			if (fis != null){
				try {fis.close(); fis=null;}catch(Exception e){}
			}
		}

	} // main method

} // FileInputStream_p1 class
