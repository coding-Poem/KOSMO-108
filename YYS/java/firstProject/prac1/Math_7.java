package a.b.c.prac1;

public class Math_7 {

	public static void main(String[] args) {
		String n0="";
		String n1="";
		char c='A';
		String n2[]= {"자동","수동"};
		// { index : value} 키-값
		// { 0 : "자동", 1 : "수동"}
		
		System.out.println("for문 n 진입");
		for (int n=0; n<5; n++){
			int lo[]=new int[6];
			
			System.out.println("n : "+n);
			System.out.println("for i문 진입");
			for (int i=0; i<lo.length; i++){
				lo[i]=(int)(Math.random()*45)+1;
				System.out.println("i : "+i);
				System.out.println("lo[i] : "+lo[i]);
				System.out.println("for j문 진입");
				for (int j=0; j<i; j++){
					if (lo[j]==lo[i]){
						System.out.println("i -> :"+i);
						System.out.println("j -> :"+j);
						System.out.println("lo[j] >>>>> :"+lo[j]);
						System.out.println("lo[i] >>>>> :"+lo[i]);
						i--;
						break;
					} // if
				} // for j
			} // for i
			
			System.out.println("lo 의 원소들 ");
			System.out.print(lo[0]+",");
			System.out.print(lo[1]+",");
			System.out.print(lo[2]+",");
			System.out.print(lo[3]+",");
			System.out.print(lo[4]+",");
			System.out.print(lo[5]+",");
			System.out.println("\n for a 문 진입");
			for (int a=0; a<lo.length; a++){
				if (lo[0]==lo[a]){
					System.out.println("a -> :"+a);
					n1=String.valueOf(lo[a]);
					System.out.println("String.valueOf(lo[a]) >>> "+n1);
					if (1==n1.length()){
						n1="0"+n1;
						System.out.println("0+n1 >>> "+n1);
					}
					
					n0=c+n2[1]+n1;
					// n2[i] => "수동"
					c +=1;
					// c는 'A'			
				}else {
					n0=String.valueOf(lo[a]);
					// System.out.println("String.valueOf(lo[a]) >>> "+n0);
					if (1==n0.length()){
						System.out.println("1==n0.length()");
						n0="0"+n0;
						System.out.println("0+n0 : "+n0);
					}	
				} // else 
				n0+=" ";
				System.out.println("<<<<>>>>"+n0);
				
			} // for a
			System.out.println();
		} // for n

	} // main method

} // Math_7 class
