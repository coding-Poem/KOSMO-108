package a.b.c.prac1;

public class Math_6 {

	public static void main(String[] args) {
		int lo[]=new int[6];
		System.out.println("1. lo[] >>> "+lo);
		// 1. lo[] >>> [I@15db9742
		System.out.println("2. lo.length >>> "+lo.length);
		// 2. lo.length >>> 6
		
		/*
		for (int i=0; i<lo.length; i++){
			System.out.println(i+" >>> "+lo[i]);
			// 정상적으로 6개 배열 초기화 되어 생성 되었음.
		}
		*/
		
		
		/* 
		 * (int)(Math.random()*45)+1 을 하면
		 * 대략 1부터 46미만의 수가 출력된다.
		double d=0.9999999999999999999d;
		d=d*45;
		System.out.println(d);
		// 45.0 
		d=d+1;
		System.out.println(d);
		// 46.0
		int i=(int)d;
		System.out.println(i);
		// 46
		*/
		
		/*
		double d=0.0000000000000000001d;
		// 5E-181.0
		d=d*45;
		System.out.print(d);
		d=d+1;
		System.out.println(d);
		int i=(int)d;
		System.out.println(i);
		// 1
		 */
		
		// 2. lo.length >>> 6
		System.out.println("3. for (int i=0; i<io.length; i++) 시작 >>> \n");
		for (int i=0; i<lo.length; i++){
			// 0,1,2,3,4,5 => 총 6번 loop 돌 것임.
			int ii=(int)(Math.random()*45)+1;
			System.out.format("%2d . random 난수  %2d \n", i, ii);
			// 6개의 난수가 생성
			lo[i]=ii;
			// lo배열의 i번째 방에 생성된 난수 ii 입력
			// System.out.println("lo 배열의 "+i+"번째 방에 "+ii+"난수가 입력이 되었습니다.");
			// second for문 실행
			for (int j=0; j<i; j++){
				System.out.println("\n for 문안에 for문 시작 \n");
				System.out.print("\n lo 배열의 "+i+"번째 인덱스의 값 >>>  "+lo[i]+"\n");
				System.out.print("\n lo 배열의 "+j+"번째 인덱스의 값 >>>  "+lo[j]+"\n");
				if (lo[j]==lo[i]){
					System.out.println("\n lo 배열의 "+i+" 번째 값과 "+j+"번째 값이 같습니다.");
					System.out.println("\n i에서 변화가 일어나기 전의 i >>> "+i+"\n");
					i--;
					System.out.println("\n i를 하나 감소시키세요. == 전에 껄 삭제하세요");
					System.out.println("\n i-- 를 실행시킨 이후의 i >>> "+i+"\n");
					System.out.println("\n i-- 를 실행시킨 이후의 lo[i] >>> "+lo[i]+"\n");
				}
				/*
				 * lo 배열의 3번째 인덱스의 값 >>>  16

 				   lo 배열의 2번째 인덱스의 값 >>>  16

 				   lo 배열의 3 번째 값과 2번째 값이 같습니다.

 				   i에서 변화가 일어나기 전의 i >>> 3

 				   i를 하나 감소시키세요. == 전에 껄 삭제하세요

 				   i-- 를 실행시킨 이후의 i >>> 2
 				   
 				   lo[3] == 16  -> lo[2]==16
				 * */
				
			}
		}
		
		System.out.println("==========================");
		System.out.println(" index 					  ");
		System.out.println(" | 0 | 1 | 2 | 3 | 4 | 5 |");
		System.out.println("==========================");
		System.out.println(" value					  ");
		System.out.format(" | %2d| %2d| %2d| %2d| %2d| %2d| ", lo[0],lo[1],lo[2],lo[3],lo[4],lo[5]);
		System.out.println("\n==========================");

		/*
		 * ==========================
 		   index 					  
 		   | 0 | 1 | 2 | 3 | 4 | 5 |
		   ==========================
 		   value					  
 		   |  2| 19| 16| 39| 45|  4| 
		   ==========================
		 * */
		
		for (int i=0; i<lo.length; i++){
			System.out.print(lo[i]+" ");
		}
		
		
		
	} // main method

} // Math_6 class
