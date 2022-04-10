package a.b.c.prac1;

public class Exam_EqualsTest {
// String의 equals 와 Object의 equals 차이 비교해보기
	public void objTest(Object obj_1, Object obj_2){
		boolean bool_obj;
		System.out.println("\n 3. obj_1 참조변수 주소값(o) >>> : "+obj_1);
		System.out.println("\n 4. obj_2 참조변수 주소값(o1) >>> : "+obj_2);
		System.out.println("\n 5. obj_1의 identityHashcode(진수의 차이일뿐) >>> : "+System.identityHashCode(obj_1));
		System.out.println("\n 6. obj_2의 identityHashcode(진수의 차이일뿐) >>> : "+System.identityHashCode(obj_2));
		
		bool_obj=obj_1.equals(obj_2);
		System.out.println("\n 7. objTest 결과  >>> : "+bool_obj);
	}
	
	public void strTest(String str_1, String str_2){
		boolean bool_str;
		System.out.println("\n 8. str_1 >>> : "+System.identityHashCode(str_1));
		System.out.println("\n 9. str_2 >>> : "+System.identityHashCode(str_2));
		bool_str=str_1.equals(str_2);
		/*
		for (int i=0; i<5; i++){
			System.out.println("JAVA에서는 문자열 비교시 == 상등 연산자 사용 금지");
			System.out.println("자바스크립트에서는 == 상등연산자 가능");
		}
		*/
		System.out.println("\n 10. strTest 결과 >>> : "+bool_str);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. main method 시작 ");
		Object o=new Object();
		Object o1=new Object();
		String s="abc";
		String s1="abc";

		Exam_EqualsTest et=new Exam_EqualsTest();
		System.out.println("2. Exam_EqualsTest et >>> : "+et);
		et.objTest(o, o1);
		et.strTest(s, s1);
	}

}
