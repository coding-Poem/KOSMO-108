package a.b.c.ch1;

public class Exam_Operator_1 {

	public boolean idCheck(String id, String pw){

		// 지역변수는 그 자료형의 default  값으로 초기화 해서 사용한다.
		boolean bool = false;

		if ( id !=null && id.length() > 0 
			&&	pw !=null && pw.length() > 0) {

			System.out.println("3333 Exam_Operator_1.idCheck ::: id >>> : " + id);
			System.out.println("4444 Exam_Operator_1.idCheck ::: pw >>> : " + pw);
			
			if ("PGW".equals(id) && "PGW00".equals(pw)){

				// 5555
				bool = true;
				System.out.println("5555 Exam_Operator_1.idCheck ::: if bool  >>> : " + bool);
			}
		}

		System.out.println("6666 Exam_Operator_1.idCheck ::: bool >>> : " + bool);
		
		return bool;
	}

	public static void main(String args[]) {
	
		// String s0 = "";
		// String s1 = null;

		// String id, password 변수 초기화 
		String id = "PGW";
		String password = "PGW00";

		// 문자열 null 체크는 하기와 같이 한다.
		// id !=null : id 의 값이 null 아니어야 한다. 꼭 값이 있어야 해요
		// id.length() > 0 : id 의 값이 빈 문자열이 아니어야한다. 값이 꼭 있어야 한다.
		// id = ""; id.lenghth() = 0;
		// id !=null && 

		// if 문에서 id, password 값이 있는지 체크
		// if 문은 값이 있을 때만 수행 된다. 
		if (	id !=null && id.length() > 0 
			&&	password !=null && password.length() > 0) {

			System.out.println("1111 Exam_Operator_1.main ::: id >>> : " + id);
			System.out.println("2222 Exam_Operator_1.main ::: password >>> : " + password);

			Exam_Operator_1 eo1 = new Exam_Operator_1();

			// public boolean idCheck(String id, String pw)

			// idCheck(id, password); 함수 호출 
			boolean bool = eo1.idCheck(id, password);
			System.out.println("7777 Exam_Operator_1.main ::: bool >>> : " + bool);

			if (bool){
				System.out.println("8888 로그인 성공 >>> : ");
			}else{
				System.out.println("로그인 실패 성공 >>>  :");
			}
		}else{
			System.out.println("아이디 패스워드를 잘 입력 하시오 >>> : ");
		}
	}
}