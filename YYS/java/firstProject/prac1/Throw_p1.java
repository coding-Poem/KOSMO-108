package a.b.c.prac1;

// 사용자 정의 예외 클래스
@SuppressWarnings("serial")
class IDFormatException extends Exception{
/* The serializable class IDFormatException
 * does not declare a static final serialVersionUID
 * filed of type long
 * 
 * 해결방법 @SuppressWarnings("serial")
 * 무시하라는 뜻
 */
	
	//생성자
	public IDFormatException(String s) {
		super(s);
		// 에러 내용 s를 부모인 Exception으로 보내라.
	}
}

// IDFormatTest 사용자 정의 클래스
class IDFormatTest{
		
		private String userID;
		// private 변수
		
		public String getUserID(){
			return userID;
		}
		// getUserID() 함수
		// 매개변수에 String 들어와야 하고, 
		// return값의 데이터 자료형도 String
		
		public void setUserID(String userID) throws IDFormatException{
			boolean aBool= userID==null;
			// String인데 equals를 사용하지 않는 이유????
			// 생각을 해보자. String.equlas(String)은
			// 문자열을 비교하는 함수이다. "null"인지가 궁금한게 아니라, null인지가 궁금한 것이다.
			// 그렇기 때문에 ==(상등 연산자 쓴 듯)???
			System.out.println("userID==null >>> "+aBool);
			// 그래도 혹시 모르니 boolean 연산자로 출력시키고 확인하기
			if (userID==null){
				IDFormatException ide=new IDFormatException("아이디는 null일 수 없습니다.");
				throw ide;
			}else if (userID.length() < 8 || userID.length() >20){
				throw new IDFormatException("아이디는 8~20자 이하 입니다.");
			}
			this.userID = userID;	
		} // setUserID method
} // IDFormatTest class
	
public class Throw_p1 {
	// main 함수가 있는 클래스 (첫 시작점)
	public static void main(String[] args) {
		IDFormatTest idt=new IDFormatTest();
		
		String userID = null;
		try {
			idt.setUserID(userID);
			// IDFormatTest 클래스에 있는 setUserID 메서드
		}catch(IDFormatException i){
			// 예외 처리를 Exception 클래스의 상속을 받은
			// 사용자 정의 예외 클래스 IDFormatException에서 처리해라.
			System.out.println("i.getMessage() >>> : "+i.getMessage());	
			// error message를 예외문에서 출력하세요.
		}
		
		userID="1234567";
		try {
			idt.setUserID(userID);
			// IDFormatTest 클래스에 있는 setUserID 메서드
		}catch(IDFormatException i){
			System.out.println("i.getMessage() >>> : "+i.getMessage());
			// error message를 예외문에서 출력하세요.
		}
		
		System.out.println("\n try-catch 끝");
	} // main method
} // Throw_p1 class
