package a.b.c.ch5;


//사용자 정의 예외 클래스 
@SuppressWarnings("serial")
class IDFormatException extends Exception{
	
	// 생성자 
	public IDFormatException(String s){
		super(s);
	}
}

class IDFormatTest{
	
	private String userID;
	
	public String getUserID(){
		return userID;
	}

	public void setUserID(String userID) throws IDFormatException {
		
		if (userID == null){
			IDFormatException ide = new IDFormatException("아이디는 null일 수 없습니다.");
			throw ide;
		}else if (userID.length() < 8 || userID.length() > 20){
			throw new IDFormatException("아이디은 8 ~ 20자 이하 입니다.");
		}
		this.userID = userID;
	}
}

public class Exam_Throw_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDFormatTest idt = new IDFormatTest();

		String userID = null;
		try{
			idt.setUserID(userID);
		}catch (IDFormatException i){
			// System.out.println("i 에러가  >>> : " + i);
			System.out.println("i.getMessage()  >>> : " + i.getMessage());
			// i.printStackTrace();
		}

		userID = "1234567";
		try{
			idt.setUserID(userID);
		}catch (IDFormatException i){
			// System.out.println("i 에러가  >>> : " + i);
			System.out.println("i.getMessage()  >>> : " + i.getMessage());
			// i.printStackTrace();
		}

		System.out.println("try-catch 블럭 이후 >>> : ");
	}

}
