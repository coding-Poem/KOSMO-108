package a.b.c.ch4;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.ch3.HelloVO;

public class ArrayListTest_3 {
	
	public ArrayList<HelloVO> arrayListTest_1(HelloVO hvo) {
		
		
		// 비즈니스 로직을 거쳐서 데이터베이스에 다녀오는 로직이 들어올 예정이다.

		ArrayList<HelloVO> aList = null;
		aList = new ArrayList<HelloVO>();
		
		aList.add(hvo);
		
		return aList;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mid = "";
		String mpw = "";
		String mname = "";
		
		System.out.println("데이터를 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디 >>> : ");
		mid = sc.next();
		System.out.println("패스워드 >>> : ");
		mpw = sc.next();
		System.out.println("이름 >>> : ");
		mname = sc.next();
		
		HelloVO hvo = new HelloVO();
		hvo.setMid(mid);
		hvo.setMpw(mpw);
		hvo.setMname(mname);
			
		ArrayListTest_3 al3 = new ArrayListTest_3();
		
		// public ArrayList<HelloVO> arrayListTest_1(HelloVO hvo)
		ArrayList<HelloVO> aList = al3.arrayListTest_1(hvo);

		if (aList !=null && aList.size() > 0) {
			
			for (int i=0; i < aList.size(); i++) {
				System.out.println("aList.get(" + 0 + ") >>> : " + aList.get(i));
				
				HelloVO _hvo = aList.get(i);
				System.out.print(_hvo.getMid() + " ");
				System.out.print(_hvo.getMpw() + " ");			
				System.out.println(_hvo.getMname());			
			}
		}
		else {
			System.out.println("데이터가 입력 또는 출력 중 어딘지모르지만 잘 못 되었네요 >>> :");
		}
			
	}
}
