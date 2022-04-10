package a.b.c.ch1;

//VO : Value Object

public class Exam_Array_3 {

	public void byteArray(){
		
		// 배열을 선언하고 JVM이 선언한 데이터 타입의 디폴트 값으로 초기화 한다.
		byte bArr[] = new byte[3];
		System.out.println("bArr 참조변수 >>> : " + bArr);
		System.out.println("bArr.length 배열의 길이 구하기 >>> : " + bArr.length);
		System.out.println("bArr[0] >>> : " + bArr[0]);
		System.out.println("bArr[1] >>> : " + bArr[1]);
		System.out.println("bArr[2] >>> : " + bArr[2]);
		
		// 배열의 값을 선언 과 동시에 초기화 하기 
		byte bArr_1[] = new byte[]{1, 2, 3};
		System.out.println("bArr_1.length 배열의 길이 구하기 >>> : " + bArr_1.length);
		System.out.println("bArr_1[0] >>> : " + bArr_1[0]);
		System.out.println("bArr_1[1] >>> : " + bArr_1[1]);
		System.out.println("bArr_1[2] >>> : " + bArr_1[2]);
		
		// 배열의 값을 선언 과 동시에 초기화 하면서 new 연산자와 데이터타입 생략하기  
		byte bArr_2[] = {11, 22, 33};
		System.out.println("bArr_2.length 배열의 길이 구하기 >>> : " + bArr_2.length);
		System.out.println("bArr_2[0] >>> : " + bArr_2[0]);
		System.out.println("bArr_2[1] >>> : " + bArr_2[1]);
		System.out.println("bArr_2[2] >>> : " + bArr_2[2]);

		byte bArr_3[];
		bArr_3 = new byte[]{11, 22, 33};
	}

	public void charArray(){

		// 배열을 선언하고 JVM이 선언한 데이터 타입의 디폴트 값으로 초기화 한다.
		char cArr[] = new char[3];
		System.out.println("cArr 참조변수 >>> : " + cArr);
		System.out.println("cArr.length 배열의 길이 구하기 >>> : " + cArr.length);
		System.out.println("cArr[0] >>> : " + cArr[0]);
		System.out.println("cArr[1] >>> : " + cArr[1]);
		System.out.println("cArr[2] >>> : " + cArr[2]);

		// 배열의 값을 선언 과 동시에 초기화 하기 
		char cArr_1[] = new char[]{'a', 'b', 'c'};
		System.out.println("cArr_1.length 배열의 길이 구하기 >>> : " + cArr_1.length);
		System.out.println("cArr_1[0] >>> : " + cArr_1[0]);
		System.out.println("cArr_1[1] >>> : " + cArr_1[1]);
		System.out.println("cArr_1[2] >>> : " + cArr_1[2]);
		
		// 배열의 값을 선언 과 동시에 초기화 하면서 new 연산자와 데이터타입 생략하기  
		char cArr_2[] = {'d', 'e', 'f'};
		System.out.println("cArr_2.length 배열의 길이 구하기 >>> : " + cArr_2.length);
		System.out.println("cArr_2[0] >>> : " + cArr_2[0]);
		System.out.println("cArr_2[1] >>> : " + cArr_2[1]);
		System.out.println("cArr_2[2] >>> : " + cArr_2[2]);
	}

	public void intArray(){
		int iArr[] = new int[3];
		System.out.println("iArr 참조변수 >>> : " + iArr);
		System.out.println("iArr.length 배열의 길이 구하기 >>> : " + iArr.length);
	}

	public void doubleArray(){
		double dArr[] = new double[3];
		System.out.println("dArr 참조변수 >>> : " + dArr);
		System.out.println("dArr.length 배열의 길이 구하기 >>> : " + dArr.length);
	}

	public void stringArray(){

		// 배열을 선언하고 JVM이 선언한 데이터 타입의 디폴트 값으로 초기화 한다.
		String sArr[] = new String[3];
		System.out.println("sArr 참조변수 >>> : " + sArr);
		System.out.println("sArr.length 배열의 길이 구하기 >>> : " + sArr.length);
		System.out.println("sArr[0] >>> : " + sArr[0]);
		System.out.println("sArr[1] >>> : " + sArr[1]);
		System.out.println("sArr[2] >>> : " + sArr[2]);

		// 배열의 값을 선언 과 동시에 초기화 하기 
		String sArr_1[] = new String[]{"abc", "def", "ghi"};
		System.out.println("sArr_1.length 배열의 길이 구하기 >>> : " + sArr_1.length);
		System.out.println("sArr_1[0] >>> : " + sArr_1[0]);
		System.out.println("sArr_1[1] >>> : " + sArr_1[1]);
		System.out.println("sArr_1[2] >>> : " + sArr_1[2]);
		
		// 배열의 값을 선언 과 동시에 초기화 하면서 new 연산자와 데이터타입 생략하기  
		String[] sArr_2 = {"abc", "def", "ghi"};
		System.out.println("sArr_2.length 배열의 길이 구하기 >>> : " + sArr_2.length);
		System.out.println("sArr_2[0] >>> : " + sArr_2[0]);
		System.out.println("sArr_2[1] >>> : " + sArr_2[1]);
		System.out.println("sArr_2[2] >>> : " + sArr_2[2]);
	}


	// 콘솔 어플리케이션의 시작점이다.
	public static void main(String args[]) {
	
		Exam_Array_3 ea3 = new Exam_Array_3();
		ea3.byteArray();
		ea3.charArray();
		ea3.intArray();
		ea3.doubleArray();
		ea3.stringArray();

	} // end of main() 
} // end of Exam_Array_3 class