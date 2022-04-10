package a.b.c.prac1;

import java.io.File;
import a.b.c.common.DateUtil;

public class File_p4 {

	public static void main(String[] args) {
		try{
			// mkdir() 함수
			File f1=new File("abc");
			// abc라는 abstract pathname를 File클래스에게 알려줌.
			f1.mkdir();
			// 지정한 경로에 디렉토리를 만드세요.
			System.out.println("f1 >>> : "+f1);
			
			File f2=new File(f1, DateUtil.yyyymmdd() + "_"+f1.getName() + ".txt");
			// 지정된경로에 오늘의 yyyymmdd를 넣은 뒤에 _를 추가하고 f1이름을 붙인 뒤 확장자이름 .txt를 붙여서
			// File 클래스에 f2 참조변수로 선언한다.
			System.out.println("f2 >>> : "+f2);
			f2.createNewFile();
			// 새로운 파일을 생성한다.
			String getPath=f2.getPath();
			// getPath라는 참조자료형 변수에 f2의 변수를 얻어와서 선언한다.
			System.out.println("getPath >>>> : "+getPath);
			
			boolean bool=f2.exists();
			System.out.println("f2.exists() >>> : "+bool);
			if (f2.exists()){
				java.io.FileWriter fw=null;
				// java.io 패키지에 있는 FileWriter 클래스에 f2 참조변수는 현재 null이다.
				// 그냥 없다.
				fw=new java.io.FileWriter(f2);
				System.out.println("fw >>> : "+fw);
				// f2 파일에 작성하도록 하겠다.
				fw.write("mkdir :: 파일 내용을 써보세요~~~!!!");
				fw.close();
				}
				
				File files[]=f1.listFiles();
				System.out.println("files.length >>> : "+files.length);
				for (int i=0; i<files.length; i++){
					String fileName=files[i].getName();
					System.out.println("fileName >>> : "+fileName);
				}
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}

	}

}
