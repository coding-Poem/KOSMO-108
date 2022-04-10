package a.b.c.prac1;

public class Math_5 {
	public static int max(int a, int b, int c){
		System.out.println("\n 1. enter >>> int max(int a, int b, int c)");
		System.out.println("2. int a >>> "+a);
		System.out.println("3. int b >>> "+b);
		System.out.println("4. int c >>> "+c);
		
		int max=a;
		System.out.println("5. 지역변수 >> int max=a >>>"+a);
		
		boolean mbool=false;
		System.out.println("6. 지역변수 >> boolean mbool >>>"+mbool);
		mbool = b>=max;
		System.out.println("7. b>=max true, false >>> "+mbool);
		if (b>=max) {
			System.out.println("\n enter if (b>=max)");
			System.out.println("if(b>max) 블록 내의 b >>> "+b);
			System.out.println("if(b>max) 블록 내의 max >>> "+max);			
		}
		System.out.println("\n 8. finish if b>=max, max == >>>"+max);	
		return max;
	}
	
	public static int max(int imax[]){
		System.out.println("\n 11. enter >>> int max(int imax[])");
		System.out.println("12. method max(int imax[])'s imax >>> "+imax);	
		System.out.println("13. imax[] 원소 for문으로 확인");
		for (int i=0; i<imax.length; i++) {
			System.out.print(imax[i]);
		}
		int max=imax[0];
		System.out.println(max);
		
		System.out.println("\n 14. for문 시작");
		for (int i=0; i<imax.length; i++) {
			System.out.print(imax[i]);
			if (imax[i]>max){
				System.out.println("for문 내의 if 문 진입");
				char ch=' ';
				ch = (imax[i]>max) ? 'T':'F';
				System.out.println("imax[i]>max가 맞으면 T 아니면 F >>> "+ch);
				System.out.println(imax[i]+" >>> "+max);
				max=imax[i];
				System.out.println("max=imax[i] >>>> "+max);		
			}
		}
		System.out.println("15. best max >>> "+max);
		return max;		
	}

	public static void main(String[] args) {
		System.out.println("\n 0. main 함수 시작");
		
		int max=Math_5.max(11,2,3);
		// max method 만들어야 함.	
		System.out.println("\n 9. Math_5.max(11,2,3) => max "+max);
		
		int imax[]={5,3,6,7,9,8};
		// same : int imax[]=new imax[]{}; 
		System.out.println("10. int imax[] >>> "+imax);
		
		int maxArray=Math_5.max(imax);
		// max method 매개변수 하나 짜리 만들어야함 (메서드 오버로딩)
		System.out.println("\n 16. maxArray >>> "+maxArray);
	}
}
