package a.b.c.ch4;

/*
>>> : [I@6d06d69c 1 2 3 
>>> : [I@7852e922 4 5 6
*/

public class 배열_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iV[][] = new int[][] {{1, 2, 3}, {4, 5, 6}};
		
		System.out.println("iV 참조변수 주소값 >>> : " + iV);
		
		for (int i=0; i < iV.length; i++){
			System.out.println(">>> : " + iV[i]);
			
			for (int j=0; j < iV[i].length; j++) {
				
			}
		}
	}

}
