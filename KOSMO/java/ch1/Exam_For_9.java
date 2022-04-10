package a.b.c.ch1;

public class Exam_For_9 {

	public static void main(String args[]) {

		for (int j=1; j <= 9; j++){
			System.out.println();

			for (int i=2; i <= 5; i++){
				/*		
				java.util.PrintStream
				public PrintStream format(String format,
										Object... args)

				java.lang.String
				public static String format(String format,
											Object... args)
				*/
				System.out.format("%d x %d = %2d  ", i, j, i * j);
			}
		}		
		System.out.println();

		
		for (int j=1; j <= 9; j++){
			System.out.println();

			for (int i=6; i <= 9; i++){
				/*
				public PrintStream printf(String format, Object... args)
				String format : "%d x %d = %2d  "
				Object... args : i, j, i * j
				*/
				System.out.printf("%d x %d = %2d  ", i, j, i * j);
			}
		}		
	}
}
/*
	서식 지정자 format specifier
		%d		정수형 출력
		%s		문자형 출력
		%f		실수형 출력
		%o		8진수 출력
		%x, %X	16진수 출력
		%e, %E	지수 출력
		%c		문자 출력
		%n		줄 바꿈
		%b		boolean 출력
*/