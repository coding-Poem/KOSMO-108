package a.b.c.prac1;

import java.io.File;
import java.io.IOException;

public class File_p2 {
	public static void main(String[] args) {
		/*
		 * java.io.File 클래스는 자바에서 파일 또는 폴더 객체를 다루는 클래스이다.
		 * new File() : File 클래스의 인스턴스 생성 (파일 또는 폴더를 생성하시오).
		 * 실제 하드디스크에 물리적인 파일/폴더(디렉토리)를 생성하지  않는다.
		 * 실제 파일/폴더(디렉토리)를 만들기 위해서는 File 클래스에 있는 함수를
		 * 호출해야 한다.
		 * 
		 * createNewFile()
		 * 
		 * Atomically creates a new, empty file named 
		 * by this abstract pathname 
		 * if and only if a file with this name does not yet exist.
		 * 
		 * mkdir()
		 * 
		 * Creates the directory named by this abstract pathname.
		 * 
		 * 
		 * mkdirs()
		 * 
		 * Creates the directory named by this abstract pathname, 
		 * including any necessary but nonexistent parent directories.
		 * File 클래스가 가르키는 기본 위치(default directory)를 꼭 확인하고 사용해야 한다.
		 * 
		 * 
		 * 디렉토리를 생성할 때 처럼 File클래스에서 윈도우 환경에서 무엇인가를 해야할 때는
		 * JVM이 명령어를 보고 해당 OS에 요청을 하면
		 * 해당 OS에서 명령을 수행하여준다.
		 * 
		 * */
		
		File f=new File("윤요섭1");
		// Creates a new File instance by converting the given pathname 
		// string into an abstract pathname.
		
		System.out.println("f >>> : "+f);
		// 윤요섭1
		System.out.println("f.getName() >>> : "+f.getName());
		// 윤요섭1
		
		File fd=new File("aaaa");
		System.out.println("new File(aaaa) (fd) >>> : "+fd);
		// aaaa
		System.out.println("fd.getName() >>> : "+fd.getName());
		// aaaa
		
		File fds=new File("aa/bb/cc");
		System.out.println("new File(aa/bb/cc)fds >>> : "+fds);
		// aa\bb\cc
		System.out.println("fds.getName() >>> : "+fds.getName());
		// cc
		
		
		try{
			boolean b=f.createNewFile();
			// f >>> File f=new File("윤요섭1");
			// 새로운 파일을 만들어라.
			/*
			 * Atomically creates a new, empty file named 
			 * by this abstract pathname if and only if a file 
			 * with this name does not yet exist.
			 * 
			 * Since 1.2
			 * 
			 * */
			System.out.println("새로운 파일을 만들었으면 true, 아니면 false >>> : "+b);
			// true
			
			boolean bdir=f.isDirectory();
			System.out.println("File f=new File(윤요섭1)이 디렉토리인가요? >>> : "+bdir);
			// File f=new File("윤요섭1");
			// 
			/*
			 * Tests whether the file denoted by this abstract pathname is a directory.
			 * 
			 * is는 ~인지 ~아닌지
			 * 
			 * 디렉토리인가요? ㄴㄴ
			 * 
			 * */			
			// false
			
			boolean bfile=f.isFile();
			System.out.println("File f=new File(윤요섭1)이 파일인가요? >>> : "+bfile);
			// File f=new File("윤요섭1");
			// 
			/*
			 * Tests whether the file denoted by this abstract pathname is a normal file.
			 * 
			 * is는 ~인지 ~아닌지
			 * 
			 * 파일인가요? ㅇㅇ
			 * 
			 * */
			// true
			
			boolean bd=fd.mkdir();
			System.out.println(" File fd=new File(aaaa) 디렉토리 생성했나요? >>> : "+bd);
			// File fd=new File("aaaa");
			/*
			 * Creates the directory named by this abstract pathname.
			 * 
			 * 디렉토리 만들어주세요.
			 * 
			 * */
			// true
			
			boolean bddir=fd.isDirectory();
			System.out.println("File fd=new File(aaaa)는 디렉토리인가요? >>> : "+bddir);
			// File fd=new File("aaaa");
			/*
			 * Tests whether the file denoted by this abstract pathname is a directory.
			 * 
			 * 디렉토리 인가요?? ㅇㅇ
			 * 
			 * */
			// true
			
			boolean bdfile=fd.isFile();
			System.out.println("File fd=new File(aaaa)는 파일인가요? >>> : "+bdfile);
			// File fd=new File("aaaa");
			/*
			 * Tests whether the file denoted by 
			 * this abstract pathname is a normal file.
			 * 
			 * 파일인가요?? ㄴㄴ
			 * 
			 * */
			// false
			
			boolean bds=fds.mkdirs();
			System.out.println("File fds=new File(aa/bb/cc) 디렉토리 생성했나요? >>> : "+bds);
			// File fds=new File("aa/bb/cc");
			/* Creates the directory named by this abstract pathname,
			 * including any necessary but nonexistent parent directories.
			 */
			// true 
			
		}catch (Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}
		
	}

}
