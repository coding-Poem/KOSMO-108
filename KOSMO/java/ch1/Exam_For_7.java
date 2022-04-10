package a.b.c.ch1;

// length() : 랭스 함수 : String 클래스의 문자열 길이를 구하는 함수 
// length : 랭스 필드 : 배열의 길이

public class Exam_For_7 {

	public static void main(String args[]) {
	
		// int iArr[] = new iArr[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int iArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("iArr 참조변수 주소값 >>> : " + iArr);
		
		iArr = null;

		/*
		int iArrLen = iArr.length;
		System.out.println("iArr.length 배열의 길이 >>> : " + iArr.length);

		if (iArrLen > 0){

			for (int i=0; i < iArrLen; i++ ){
				System.out.println("iArr[" + i + "] >>> : " + iArr[i]);
			}
		}
		*/
				
		int iArrLen = 0;

		if (iArr !=null && iArr.length > 0){

			iArrLen = iArr.length;
			System.out.println("iArr.length 배열의 길이 >>> : " + iArr.length);

			for (int i=0; i < iArrLen; i++ ){
				System.out.println("iArr[" + i + "] >>> : " + iArr[i]);
			}
		}else{
			System.out.println("iArr 참조변수에 null 이거나 데이터가 없어요 >>> : " + iArr);
		}
	}
}