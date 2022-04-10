package a.b.c.ch1;


public class Exam_For_1 {

	void for_1() {
		System.out.println("Exam_For_1.for_1() 함수 블럭 시작 ");
		for (int i=0; ; ){
			System.out.println("i >>> : " + i);
		}
	}

	void for_2() {
		System.out.println("Exam_For_1.for_2() 함수 블럭 시작 ");		
		int i=0;
		for (; ; ){
			System.out.println("i >>> : " + i);
		}
	}

	void for_3() {
		System.out.println("Exam_For_1.for_3() 함수 블럭 시작 ");		
		int i;
		for (i=0; ; ){
			System.out.println("i >>> : " + i);
		}
	}

	void for_4() {
		System.out.println("Exam_For_1.for_4() 함수 블럭 시작 ");		
		int i;
		for (i=0; i < 3;){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
	}


	void for_5() {
		System.out.println("Exam_For_1.for_5() 함수 블럭 시작 ");		
		int i;
		for (i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i + "\n");
		}
	}


	void for_6() {
		System.out.println("Exam_For_1.for_6() 함수 블럭 시작 ");		
		int i;
		for (i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i + "\n");
		}
		System.out.println("for {} 블럭 외부 ::: i >>> : " + i);
	}

	void for_7() {
		System.out.println("Exam_For_1.for_7() 함수 블럭 시작 ");
		for (int i=0; i < 3; i++){
			System.out.println("(" + i + " < 3) >>> : " + (i < 3));
			System.out.println("for {} 블럭 내부 ::: i >>> : " + i);
		}
		System.out.println("for {} 블럭 외부 ::: i >>> : " + i);
	}

	public static void main(String args[]) {

		// 명령행 인수 길이 체크하기 
		if (args.length == 1){

			String sVal = args[0];

			if (sVal !=null && sVal.length() > 0){

				if ("1".equals(sVal)){
					
					System.out.println("함수 실행 번호 1 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_1() 함수 호출 >>> : \n");					
					new Exam_For_1().for_1();
				}
				if ("2".equals(sVal)){
					
					System.out.println("함수 실행 번호 2 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_2() 함수 호출 >>> : \n");
					new Exam_For_1().for_2();
				}
				if ("3".equals(sVal)){
					
					System.out.println("함수 실행 번호 3 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_3() 함수 호출 >>> : \n");
					new Exam_For_1().for_3();
				}
				if ("4".equals(sVal)){
					
					System.out.println("함수 실행 번호 4 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_4() 함수 호출 >>> : \n");
					new Exam_For_1().for_4();
				}
				if ("5".equals(sVal)){
					
					System.out.println("함수 실행 번호 5 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_5() 함수 호출 >>> : \n");
					new Exam_For_1().for_5();
				}
				if ("6".equals(sVal)){
					
					System.out.println("함수 실행 번호 6 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서(메모리에 올려서)");
					System.out.println("for_6() 함수 호출 >>> : \n");
					new Exam_For_1().for_6();
				}
				if ("7".equals(sVal)){
					
					System.out.println("함수 실행 번호 7 선택 >>> : ");
					System.out.println("Exam_For_1() 클래스를 인스턴스 해서");
					System.out.println("for_7() 함수 호출 >>> : ");
					new Exam_For_1().for_7();
				}
			}else{
				System.out.println("sVal 에 데이터가 없습니다. >>> : ");	
			}
		}else{
			System.out.println("함수 실행 번호를 입력 하시오 >>> : ");
		}		
	}
}