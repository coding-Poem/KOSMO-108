package a.b.c.ch1;

public class Str_practice_2{
	public void stringTest(){
		System.out.println("\n stringTest method 시작 \n");
		// String 세 가지 실험
		// 빈문자열로 초기화 하는 방법
		
		// 첫 번째 방법
		String str0="";
		// 유의해야 할 점이 char에서 빈문자로 초기화 할 때는
		// char str=' '; 으로 한 칸 띄어서 했지만
		// String에서는 null space도 글자로 취급하기 때문에
		// String str0="";으로 빈문자열을 초기화 한다.
		// str0이라는 변수를 String이라는 참조자료형에 할당한 다음
		// 대입 연산자를 통해 ""을 대입한다.
		// 이 때 ""은 문자열 초기화를 의미한다.


		// 두 번재 방법
		String str1=null;
		// default 값으로
		// 데이터가 없다는 의미이므로 데이터를 초기화 (데이터 값) 해서 사용해야 한다.
		// str1이라는 변수를 String이라는 참조자료형에 할당한 다음
		// 대입 연산자를 통해 null으로 대입한다.
		// null로 초기화 하는 방법이다.

		// 띄어쓰기와 글자 섞어서 쓰기
		String str2=" ve l og";

		System.out.println("str0.length() >>> "+str0.length()+"\n");
		// ""으로 초기화 하니까 0이 출력 됨
		// System.out.println("str1.length() >>> "+str1.length()+"\n");
		// null로 초기화 하니까 NullPointerException 에러가 나옴
		System.out.println("str2.length() >>> "+str2.length()+"\n");
		// 8이 출력 됨. 글자 수는 5개이지만, 띄어쓰기도 글자로 포함하기 때문에
		// 8이 나오는 것이다

		// 공식문서를 보면 length()는 public int length()임.
		// 따라서, int 변수 = 변수.length();로 지정해줄 수도 있음.
		int str0_0=str0.length();
		//int str1_0=str1.length();
		// null으로 초기화 한 경우 해당 명령어 NullPointerException 에러로 실행 불가
		int str2_0=str2.length();

		System.out.println("int 변수 = 변수.length() 지정 str0.length() >>> "+str0_0+"\n");
		// ""으로 초기화 한 것은 0이 나옴
		//System.out.println("int 변수 = 변수.length() 지정 str1.length() >>> "+str1_0+"\n");
		// null으로 초기화 한 것은 NullPointerException 에러가 나옴
		System.out.println("int 변수 = 변수.length() 지정 str2.length() >>> "+str2_0+"\n");
		// 8이 나옴
		
		// length() 쓰지않고 그냥 출력해보기
		System.out.println(" 큰 따옴표 초기화 >>> "+str0+"\n");
		// 아무 것도 나오지 않음.
		System.out.println(" null 초기화 >>> "+str1+"\n");
		// ""으로 초기화 한 것은 null이 출력된다.
		System.out.println("ve l og >>> "+str2+"\n");
		// ve l og으로 출력됨.

		// 마지막으로 charAt로 한 글자씩 분리해서 살펴보기
		// System.out.println("null 초기화 분리해서 보기 >>> "+str1.charAt(0)+"\n");
		// null으로 초기화 한 것은 NullPointerException으로 에러로 출력되지 않음.
		System.out.println("ve l og  분리해서 보기 >>> "+str2.charAt(1)+"\n");
		// v가 잘 출력 됨.

	} // end of stringTest method
	public static void main(String args[]){
		new Str_practice_2().stringTest();
	} // end of main method

} // end of Str_practice_2 class