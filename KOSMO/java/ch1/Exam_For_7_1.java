package a.b.c.ch1;

// length() : 랭스 함수 : String 클래스의 문자열 길이를 구하는 함수 
// length : 랭스 필드 : 배열의 길이

public class Exam_For_7_1 {

	// forTest 함수를 리턴값없이 선언한다.
	// 매개변수는 int 형 배열이다. 
	// int  형 배열의 참조변수는 iArr_forTest 이다. 
	// forTest 함수를 호출할 때는 인수(아규먼트)를  int 형 배열의 참조변수를 넘겨야 한다.
	// 단 변수명은 동일하지 않아도 된다.
	/*
		Exam_For_7_1 ef7_1 = new Exam_For_7_1();
		ef7_1.forTest(iArr_main);
	
		int iArr_forTest[] = iArr_main;	
		public void forTest(int iArr_forTest[]){}
	*/
	public void forTest(int iArr_forTest[]) {
		System.out.println("Exam_For_7_1.forTest() 함수 시작 >>> : ");
		System.out.println("Exam_For_7_1.forTest() 함수 iArr_forTest >>> : " 
							+ iArr_forTest);

		// 지역변수 : 배열의 길이를 체크하기 위해서 
		int iArrLen = 0;

		// forTest 의 매개변수 넘어온 iArr_forTest 배열 참조변수에 데이터가 있는지 없는지 체크하는 것
		// 배열은 객체이기 때문에 null(iArr_forTest !=null) 
		// 및 길이(iArr_forTest.length > 0)를 체크한다.
		if (iArr_forTest !=null && iArr_forTest.length > 0){

			// 배열의 길이 체크 
			iArrLen = iArr_forTest.length;
			System.out.println("iArrLen 배열의 길이 >>> : " + iArrLen);

			// for 문을 이용해서 배열의 길이 만큼 배열의 데이터르 콘솔에 출력하기 
			for (int i=0; i < iArrLen; i++ ){
				System.out.println("iArr_forTest[" + i + "] >>> : " + iArr_forTest[i]);
			}

		}else{
			System.out.println("iArr_forTest 참조변수에 null 이거나 데이터가 없어요 >>> : " 
								+ iArr_forTest);
		}
	}


	public static void main(String args[]) {
	
		// int iArr[] = new iArr[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

		// 지역 변수 
		// int 기초자료형 인데 배열로 인스턴스 해서 객체이면서 참조변수를 사용한다.
		// iArr_main : 참조변수 
		// int 형 배열을 iArr_main 참조변수 1차원 배열을 선언 과 동시 초기화 했다.
		int iArr_main[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("iArr_main 배열의 참조변수 주소값 >>> : " + iArr_main);
		
		// 사용자 정의 Exam_For_7_1 클래스를 사용하기 위해 인스턴스 했다(메모리에 올렸다).
		// 참조 변수는 ef7_1 이다. 
		Exam_For_7_1 ef7_1 = new Exam_For_7_1();
		System.out.println("ef7_1 참조변수 주소값 >>> : " + ef7_1);
		
		// 참조 변수 ef7_1 를 이용해서 Exam_For_7_1 클래스의 자원 중 
		// forTest() 함수를 호출하고 함수의 매개변수에 인수 iArr_main 배열 참조변수를 넘겨준다.
		// iArr_main : 인수, 아규먼트, argument
		// 메모리에 올라가 forTest 함수가 인터트리트 방식으로 수행 된다 .
		ef7_1.forTest(iArr_main);
	}
}