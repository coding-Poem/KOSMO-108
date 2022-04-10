package a.b.c.ch1;

public class Exam_For_8 {

	public static void main(String args[]) {

		for (int i=0; i < 3; i++ ){
			System.out.println(">>> : " + i);
			
			for (int j=0; j < 3; j++){
				System.out.println("<<<>>> : " + j);
			}
		}

		for (int i=0; i < 3; i++ ){			
			for (int j=0; j < 3; j++){
				System.out.print("(" + i + "," + j + ") ");
			}
			System.out.println();
		}
		/*
			 i j   i j   i j
			(0,0) (0,1) (0,2)
			(1,0) (1,1) (1,2)
			(2,0) (2,1) (2,2)		
		*/

		for (int i=0; i < 3; i++ ){			
			for (int j=0; j < 3; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		/*
			***
			***
			***
		*/

		for (int i=0; i < 3; i++ ){			
			for (int j=0; j < i; j++){
				System.out.print("(" + i + "," + j + ") ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i=0; i < 3; i++ ){			
			for (int j=0; j < i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		/*
			*
			**
		*/

		for (int i=0; i < 3; i++ ){			
			for (int j=3; j > i; j--){
				System.out.print("(" + i + "," + j + ") ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i=0; i < 3; i++ ){			
			for (int j=3; j > i; j--){
				System.out.print("*");
			}
			System.out.println();
		}
		/*
			***
			**
			*
		*/

		// int iA[] = new iA[]{1, 2, 3};
		int iA[] = {1, 2, 3};
		for (int i=0; i < iA.length; i++ ){
			System.out.println("" + iA[i]);
		}
		System.out.println();
		
		// int iA2[][] = new iA2[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		int[] iA2[] = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		
		for (int i=0; i < iA2.length; i++ ){
		
			System.out.println("" + iA2);
			System.out.println("" + iA2[i]);			
			
			for (int j=0; j < iA2[i].length; j++){			
				System.out.println("" + iA2[i][j]);
			}
			System.out.println();
		}

		for (int i=0; i < iA2.length; i++ ){			
			// System.out.println("" + iA2[i]);			
			for (int j=0; j < iA2[i].length; j++){
				System.out.print(iA2[i][j]);
			}
			System.out.println();
		}
		/*
		123
		123
		123
		*/
	}
}