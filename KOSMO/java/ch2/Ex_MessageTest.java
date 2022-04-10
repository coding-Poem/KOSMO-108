// package
package a.b.c.ch2;

// import

// class 선언
public class  Ex_MessageTest{
	// 상수 
	// 멤버변수
	// 생성자

	// 함수 

	// main() 함수 : 프로그램 시작점
	public static void main(String[] args) {
		// TODO Auto-generated method stub.

		Ex_MessageInterface eme = new Ex_MessageEngImpl();
		eme.sayHello("Park Gun Won");

		Ex_MessageInterface emk = new Ex_MessageKorImpl();
		emk.sayHello("박건원");

	}
}



