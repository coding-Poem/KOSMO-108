package a.b.c.prac1;

public class Tostring_p {
	
	@Override
	public String toString(){
		return "java.lang.Object 클래스에서 오버라이딩한 toString() 함수이다.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tostring_p tp=new Tostring_p();
		// Tostring_p 클래스에서 객체를 생성했기 때문에
		// 현재 클래스에서 Override한 내용이 출력된다.
		System.out.println("\n 1. ToString_p tp 참조변수 주소값  >>> : "+tp);
		// 해당 클래스에서 Override한 내용이 출력됨.
		System.out.println("\n 2. tp.toString() 참조변수 주소값 >>> : "+tp.toString());
		// toString 메서드를 현재 클래스에서 정의를 했기 때문에, Override된 내용이 출력된다.
		
		/*
		 * Tip
		 * 참조변수 주소값  >>>  하고 참조변수를 출력한 것과
		 * 참조변수.toString >>> 한 것과 결과가 같다.
		 * 이유는 참조변수(.toString)이 생략되었기 때문이다.
		 * */
		System.out.println("\n 3. tp.getClass().getName() >>> : "+tp.getClass().getName());
		// 해당클래스의 Name Space가 출력된다. Name Space는 패키지이름.클래스이름
		
		TostringVO etvo=new TostringVO("VELOG",30);
		// ToStringVO 클래스에서 객체를 생성했는데,
		// ToStringVO 클래스에 Override한 내용이 출력된다.
		System.out.println("\n 4. etvo >>> : "+etvo);
		System.out.println("\n 5. etvo.toString >>> : "+etvo.toString());
	}
}
