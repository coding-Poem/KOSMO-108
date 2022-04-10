package a.b.c.prac1;

import java.io.File;
import java.io.FileInputStream;
import a.b.c.common.FilePath;

public class FileInputStream_p {

	public static void main(String[] args) {
		/*
		 * 자바 프로그램에서는 메모리 관리를 프로그램에서 하지 않는다.
		 * 소스에서 개발자가 메모리를 지우는 행위를 할 수가 없다.
		 * 자바에서 메모리를 지운다는 것은
		 * 
		 * 가비지 컬렉터에게 요청하는 것과 같은 뜻이다.
		 * 프로그램 입장에서는 메모리가 언제 지워지는지 알 수가 없다.
		 * */
		
		/*
		 * 자바에는 null 키워드가 있다.
		 * null 키워드가 의미하는 것은  데이터를 가르키지 않는다.
		 * 나는 현재 이 참조변수에 데이터가 없다.
		 * 
		 * 클래스 참조변수=null;
		 * 
		 * 은 클래스가 비어있다라는 의미가 아니라
		 * 그냥 비어있다라는 말이다.
		 * 
		 * 비유를 하면, 물통에 물이 없는 것이 아니라
		 * 물통자체가 없다라는 것을 의미한다.
		 * 
		 * */
		
		/*
		 * 지역변수 사용하는 방법(How to use local variable)
		 * 
		 * 1. 지역변수는 함수에서 태어나서 함수에서 죽는다.
		 * 	단 : 죽이는 것은 GC(가비지 컬렉터)가 한다. (프로그래머가 하는게 아님.)
		 * 
		 * 2. 지역변수는 죽으라고 명령을 할 수가 없다.
		 * 3. 지역변수는 가비지 컬렉터가 그 프로그램의 메모리 상황을 보고
		 * 4. 프로그램의 우선순위도 보고 스케줄링에 의해서 메모리에서 제거 된다.
		 * 
		 * */
		
		/*
		 * 지역변수 사용하는 규칙(local variable Rules)
		 * 
		 * 1. 지역변수는 선언과 동시에 디폴트 값으로 초기화 한다.
		 * 	객체 참조변수=null;
		 * 	기초자료형 지역변수=디폴트값;
		 *  int 디폴트값 => 0
		 *  float, double 디폴트값 => 0.0
		 *  char 디폴트값 => \u0000
		 *  boolean 디폴트값 => false
		 *  
		 *  String s="";
		 *  String s1=null;
		 *  
		 *  통신 관련, I/O가 발생하는 객체는 사용한 후,
		 *  flush(), close(), null 처리를 해야 한다.
		 *  
		 *  flush는 자료 찌꺼기가 남지 않게 물레방아를 돌리는 행위
		 *  
		 *  close는 닫으라는 뜻인데, 가끔 버그때문에 되지 않을 때가 있으므로,
		 *  null로 한 번 더 확인해야 할 때가 있음.
		 *  
		 *  example)
		 *  
		 *  FileInputStream fis=null; => null 초기화
		 *  
		 *  fis = new FileInputStream(filePath+"/"+file); => 객체 오픈
		 *  
		 *  fis.close => 객체 닫기
		 *  
		 *  fis = null; => 마지막으로 null로 초기화
		 * */
		
		FileInputStream fis=null;
		// try~catch~finally 지역에 들어가기 전에
		// main method 지역변수에서 null로 초기화를 한다.
		// FileInputStream 클래스에 null 이 들어가는게 아니라
		// FileInputStream 클래스 자체가 null이라고 명시해주는 것이다.
		System.out.println("FileInputStream fis >>> : "+fis);
		// FileInputStream fis >>> : null
		// null인 것을 확인 하였다.
		
		try {
			String filePath=FilePath.FILE_PATH_PRAC1;
			System.out.println("filePath >>> : "+filePath);
			// a.b.c.common패키지에 있는 FilePath 클래스의
			// public static final String FILE_PATH_CH6 변수를
			// FileInputStream_p 내의  String 참조자료형에 filePath로 선언해준다.
			filePath=filePath+"/"+"FileInputStream_p.java";
			// filePath에 현재 파일을 더해준다.
			System.out.println("filePath <<<<<<<<<<<<<<<<<<<<<>>> : "+filePath);
			// 파일 경로가 제대로 되었는지 확인하여 본다.
			// filePath >>> : 
			// C:/00.KOSMO108/10.JExam/eclipse_java_work/firstProject/src/a/b/c/
			// prac_1/FileInputStream_p.java
			// 제대로 들어옴을 확인하였다.
			
			// === 이 과정에서 /가 \로 바뀜
			File f=new File(filePath);
			// new 인스턴스 연산자로 제대로 들어온 경로를 File클래스로 인스턴스한다.
			// Creates a new File instance by converting 
			// the given pathname string into an abstract pathname.
			// "abstract pathname" : 절대 경로로 입력해야 한다.
			// File 생성자 오버로딩중에 File(String pathname) 생성자로 인스턴스.
			System.out.println("File f >>> : "+f);
			// 항상 파일을 부르거나 찾거나 할 때는 파일이 제대로 들어왔는지 의심해보고
			// 확인해야 함.
			
			boolean bFile=f.exists();
			// File 클래스의 exists 메서드
			// 	exists()
			// Tests whether the file or directory denoted 
			// by this abstract pathname exists.
			
			System.out.println("f.exists() true/false >>> : "+bFile);
			// boolean 키워드로 파일이 존재하는지 한 번 더 확인해보기.
			
			if(bFile){
				// if 조건문안에 bFile을 넣음으로써
				// true일 때만 실행되게 한다.
				// checked exception이면 eclipse에서 오류를 체크해주나
				// unchecked exception이면 사람이 잡아야 하기 때문에
				// File f 확인, boolean으로 f.exists() 확인
				// if문 조건식 안에서 확인 총 3번의 확인 작업에 거쳐서 꼼꼼히 확인해봐야
				// 나중에 io 작업시 문제없이 원활하게 작업할 수 있다.
				fis=new FileInputStream(f);
				// FileInputStream 
				// 업로드한 파일을 스트림에 입력시킨다.
				System.out.println("fis >>> : "+fis);
				
				int data=0;
				while((data=fis.read()) !=-1) {
					// FileInputStream
					// read() : Reads a byte of data from this input stream.
					System.out.print((char)data);
					// 들어오는 데이터를 char 자료형으로 형변환 하여 출력시킨다.
					// fis를 읽는데, -1을 쓴 이유는 더 이상 없을 때 까지 다 부르라는 뜻이다.
				}
				fis.close();
				// 정상적으로 if문이 실행되고, while문이 실행되었을 때,
				// FileInputStream(f)를 닫는다.
				// 안 닫혔을 수도 있기 때문에(버그) finally에서 한 번 더 체크하고
				// 확실하게 닫는다.
			} 
			
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
			// 예외처리가 된 내용을 출력시킨다.	
		}finally{
			if (fis!=null){
				// fis가 null인지 마지막으로 체크하고, 아닐 시 try문 실행
				try {
					fis.close(); fis=null;
					// fis를 닫고, null로 초기화해준다.
					// 이 때 try문이 제대로 실행되지 않으면, catch문으로 넘긴다.
				}catch(Exception e){
					System.out.println("error >>> : "+e.getMessage());
				}
			}
			
		}
		
		

	} // main method

} // FileInputStream_p class
