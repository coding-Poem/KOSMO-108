package a.b.c;

// a.b.c.HelloPackage
public class HelloPackage {

	public static void main(String args[]){
	
		System.out.println("java pacakge test");
	}
}

/*
C:\00.KOSMO108\10.JExam>javac -d . HelloPackage.java

	javac : 컴파일러 
	-d :  -d <directory> Specify where to place generated class files
	. : 현재 디렉토리 
	C:\00.KOSMO108\10.JExam>javac -d . : C:\00.KOSMO108\10.JExam> 요기서 패키지를 만드세요
	HelloPackage.java : 소스 파일 

C:\00.KOSMO108\10.JExam>java a.b.c.HelloPackage
	C:\00.KOSMO108\10.JExam\a\b\c>HelloPackage.class

	java : 실행 명령어는 컴파일한 위치(디렉토리)에서 한다. 
	a.b.c.HelloPackage : 패키지이름(a.b.c) + 클래스이름(HelloPackage) 

java pacakge test

C:\00.KOSMO108\10.JExam>java a/b/c/HelloPackage
java pacakge test


C:\00.KOSMO108\10.JExam>javap a.b.c.HelloPackage
Compiled from "HelloPackage.java"
public class a.b.c.HelloPackage {
  public a.b.c.HelloPackage();
  public static void main(java.lang.String[]);
}
*/