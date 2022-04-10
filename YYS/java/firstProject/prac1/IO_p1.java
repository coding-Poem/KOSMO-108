package a.b.c.prac1;

import java.util.Scanner;

public class IO_p1 {

	public static void main(String[] args) {
		System.out.println("IO 테스트 숫자 ");
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		System.out.println("들어온 정수 데이터 >>> : "+data);
		System.out.println("들어온 데이터 binary 변환 >>> : "+Integer.toBinaryString(data));
		
		System.out.println("IO 테스트 문자 ");
		Scanner sc1=new Scanner(System.in);
		String dataS=sc1.nextLine();
		
		System.out.println("들어온 문자 데이터 >>> : "+dataS);
		
		for (int i=0; i<dataS.length(); i++){
			char c=dataS.charAt(i);
			System.out.println("binary >>> : "
							   +" : "+c
							   +" : "+(byte)c
							   +" : "+Integer.toBinaryString((byte)c));
		}
		// 음수가 나오는 이유는 char는 2byte, byte는 1byte
		// 형변환 과정에서 음수가 나올 수 있음.
		
		/*============실험====
		// byte -> char -> string
		System.out.println("IO 실험 테스트 ");
		Scanner sc2=new Scanner(System.in);
		Byte data2=sc.nextByte();
		String s1="";
		char c2=' ';
		int i2=0;
		System.out.println("data2 >>> : "+data2);
		
		try {
			s1=String.toString(data2);
			System.out.println("c2 >>> : "+c2);
			s1=Integer.toHexString(data2);
			System.out.println("Integer.toHexString(data2) >>> : "+s1);
			i2=Integer.parseInt(s1);
			System.out.println("Integer.parseInt(s1) >>> "+i2);
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}
		*/
		
		
		sc.close();
		sc1.close();
		//sc2.close();
	}

}
