package a.b.c.prac1;

public class Math_p2 {

	public static void main(String[] args) {
		double d;
		int it;
		for (int i=0; i<1; i++){
			d=Math.random();
			// 컴퓨터가 난수를 발생하는게 아니라, 난수표에 따라 출력
			// Math.random() 명령어가 실행될 때마다 random 값이 나온다.
			System.out.println(i+"번째 random 값 >>> "+d);
			System.out.println(i+"번째 random 값*10 >>> "+d*10);
			System.out.println(i+"번째 random 값*100 >>> "+d*100);
			
			// int 형변환 해보기
			it = (int)(Math.random()*10);
			System.out.println("it >>> (int)(Math.random()*10) >>> "+it);
			it = (int)(Math.random()*100);
			System.out.println("it >>> (int)(Math.random()*100) >>> "+it);
			// 70
			it = (int)(Math.random()*100);
			System.out.println("it >>> (int)(Math.random()*100) >>> "+it);
			// 같은  명령어여도 다른 결과 Math.random()때문 : 12
		}
	}
}
