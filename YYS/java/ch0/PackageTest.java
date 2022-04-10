// 패키지명은 도메인 역순으로 만든다. : 전세계에서 유니크 해야 하기 때문에 
package a.b.c.ch1;

public class PackageTest {

	public static void main(String args[]) {
	
		System.out.println("PackageTest");
	}
}

/*
-d <directory>  Specify where to place generated class files
. : 현재 디렉토리 

C:\00.KOSMO108\10.JExam\ch1>javac -d . PackageTest.java

C:\00.KOSMO108\10.JExam\ch1>javap a.b.c.ch1.PackageTest
Compiled from "PackageTest.java"
public class a.b.c.ch1.PackageTest {
  public a.b.c.ch1.PackageTest();
  public static void main(java.lang.String[]);
}

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.PackageTest
PackageTest

C:\00.KOSMO108\10.JExam\ch1>
*/