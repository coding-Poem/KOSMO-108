// 자바 리소스 자원은 항상 import 키워드를 사용해서 
// 해당 클래스에서 호출해서 사용해야 한다. 
// 단 : java.lang.* 에 있는 자원
//      그 사용빈도 많아서 import 키워드를 사용해서 
//      import 하지 않아도 사용이 가능하다.

// import java.lang.String;
// import java.lang.System;

// 여는 중괄호를 블럭 잡고 
// ctrl + } 키를 누르면 
// 다든 중괄호를 찾아간다 : 영역이다. 
// 클래스 블럭 : 15 line ~ 28 line
// 함수 블럭 : 20 line ~ 27 line
public class HelloSource {

	String s;
	int i;

	public static void main(String args[]){
	
		System.out.println("Hello Source");
		System.out.println("인터프리트 방식");
		System.out.println("자바는 블럭 언어이다.");
		System.out.println("자바는 스코프 언어이다.");
		System.out.println("자바는 범위 언어이다.");
	}
}