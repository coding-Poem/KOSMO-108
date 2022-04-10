package a.b.c.prac1;

import java.io.FileInputStream;

public class IO_p2 {

	public static void main(String[] args) {
		// 절대 경로 : 파일이 있는 위치에서 그 디렉토리의 루트부터 읽어 오는 경로
		// String filePath="C:\\00.KOSMO108\\10.JExam\\eclipse_java_work\\firstProject\\src\\a\\b\\c\\prac1\\";
		
		//  \\ or / 사용 가능
		/*
		 * 파일, 디렉토리 구분자
		 * 윈도우 \
		 * 이클립스 \\ or /
		 * 유닉스 리눅스 /
		 * */
		String filePath="C:/00.KOSMO108/10.JExam/eclipse_java_work/firstProject/src/a/b/c/prac1/";
		
		// 
		// filePath.replace('\', '/');
				
		
		// 파일 경로
		String file="IO_p1.java";	
		
		try{
			FileInputStream fs=new FileInputStream(filePath+file);
			// 절대경로를 FileInputStream 클래스에 new키워드로 인스턴스한다.
			// 이 때 참조변수는 fs로 한다.
			System.out.println("fs >>> : "+fs);
			// 항상 파일을 찾거나, 수정하거나, 지우거나, 만들때는
			// 파일이 있는지 체크하여야 한다.
			// fs >>> : java.io.FileInputStream@15db9742
			
			// public int read() throws IOException
			int data=0;
			while((data=fs.read())!=-1){
				// while 소괄호 안에는 참조변수를 읽어들이는데
				// 남은 것이 하나도 없이 마지막(-1)까지 계속 반복 시킨다.
				System.out.print((char)data);
				// 데이터를 출력시킨다.
				// 한글의 경우 byte로 변환시킬시에 깨진다.
				// 이유는 영문은 1byte인데, 비해
				// 한글은 1byte가 아니기 때문에 읽지를 못하는 것이다.
			}
			
		}catch(Exception e){
			System.out.println("Error >>> : "+e.getMessage());
		}
	}

}
