package a.b.c.prac1;

import java.io.File;
import a.b.c.common.DateUtil;

public class File_p5 {

	public static void main(String[] args) {
		try{
			// mkdirs() 함수
			// Creates the directory named by this abstract pathname, 
			// including any necessary but nonexistent parent directories.
			File f3=new File("test/aa/bb/cccc");
			f3.mkdirs();
			// 디렉토리를 여러개 만들겠다.
			System.out.println("f3 >>> : "+f3);
			
			File f4=new File(f3, DateUtil.yyyymmdd() + "_"+f3.getName()+".txt");;
			f4.createNewFile();
			System.out.println("f4 >>> : "+f4);
			String getPath1=f4.getAbsolutePath();
			// File에 입력된 절대 경로를 getPath1 String 변수로 저장
			System.out.println("getPath1 >>> : "+getPath1);
			// 절대 경로 출력
			
			boolean bool=f4.exists();
			System.out.println("f4.exists() >>> : "+bool);
			if(f4.exists()){
				java.io.FileWriter fw=null;
				// FileWriter 클래스의 fw 참조변수에 null이라고 선언. (없다!)
				fw=new java.io.FileWriter(f4);
				// f4 파일을 FileWriter 클래스에 인스턴스
				System.out.println("fw >>> : "+fw);
				fw.write("mkdirs :: 파일 내용을 써보세요~~~~~!!!! ");
				fw.close();
			}
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}

	}

}
