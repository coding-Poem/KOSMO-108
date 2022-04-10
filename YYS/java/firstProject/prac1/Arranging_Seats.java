package a.b.c.prac1;

import java.util.ArrayList;
import java.util.Arrays;

public class Arranging_Seats {
	
	public static String[] sList={"윤요섭","서민정","강민","김경훈","김민배","황신애"
			,"민경호","박건원","박성훈","박주형","강소영","손준성","송정흔"
			,"신익현","성연재","김영하","우한슬","전건희","조정하"
			,"차은비","한지혜","황병하","김별"};
	
	
	public static String random_num(int n, ArrayList<String> aList){
		int a=0;
		String s="";
		
		while(true){
			a=(int)(Math.random()*23);
			if (a<n){
				s=(String)aList.get(a);
				break;
			}
		}
		
		return s;
	}

	public static void main(String[] args) {
		System.out.println("aList.length >>> : "+sList.length);
		ArrayList<String> aList=new ArrayList<>(Arrays.asList(sList));
		
		String r="";
		int i=0;
		int n=0;
		n=aList.size();
		
		while(true) {
			r=Arranging_Seats.random_num(n, aList);
			System.out.println(i+" 번째 자리 주인공 >>> : "+r);
			aList.remove(r);
			n--;
			i++;
			if(n==0){
				break;
			}
		}
	}
}
