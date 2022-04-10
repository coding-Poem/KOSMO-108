package a.b.c.ch1;

/*
1. import 규칙 : 
	java.lang.* 패키지에 있는 클래스를 
	제외한 모든 패키지에서는 꼭 import 키워드를 사용해야 한다.
2. import 할 때는 패키지명.클래스이름 으로 사용해야 한다. <-- 이유 : 소스 코드 가독성 때문에 
3. 빌트인 클래스의 참조변수에는 주소값이 보여주는 경우 있고 아니 경우도 있다.
4. 클래스를 메모리에 올리는 동작은 new 키워드 말고도 다른 것들이 여러가지가 있다(앞으로 공부해야 한다). 
*/
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Exam_FlowControl_5 {

	public int add(int x, int y) {		
		return x + y;
	}

	public static void main(String args[]) {

		Date d = new Date();
		// public static int identityHashCode(Object x)
		System.out.println("System.identityHashCode(d) >>> : " 
								+ System.identityHashCode(d));
		System.out.println("d >>> : " + d + "\n");

		Calendar c = Calendar.getInstance();
		System.out.println("System.identityHashCode(c) >>> : " 
								+ System.identityHashCode(c));
		System.out.println("c >>> : " + c + "\n");

		System.out.println("연산할 수를 잘 입력하시오 >>> : ");
		// public static final InputStream in
		Scanner sc = new Scanner(System.in);
		System.out.println("sc >>> : " + sc);
		// public int nextInt()
		int x = sc.nextInt();
		// public static final PrintStream out
		System.out.println("x >>> : " + x);
		int y = sc.nextInt();
		System.out.println("y >>> : " + y);

		Exam_FlowControl_5 ef5 = new Exam_FlowControl_5();
		
		int addSum = ef5.add(x, y);
		
		System.out.println("addSum >>> : " + addSum);
	}
}
/*
C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_5
연산할 수를 잘 입력하시오 >>> :
1
x >>> : 1
2
y >>> : 2
addSum >>> : 3
*/
