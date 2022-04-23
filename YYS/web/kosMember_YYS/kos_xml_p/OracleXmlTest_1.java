package a.b.c.test.xml_p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
// import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OracleXmlTest_1 {
	public static final String XML_FILE_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_web_yys\\eclipse_yys_work\\kosMember_YYS2\\WebContent\\kos_xml_p";
	// kos_xml 파일 경로를  상수로 지정합니다.
	public static final String XML_PROLOG="<?xml version='1.0' encoding='euc-kr'?>"; // 선언부
	// xml mime type을 상수로 지정합니다.

	public String getXml(final String tableName) throws Exception{
		Logger logger = LogManager.getLogger(OracleXmlTest_1.class);
		logger.info("4. getXml 함수 진입 >>> : 들어온 String tableName >>>> : " + tableName);
		// 4. getXml 함수 진입 >>> : 들어온 String tableName >>>> : emp
		
		// 사용할 지역변수 초기화
		Connection con = null;			
		Statement stmt = null;
		ResultSet rsRs = null;
				
		ResultSetMetaData resultMeta = null;		
		int colCount = 0;		
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
		/*
		 * Constructors
		  StringBuffer(String str)
		  
		  public StringBuffer(String str)
		   Constructs a string buffer initialized to the contents of the specified string. 
  	 	   The initial capacity of the string buffer is 16 plus the length of the string argument
		 */
		// XML_PROLOG : <?xml version='1.0' encoding='euc-kr'?>
		
		try{
			con = DBPropertyConn.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM "+ tableName);	
			logger.info("10. 입력한 쿼리문 >>> \n"+"SELECT * FROM "+ tableName);
			// 10. 입력한 쿼리문 >>> 
			// SELECT * FROM emp
			
			resultMeta = rsRs.getMetaData();
			/*
			 * java.sql.ResultSet
			 * .getMetaData()
			 * Modifier and Type :: Method and Description
			 * ResultSetMetaData :: getMetaData()
			 * 
			 * Retrieves the number, types and properties of this ResultSet object's columns.
			 * Returns:
			 * the description of this ResultSet object's columns
			 * */

			colCount = resultMeta.getColumnCount();
			/*
			 * java.sql.ResultSetMetaData
			 * .getColumnCount()
			 * 
			 * Modifier and Type :: Method and Description
			 * ResultSetMetaData :: getMetaData()
			 * 
			 * int :: getColumnCount()
			 * 
			 * Returns the number of columns in this ResultSet object.
			 * Returns:
			 * the number of columns
			 * */
			
			System.out.println("11. "+tableName + " 테이블 컬럼 카운드 >>> : " + colCount);
			//  11. emp 테이블 컬럼 카운드 >>> : 8
			
			strBuffer.append("\n");	
			strBuffer.append("<" +  tableName.toUpperCase() + ">");	
			// <EMP>로 루트 태그를 생성해줍니다.
			strBuffer.append("\n");	
			
			while (rsRs.next()){
				for ( int i=0; i < colCount; i++){
					strBuffer.append("<"+resultMeta.getColumnName(i+1)+ ">");
					// < 칼럼이름 >
					//  왜 i+1 부터?? 
					// Oracle DB에서 인덱스는 1부터 시작합니다.
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append("</"+resultMeta.getColumnName(i+1)+ ">");
					strBuffer.append("\n");
					// 예시 : 
					// <EMPNO>7369</EMPNO> \n
				}	
				// for문이 끝나면 다음 칼럼으로 넘어갑니다.
				// 예시. i=1로직이 시작 되면 for문안에서 StringBuffer 클래스안에
				// 다음 형식의 데이터를 담는다.
				// <ENAME>SMITH</ENAME> \n
				// 왜 String이 아닌 StringBuffer 클래스의 참조변수로 작업하나요?
				// 정보불변성 때문, String으로 concat 하면, 계속 객체를 만들어 붙이는 반면,
				// StringBuffer 클래스의 참조변수에 하면 객체 하나에 append로 이어붙일 수 있음.
			}		
			strBuffer.append("</" +  tableName.toUpperCase()  + ">");		
			// while문과 for문이 다 끝나고 나면 </EMP> 로 root 태그를 닫아줍니다.
			strBuffer.append("\n");				
		}catch(SQLException e) {
			System.out.println(" getXML() : "+e);
		}finally {}			
		
			return strBuffer.toString();
			// StringBuffer 클래스의 참조변수로 <EMP>....</EMP> 내용을 리턴해줍니다.
		}
	
	public static boolean xmlParse(String fileName, String xmlVal){
		Logger logger = LogManager.getLogger(OracleXmlTest_1.class);
		logger.info("13. xmlParse 함수 진입 :: fileName >>> : "+fileName+"xmlVal >>> : "+xmlVal);
		// 13. xmlParse 함수 진입 :: fileName >>> : empxmlVal >>> : <?xml version='1.0' encoding='euc-kr'?>
		// <EMP>
		// .....
		// </EMP>
		
		boolean bool = false;
		
		try {
			
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(OracleXmlTest_1.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			// kos_xml 파일 경로 + / + filname(emp)  + .xml
			// emp.xml을 지정된 파일경로에 쓰라는 로직
			
			/*
			 * java.io.FileWriter
			 * Constructor Detail
			 * FileWriter(String filename)
			 * Constructs a FileWriter object given a file name
			 * 
			 * Parameters:
			 * fileName - String The system-dependent filename.
			 * 
			 * java.io.BufferedWriter
			 * BufferedWriter(Writer out)
			 * 
			 * Creates a buffered character-output stream 
			 * that uses a default-sized output buffer.
			 * 
			 * Parameters:
			 * out - A Writer
			 * */
			
			bw.write(xmlVal);
			// java.io.Writer
			// Modifier and Type :: Method and Description
			// void :: write(String str)
			// Writes a string.
			// Parameters:
			// str - String to be written
			bw.flush();
			bw.close(); //무조건 닫아줘야한다.
			
			bool = true;
		}catch(IOException e){
			System.err.println(e);
			// java.lang.System
			// Field Summary
			// Modifier and type :: Filed and Description
			// static PrintStream :: err
			// The "standard" error output stream.
		}
		
		return bool;
	}
	
	public boolean makeXml(final String tableName) {
		// 들어온 인수를 매개변수에서 final로 세팅합니다.
		Logger logger = LogManager.getLogger(OracleXmlTest_1.class);
		logger.info("3. makeXml 함수 시작 >>> : ");
		// 3. makeXml 함수 시작 >>> : 
		logger.info("makeXml으로 들어온 매개변수  >>> : "+tableName);
		// makeXml으로 들어온 매개변수  >>> : emp
		boolean bool = false;
		// boolean 타입의 bool을 초기값으로 초기화 합니다
		
		try{		
			
			if(tableName.length() > 0){	
				// tableName에 아무 값도 입력되지 않았으면, 수행되지 않는 로직입니다.
				// tableName으로 입력한 값 : emp
				
				final String fileName = tableName; 
				// 매개변수를 지역변수에서 다시 한 번 final로 세팅합니다.
				
				String xmlVal = getXml(fileName);
				// OracleXmlTest_1 클래스의 getXml 함수에 fileName을 인수로 다시 입력합니다.
				// getXml 함수 로직이 성공적으로 끝났으면 <EMP>...</EMP>
				// 내용을 String 클래스의 xmlVal 변수로 받아옵니다.
				
				System.out.println("12. Oralce String Data를 xml로 생성 >>> : \n" + xmlVal);
				// 받아온 내용을 출력시킵니다.
				// 12. Oralce String Data를 xml로 생성 >>> : 
				// <?xml version='1.0' encoding='euc-kr'?>
				// <EMP>
				// .....
				// </EMP>
				
				if (xmlVal !=null && xmlVal.length() > 0){
					// 받아온 xmlVal 변수가 null이거나 변수의 길이가 0이면 수행되지 않는 로직입니다.
					
					bool = OracleXmlTest_1.xmlParse(fileName, xmlVal);
					// 13. OracleXmlTest_1 클래스의 getXml 함수에 fileName과 xmlVal을 인수로 다시 입력합니다.
					// fileName : EMP
					// xmlVal : <EMP>....</EMP>
					
					if (bool){

						System.out.println("14. "+OracleXmlTest_1.XML_FILE_PATH +" 디렉토리에 " + fileName +".xml 파일이 잘 생성 되었습니다. ");
						// 파일을 다 쓰고 나면, bool이 true가 된다. 
						// 이 떄, if문으로 와서, 해당 경로에 파일이 잘 생성됨을  출력시켜준다.
						// 14. C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\kosMember_YYS2\WebContent\kos_xml_p 디렉토리에 emp.xml 파일이 잘 생성 되었습니다. 
					}else{
						System.out.println(" 파일이 생성 되지 않았습니다. ");
					}	
				}
			}else{	
				System.out.println("java OracleXmlTest 테이블이름 ");
			}				
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}	
		
		// 로직이 잘 수행 되면, bool이 true로 리턴된다.
		return bool;
	}
	
	/*
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(OracleXmlTest_1.class);
		logger.info("1. main 함수 시작 >>> : ");
		try{					
			Scanner sc = new Scanner(System.in);
			System.out.println("테이블 이름을 KEY-IN 하시오 >>> : ");
			String tableName = sc.next();
			logger.info("2. tableName >>> : "+tableName);
			
			OracleXmlTest_1 ot_1 = new OracleXmlTest_1();
			if(tableName.length() > 0){		
				boolean bool = ot_1.makeXml(tableName);
				// OracleXmlTest_1 클래스에 makeXml 함수에 인수로 tableName을 입력하라.
				logger.info("15. main함수 boolean bool>>> : "+bool);
			}else{	
				System.out.println("java OracleXmlTest 테이블이름 ");
			}				
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}	
	}
	*/
} // end of OracleXmlTest_1
