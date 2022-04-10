package a.b.c.ch6;

import java.io.File;
import java.io.FileInputStream;

import a.b.c.common.FilePath;

/*
자바 프로그램에서는 메모리관리를 프로그램에서 하지 않는다.
소스에서 개발자가 메모리를 지우는 행위를 할 수가 없다.
자바에서 메모리를 지우는 역화을 담당하는 넘은 가비지 컬렉터 라고 한다. 
자바에서 메모리를 지운다는 것은 
가비지 컬렉터에게 요청하는 것과 같은 뜻이다.
프로그램 입장에서는 메모리가 언제 지워지는지 알 수 가 없다.
*/

/*
자바에는 null 키워드가 있다.
null 키워드가 의미하는 것은 데이터를 가르키지 않는다.
나는 현재 이 참조변수에 데이터가 없다. 
*/

public class Exam_FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		지역변수 사용하는 방법
		
		1. 지역변수는 함수에서 태어나서 함수에서 죽는다.
			단 : 죽이는 것은 GC(가비지 컬렉터)가 한다. 
		2. 지역변수는 죽으라고 명령을 할 수가 없다.
		3. 지역변수는 가비지 컬렉터가 그 프로그램의 메모리 상황을 보고
		4. 프로그램의 운선순위도 보고 스케줄링에 의해서 메모리에서 제거 된다. 
		*/
		
		/*
		지역변수를 사용하는 규칙
		
		1. 지역변수는 선언과 동시에 디폴트 값으로 초기화 한다.
			객체 참조변수 = null;
			기초자료형 지역변수 = 디폴트값; 0, 0.0, '\u0000', false
			String s = "";
			String s1 = null;
		2. 통신 관련, I/O 가 발생하는 객체는 사용한 후
			flush(), close(), null 처리를 해야 한다. 
			
			예) 	FileInputStream fis = null; //  null 초기화 
				// 객체 오픈 
				fis = new FileInputStream(filePath + "/" + file);
				
				// 객체 닫기
				fis.close();
				// 사용을 다한 객체 null 초기화 
				fis = null;
		*/
		
		// 지역변수, 객체, 참조변수 
		// 객체 null 초기화 
		FileInputStream fis = null;
				
		try {
			
			String filePath = FilePath.FILE_PATH_CH6;			
			filePath = filePath + "/" + "Exam_FileInputStream.java";
			System.out.println("filePath >>> : " + filePath);
			
			File f = new File(filePath);
			
			boolean bFile = f.exists();
			System.out.println("bFile >>> : " + bFile);
			
			if(bFile) {
				fis = new FileInputStream(f);				
				System.out.println("fis >>> : " + fis);
				
				// public int read() throws IOException
				int data = 0;
				while((data = fis.read()) !=-1) {
					System.out.print((char)data);
				}
				
				// 정상적으로 수행이 되었을 때 수행되는 루틴
				// FileInputStream I/O 객체를 닫는다.
				fis.close();				
			}else {
				System.out.println("파일이 없습니다. >>> : ");
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			
			if (fis !=null) {
				try {
					fis.close(); fis=null;
				}catch(Exception e) {}
			}
		}
	}
}
