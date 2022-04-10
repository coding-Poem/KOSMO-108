package a.b.c.prac1;

public class File_p3 {

	public static void main(String[] args) {
		String javaVersion=System.getProperty("java.version");
		// public static String getProperty(String key)
		// Key : java.version
		// Description of Associated Value : Java Runtime Environment version
		System.out.println("System.getProperty java.version >>> : "+javaVersion);
		// 1.8.0_202
		
		String userDir=System.getProperty("user.dir");
		// Key : user.dir
		// Description of Associated Value : User's current working directory
		System.out.println("System.getProperty(user.dir) >>> : "+userDir);
		// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\firstProject
		
		String osName=System.getProperty("os.name");
		// Key : os.name
		// Description of Associated Value : Operating system name
		System.out.println("System.getProperty(os.name) >>> : "+osName);
		// Windows 10
		
		String userHome=System.getProperty("user.home");
		// Key : user.home
		// Description of Associated Value : User's home directory
		System.out.println("System.getProperty(user.home) >>> : "+userHome);
		// C:\Users\kosmo
		// 명령 프롬프트 창 처음 키면 나오는 게  >>>> C:\Users\kosmo>
		
		String fileSeparator=System.getProperty("file.separator");
		// Key : file.separator
		// Description of Associated Value : File separator ("/" on UNIX)
		System.out.println("System.getProperty(file.separator) >>> : "+fileSeparator);
		// \ : 지금 환경이 윈도우 체제이기 때문에 윈도우 구분자인 \가 출력된다.
		System.out.println("java.io.File.separator 파일 구분문자(separator) >>> : "+java.io.File.separator);
		// java.io 패키지의 File 클래스의 separator 멤버변수  >>> \
		// The system-dependent default name-separator character, 
		// represented as a string for convenience.
		// This string contains a single character, namely separatorChar.
		System.out.println("java.io.File.separator 파일 구분문자 >>>(separatorChar) : "+java.io.File.separatorChar);
		// \
		
		String pathSeparator=System.getProperty("path.separator");
		System.out.println("System.getProperty( path.separator) >>> : "+pathSeparator);
		// Key: path.separator 
		// Description of Associated Value : Path separator (":" on UNIX)
		// ;
		
		
		// 한 번에 출력시키는 방법
		//================================================================================
		System.out.println("\n ===========================================================");
		System.out.println("getProperties() 한 번에 출력시키는 방법 \n");
		java.util.Properties p=System.getProperties();
		System.out.println("System.getProperties() \n "+p);
		System.out.println("\n ===========================================================");
		//================================================================================
		
		// 출력시키되, 줄 별로 나누어 출력시키는 방법
		//================================================================================
		System.out.println("getProperties() 출력시키되, 줄 별로 나누어 출력시키는 방법 \n");
		for (java.util.Enumeration e=p.propertyNames(); e.hasMoreElements();){
			// the keys of a hashtable, and the values in a hashtable. 
			String key=(String)e.nextElement();
			String value=p.getProperty(key);
			System.out.println(key+"="+value);
		}
		// java.util Interface Enumeration<E>
		
		
		//================================================================================
		System.out.println("\n ===========================================================");
		System.out.println("복잡한 식 없이 편하게 출력하는 방법 ");
		System.out.println("p.list(System.out) \n");
		
		p.list(System.out);
		System.out.println("\n ===========================================================");
		
		
		
		
	}

}
