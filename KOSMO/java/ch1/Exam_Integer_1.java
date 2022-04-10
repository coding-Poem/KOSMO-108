package a.b.c.ch1;

/*
public static final int	BYTES		4
public static final int	MAX_VALUE	2147483647
public static final int	MIN_VALUE	-2147483648
public static final int	SIZE		32

변수를 선언해서 각각의 값을 초기화 해서 콘솔에 출력하시오 
변수명은 개발자 알아서 만들어 보기 
*/

public class Exam_Integer_1{

	public static void main(String args[]) {
		int intBytes = Integer.BYTES;		
		/*
		Class Integer.BYTES 
		The number of bytes used to represent a int value in two's complement
		binary form

		1. int 데이터형(자료형)을 선언 : MAX_VALUE 변수의 데이터형(자료형)이 int 이기 때문에 
		2. int 형 데이터를 담을 변수명 intMax 을 선언 : 변수명은 직관적으로 이해하기 쉽게 명명한다.
		3. = : 대입 연산자 선언 
		4. Integer.MAX_VALUE : int 형 데이터의 바이트 크기를 가지고 있는 Integer 래퍼 클래스의 MAX_VALUE 상수 이다. 
							  여기에  int 형 2147483647 값이 초기화 되어 있다. 	
		*/
		int intMax = Integer.MAX_VALUE;
		
		/*
		Class Integer.MAX_VALUE
		A constant holding the maximum value an int can have 2^31-1.

		1. int 데이터형(자료형)을 선언 : MAX_VALUE 변수의 데이터형(자료형)이 int 이기 때문에 
		2. int 형 데이터를 담을 변수명 intMax 을 선언 : 변수명은 직관적으로 이해하기 쉽게 명명한다.
		3. = : 대입 연산자 선언 
		4. Integer.MAX_VALUE : int 형 데이터의 바이트 크기를 가지고 있는 Integer 래퍼 클래스의 MAX_VALUE 상수 이다. 
							  여기에  int 형 2147483647 값이 초기화 되어 있다. 

		*/
		int intMin = Integer.MIN_VALUE;
		
		/*
		Class Integer.MIN_VALUE
		A constant holding the minimum value an int can have -2^31

		1. int 데이터형(자료형)을 선언 : MIN_VALUE 변수의 데이터형(자료형)이 int 이기 때문에 
		2. int 형 데이터를 담을 변수명 intMin 을 선언 : 변수명은 직관적으로 이해하기 쉽게 명명한다.
		3. = : 대입 연산자 선언 
		4. Integer.MIN_VALUE : int 형 데이터의 바이트 크기를 가지고 있는 Integer 래퍼 클래스의 MIN_VALUE 상수 이다. 
							  여기에  int 형 -2147483648 값이 초기화 되어 있다.	
		*/
		int intBits = Integer.SIZE;
		/*
		Class Integer.SIZE
		The number of bits used to represent an int value in two's complement
		binary form.

		1. int 데이터형(자료형)을 선언 : SIZE 변수의 데이터형(자료형)이 int 이기 때문에 
		2. int 형 데이터를 담을 변수명 intBits 을 선언 : 변수명은 직관적으로 이해하기 쉽게 명명한다.
		3. = : 대입 연산자 선언 
		4. Integer.SIZE : int 형 데이터의 바이트 크기를 가지고 있는 Integer 래퍼 클래스의 SIZE 상수 이다. 
						  여기에  int 형 비트 크기가  32 비트로 초기화 되어 있다. 
		*/

		System.out.println("int intBytes >>> : " + intBytes);
		System.out.println("int intMax >>> : " + intMax);
		System.out.println("int intMin >>> : " + intMin);
		System.out.println("int intBits >>> : " + intBits);
	}
}


