package a.b.c.ch5;

public class Exam_Math_7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String n0 = "";
		String n1 = "";
		char c = 'A';
		String n2[]= {" 자 동 ", " 수 동  "};		

		for (int n=0; n < 5; n++) {
			
			int lo[] = new int[6];		
			
			for (int i=0; i < lo.length; i++){
				
				lo[i] = (int)(Math.random()*45) + 1;
				for (int j=0; j < i; j++ ){				
					if (lo[j] == lo[i]){
						i--;
						break;
					}
				}
			}
							
			for (int i=0; i < lo.length; i++ ){				
				
				if (lo[0] == lo[i]) {			
					
					n1 = String.valueOf(lo[i]);					
					
					if (1 == n1.length()) {
						n1 = "0" + n1;
					}						
					
					n0 = c + n2[1] + n1;
					c += 1;
				}else {					
					
					n0 = String.valueOf(lo[i]);					
					
					if (1 == n0.length()) {
						n0 = "0" + n0;
					}	
				}
				
				n0 += " ";	
				
				System.out.print(n0);				
			}	
			
			System.out.println();
		} // end of for 5번 							
	}
}
