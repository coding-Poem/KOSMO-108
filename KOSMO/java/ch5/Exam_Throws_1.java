package a.b.c.ch5;

public class Exam_Throws_1 {

	int aM() throws Exception{
		
		int z = bM();
		
		return z;
	}
	
	int bM() throws Exception{		
		int z = 0;
		
		z = 1 / 0;			
		
		return z;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Exam_Throws_1 et = new Exam_Throws_1();
			int z = et.aM();
			
			System.out.println("z >>> : " + z);			
		}catch(Exception e) {
			System.out.println("에러가 e >>> : " + e);
		}	
		
		System.out.println("try~catch 구문 이후 ");
	}
}
