package a.b.c.ch1;

public class Exam_For_5 {

	public static void main(String args[]) {
		
		// String s = "abcdefghijklmnopqrstuvwxyz";
		// char cc = new char[26];

		String s2 = "A";
		
		char ch_L = s2.charAt(0);
		
		for (int i=ch_L; i < (ch_L + 26); i++ ){
			System.out.print((char)i + " ");
			
			System.out.print(i + " ");
			System.out.print(Integer.toBinaryString(i) + " ");
			System.out.print("0" + Integer.toOctalString(i) + " ");
			System.out.print("0x" + Integer.toHexString(i) + " ");
			System.out.print("0X" + Integer.toHexString(i) + " ");
			System.out.println();
		}
		System.out.println();

		// public String toLowerCase()
		String s3 = s2.toLowerCase();

		char ch_S = s3.charAt(0);

		for (int i=ch_S; i < (ch_S + 26); i++ ){
			System.out.print((char)i + " ");
			System.out.print(i + " ");
			System.out.print(Integer.toBinaryString(i) + " ");
			System.out.print("0" + Integer.toOctalString(i) + " ");
			System.out.print("0x" + Integer.toHexString(i) + " ");
			System.out.print("0X" + Integer.toHexString(i) + " ");
			System.out.println();
		}
	}
}
