package a.b.c.ch5;

public class Exam_Math_5 {

	public static int max(int a, int b, int c) {
		System.out.println("Exam_Math_5.max() 함수 진입 >>> : ");
		System.out.println("Exam_Math_5.max() a >>> : " + a);
		System.out.println("Exam_Math_5.max() b >>> : " + b);
		System.out.println("Exam_Math_5.max() c >>> : " + c);
		
		int max = a;
		System.out.println("Exam_Math_5.max() max >>> : " + max);
		
		if (b >= max) {
			System.out.println("Exam_Math_5.max() if (b >= max) b >>> : " + b);
			System.out.println("Exam_Math_5.max() if (b >= max) max >>> : " + max);
			max = b;
			System.out.println("Exam_Math_5.max() if (b >= max) max = b max >>> : " + max);
		}
		if (c >= max) {
			System.out.println("Exam_Math_5.max() if (c >= max) c >>> : " + c);
			System.out.println("Exam_Math_5.max() if (c >= max) max >>> : " + max);
			max = c;
			System.out.println("Exam_Math_5.max() if (c >= max) max = c max >>> : " + max);
		}
		
		System.out.println("Exam_Math_5.max() max >>> : " + max);
		return max;
	}
	
	public static int max(int imax[]) {
		System.out.println("Exam_Math_5.max(int imax[]) 함수 진입 >>> : ");
		System.out.println("Exam_Math_5.max(int imax[]) imax >>> : " + imax);
		for (int i=0; i < imax.length; i++) {
			System.out.println("Exam_Math_5.max(int imax[]) imax[" + i + "] >>> : "+ imax[i]);
		}
			
		int max = imax[0];
		System.out.println("Exam_Math_5.max(int imax[]) max >>> : "+ max);
		
		for (int i=0; i < imax.length; i++) {
			
			System.out.println("Exam_Math_5.max(int imax[]) >>> : " + imax[i]);
			
			if (imax[i] > max) {
				
				System.out.println("Exam_Math_5.max(int imax[]) >>> : " + imax[i] + " > " + max);	
				
				max = imax[i];
				
				System.out.println("Exam_Math_5.max(int imax[]) >>> : " + max);
			}
		}
		System.out.println("Exam_Math_5.max(int imax[]) >>> : " + max);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exam_Math_5.main() 함수 진입 >>> : ");
		
		int max = Exam_Math_5.max(11, 2, 3);
		System.out.println("Exam_Math_5.max(11, 2, 3) 함수 호출한 결과 값 max >>> : " + max);
		System.out.println("max >>> : " + max);
		
		int imax[] = {5, 3 , 6, 7, 9, 8};
		System.out.println("imax >>> : " + imax);
		int maxArray = Exam_Math_5.max(imax);
		System.out.println("Exam_Math_5.max(imax) 함수 호출한 결과 값 max >>> : " + maxArray);
		System.out.println("maxArray >>> : " + maxArray);
		
	}
}
