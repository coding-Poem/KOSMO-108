package a.b.c.ch2.common;

public abstract class Exam_Constant {

	// 상수 Constant :: 변하지 않는 값 :: 변경하면 않되는 값
	/*
		1. 변경하면 않되는 값
		2. 상수는 클래스가 로드할 때 맨 먼저 메모리에 로드된다.(상수 풀, Constant Pool)
		3. 상수는 클래스 블럭 맨 위에 작성한다.
		4. 가능한 웬만하면 상수로 만들어서 사용한다. 
	*/
	// 업로드 
	public static final String FILE_UPLOAD_PATH = "C:\\00.KOSMO108\\30.Web\\fileUpload";
	public static final String IMG_UPLOAD_PATH = "C:/00.KOSMO108/30.Web/imgUpload";
	public static final int FILE_UPLOAD_SIZE = 10 * 1024 * 1024; // 10메가 
	public static final int IMG_UPLOAD_SIZE = 10 * 1024 * 1024; // 10메가 

	// JDBC 연결
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PWD = "tiger";
}