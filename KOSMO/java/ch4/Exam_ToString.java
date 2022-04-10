package a.b.c.ch4;

public class Exam_ToString extends Object{

	// java.lang.Object 클래스에 있는 toString 함수를 오버라이딩 해서 
	// java.lang.Object 클래스에서 Exam_ToString 클래스로 toString() 함수가 이사 왔다.
	// 이사온 표현을 @Override 오버라이드 어노테이션으로 표기 한다. 
	// 이사오기전  toString() 함수의 리턴 값  getClass().getName() + '@' + Integer.toHexString(hashCode())
	// 을 
	// 이사온 toString() 함수 블럭에서 
	// "java.lang.Object 클래스에서 오버라이딩한 toString() 함수이다." 으로 변경한다 : 재정의한다.
	// Exam_ToString 클래스를 사용하는 블럭에서 toString() 함수를 호출하면 이후 부터는 
	// getClass().getName() + '@' + Integer.toHexString(hashCode()) 값이 아니고 
	// "java.lang.Object 클래스에서 오버라이딩한 toString() 함수이다." 값이 리턴 된다.
	@Override
	public String toString() {
		// getClass().getName() + '@' + Integer.toHexString(hashCode())
		return "java.lang.Object 클래스에서 오버라이딩한 toString() 함수이다.";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Exam_ToString et 참조변수로 인스턴스 했다. 
		Exam_ToString et = new Exam_ToString();
		// et 참조변수에 toString() 함수가 생략 되어 있다. 
		System.out.println("et 참조변수 주소값  >>> : " + et);
		//                     getClass().getName() + '@' + Integer.toHexString(hashCode())
		// et 참조변수 주소값  >>> : a.b.c.ch4.Exam_ToString@15db9742
		System.out.println("et.toString() 참조변수 주소값  >>> : " + et.toString());
		System.out.println("et.getClass().getName()  >>> : " + et.getClass().getName());
		
		// Exam_ToStringVO 호출하기 
		Exam_ToStringVO etvo = new Exam_ToStringVO("박건원", 30);
		// et 참조변수에 toString() 함수가 생략 되어 있다.		
		System.out.println("etvo >>> : " + etvo);
		System.out.println("etvo.toString() >>> : " + etvo.toString());		
	}
}
