package a.b.c.ch4;

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;

public class ArrayListTest_2 {
	
	public void arrayListTest_1(ArrayList<HelloVO> aList) {
		
		for (int i=0; i < aList.size(); i++) {
			System.out.println("aList.get(" + 0 + ") >>> : " + aList.get(i));
			
			HelloVO _hvo = aList.get(i);
			System.out.print(_hvo.getMid() + " ");
			System.out.print(_hvo.getMpw() + " ");			
			System.out.println(_hvo.getMname());			
		}
	}
	
	public void arrayListTest_2(String mid, String mpw, String mname) {

		System.out.print(mid + " ");
		System.out.print(mpw + " ");			
		System.out.println(mname);			
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mid = "CHEB_";
		String mpw = "CHEB00_";
		String mname = "Â÷Àººñ_";
		
		ArrayList<HelloVO> aList = new ArrayList<HelloVO>();
		
		for (int i=0; i < 3; i++) {		
			
			HelloVO hvo = new HelloVO();	
			
			hvo.setMid(mid + i);
			hvo.setMpw(mpw + i);
			hvo.setMname(mname + i);
			
			aList.add(hvo);						
		}
		
		ArrayListTest_2 al2 = new ArrayListTest_2();
		al2.arrayListTest_1(aList);
		
		ArrayListTest_2 al3 = new ArrayListTest_2();
		al2.arrayListTest_2(mid, mpw, mname);
	}
}
