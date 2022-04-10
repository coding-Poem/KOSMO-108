package a.b.c.prac1;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class File_p6 {
	static int totalFiles=0;
	static int totalDirs=0;
	static int cnt=0;
	
	public static void printFileList(File dir){
		cnt++;
		System.out.println("printFileList 호출 횟수  >>> "+cnt);
		
		File[] files=dir.listFiles();
		
		ArrayList subDir=new ArrayList();
		
		for (int i=0; i<files.length; i++){
			String fileName=files[i].getName();
			if(files[i].isDirectory()){
				fileName="디렉토리 >>> : ["+fileName+"]";
				subDir.add(i+"");
			}
			System.out.println("파일 >>> : "+fileName);
		}
		
		int dirNum=subDir.size();
		int fileNum=files.length-dirNum;
		
		totalFiles += fileNum;
		// fileNum 만큼 증가 시켜라
		totalDirs += dirNum;
		// dirNum 만큼 totalDirs 를 증가시켜라.
		
		System.out.println(fileNum+" 개의 파일, "+ dirNum + " 개의 디렉토리");
		System.out.println();
		
		System.out.println("subDir >>> : "+subDir);
		for (int i=0; i<subDir.size(); i++){
			System.out.println("subDir.get("+i+") >>> : "+subDir.get(i));
			// 1. subDir.get(i)
			// 2. (String)subDir.get(i)
			// 3. Integer.parseInt()
			int index=Integer.parseInt((String)subDir.get(i));
			
			printFileList(files[index]);
		}

	}
	
	public static void main(String[] args) {
		System.out.println("main 함수 시작 >>> ");
		Scanner sc=new Scanner(System.in);
		
		try{
			System.out.println("찾아보고자 하는 파일과 디렉토리의 절대 경로를 입력하세요.");
			// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
			String path=sc.next();
			System.out.println("입력하신 path >>>> : "+path);
			// 입력하신 path >>>> : C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
			
			if(path!=null && path.length() >0){
				// path 입력 확인
				System.out.println("path 입력이 확인 되었습니다.");
				// path 입력이 확인 되었습니다.
				File dir=new File(path);
				
				boolean bool=dir.exists();
				System.out.println("dir.exists() >>> : "+bool);
				// dir.exists() >>> : true
				
				if (!dir.exists() || !dir.isDirectory()){
					// 디렉토리가 존재하는지, 디렉토리가 맞는지 논리곱으로 확인
					System.out.println("유효하지 않은 디렉토리입니다.");
					System.exit(0);
				}else{
					printFileList(dir);
					System.out.println();
					System.out.println(" 총  : "+totalFiles+" 개의 파일");
					System.out.println(" 총 : "+totalDirs+" 개의 디렉토리");
				}
			}
			
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally{
			if(sc!=null){
				try{sc.close(); sc=null;}catch(Exception e){}
			}
			System.out.println("cnt >>> : "+cnt);
			// cnt >>> 381
		}
	} // main method

} // File_p6 class
