package a.b.c.prac1;

import java.util.Scanner;

/*
 * 미션 : 지금 현재 주소 부터 집까지 거리 계산하기
 * x1 출발지 위도, x2 도착지 위도
 * y1 출발지 경도, y2 도착지 경도
*/

public class FromhereTohome {
	static double degree2radius(double degree){
		// System.out.println("degree2radius 함수 시작 ");
		// System.out.print("\n degree : "+degree+"\n");
		double d=degree*(Math.PI/180);
		d=Math.abs(d);
		// System.out.println("d >>> "+d);
		return d; 
	}
	
	static double haversine(double x1, double y1, double x2, double y2){
		/*
		System.out.println("harversine 함수 시작 \n");
		System.out.print("출발지 위도 >>> "+x1);
		System.out.println();
		System.out.print("출발지 경도 >>> "+y1);
		System.out.println();
		System.out.print("도착지 위도 >>> "+x2);
		System.out.println();
		System.out.print("도착지 경도 >>> "+y2);
		System.out.println();
		*/
		double r=0;
		double x_d=0;
		double y_d=0;
		double x_d_1=0;
		double y_d_1=0;
		double a=0;
		double b=0;
		double c=0;
		double c1=0;
		double c2=0;
		double h=0;
		String s;
		double dis=0;
		double y11=0;
		double y22=0;
		
		r=6371;
		// 지구의 반경(단위 : km)
		
		x_d=x2-x1;
		y_d=y2-y1;
		
		x_d_1=degree2radius(x_d);
		// dLon
		y_d_1=degree2radius(y_d);
		// dLat
		
		y11=degree2radius(y1);
		y22=degree2radius(y2);
		
		a=Math.sin(y_d_1/2.0)*Math.sin(y_d_1/2.0);
		b=Math.cos(y11)*Math.cos(y22)*Math.sin(x_d_1/2.0)*Math.sin(x_d_1/2.0);
		c=a+b;
		
		
		c1=Math.sqrt(c);
		c2=Math.sqrt(1.0-c);
		
		h=2*Math.atan2(c1, c2);
		h=r*h;
		//s=String.format("%.5f", h);
		//dis=Double.parseDouble(s);
		
		return h;
	}
	
	public static void main(String[] args) {
		double x1=0;
		double y1=0;
		double x2=0;
		double y2=0;
		double distance=0;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("출발지의 위도를 입력하여 주세요.");
		try {
			x1=sc.nextDouble();
			System.out.println("출발지의 경도를 입력하여 주세요.");
			sc.nextLine();
			y1=sc.nextDouble();
			System.out.println("도착지의 위도를 입력하여 주세요.");
			x2=sc.nextDouble();
			System.out.println("도착지의 경도를 입력하여 주세요.");
			y2=sc.nextDouble();
			
			distance=haversine(x1, y1, x2, y2);
			System.out.println("출발지 부터 도착지까지의 거리는 "+distance+" km 입니다.");
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println("잘못 입력하셨습니다.");
			
		}finally{
			System.out.println("거리 구하기 프로그램을 종료합니다.");
			sc.close();
		
		}
	}
}
