package a.b.c.prac1;

public class Math_6_1 {

	public static void main(String[] args) {
		System.out.println("\n 0.for문으로 진입합니다.");
		for (int n=0; n<5; n++){
			int lo[]=new int[6];
			// 배열의 갯수 6개로 만들기
			// index 0~5
			System.out.format("lo.length : %d ", lo.length);
			System.out.println();
			for (int i=0; i<lo.length; i++){
				lo[i]=(int)(Math.random()*45)+1;
				System.out.format("lo[%d] : %2d ", i, lo[i]);
				System.out.println();
				for (int j=0; j<i; j++){
					System.out.println("for j문 진입 :: 현재 i는 >>> "+i);
					System.out.format("for j문 진입 j == %d ", j);
					System.out.println();
					if (lo[j]==lo[i]){
						System.out.println("\n lo[j] == lo[i] 인 상태 \n");
						System.out.println("\n j는 "+j+" i는 "+i+"\n");
						System.out.println(j+".  lo[j] >>> "+lo[j]+" ::: "+i+".  lo[i] >>> "+lo[i]);
						System.out.println("\n i-- 하기 이전 >>> "+i);
						i--;
						System.out.println("\n i-- 한 이후 >>> "+i);
						break;
					} // if (lo[j]==lo[i])	
				} // for j			
			} // for i
			for (int k=0; k<lo.length; k++){
				System.out.println("for k문 진입");
				System.out.print(lo[k]+" ");

			} // for k
			System.out.println();
			System.out.println("==========================");
			System.out.println(" value					  ");
			System.out.format(" | %2d| %2d| %2d| %2d| %2d| %2d| ", lo[0],lo[1],lo[2],lo[3],lo[4],lo[5]);
			System.out.println("\n==========================");
		} // for n

	} // main method

} // Math_6_1 method
