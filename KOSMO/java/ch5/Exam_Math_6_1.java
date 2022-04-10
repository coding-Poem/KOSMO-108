package a.b.c.ch5;

public class Exam_Math_6_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int n=0; n < 5; n++) {
	
			int lo[] = new int[6];		
			
			for (int i=0; i < lo.length; i++) {
				
				lo[i] = (int)(Math.random()*45) + 1; 

				for (int j=0;j < i; j++) {
					if (lo[j] == lo[i]) {
						System.out.println("if >>> : " + lo[j] + " : " + lo[i]);
						i--;
						break;					
					}
				} 
			}			
			
			for (int i=0; i < lo.length; i++) {
				System.out.print(lo[i] + " ");
			}					
			
			System.out.println();
		}
	}
}
