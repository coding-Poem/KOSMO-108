package a.b.c.ch1;


public class Exam_Array_2 {

	public void byteArray(){
		byte bArr[] = new byte[10];
		System.out.println("bArr 참조변수 >>> : " + bArr);
		System.out.println("bArr.length 배열의 길이 구하기 >>> : " + bArr.length + "\n"
							+ "byte 타입의 상자가 10개 있다. \n"
							+ "index 는 0 ~ 9 까지이다. \n"
							+ "index = 배열상자갯수 - 1 이다 \n"
							+ "index 는 0 부터 시작하기 때문이다. \n");
	}

	public void charArray(){
		char cArr[] = new char[10];
		System.out.println("cArr 참조변수 >>> : " + cArr);
	}

	public void intArray(){
		int iArr[] = new int[10];
		System.out.println("iArr 참조변수 >>> : " + iArr);
	}

	public void doubleArray(){
		double dArr[] = new double[10];
		System.out.println("dArr 참조변수 >>> : " + dArr);
	}

	public void stringArray(){
		String sArr[] = new String[10];
		System.out.println("sArr 참조변수 >>> : " + sArr);
	}

	// 콘솔 어플리케이션의 시작점이다.
	public static void main(String args[]) {
	
		Exam_Array_2 ea2 = new Exam_Array_2();
		ea2.byteArray();
		ea2.charArray();
		ea2.intArray();
		ea2.doubleArray();
		ea2.stringArray();

	} // end of main() 
} // end of Exam_Array_2 class