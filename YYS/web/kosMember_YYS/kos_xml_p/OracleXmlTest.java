package a.b.c.test.xml_p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class OracleXmlTest {
	public static final String XML_FILE_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_web_yys\\eclipse_yys_work\\kosMember_YYS2\\WebContent\\kos_xml";
	public static final String XML_PROLOG="<?xml version='1.0' encoding='euc-kr'?>"; // 선언부
	public String getXml(final String tableName) throws Exception{
		Logger logger = LogManager.getLogger(OracleXmlTest.class);
		logger.info("3. getXml 함수 시작 >>> : ");
		// 3. getXml 함수 시작 >>> :
		logger.info("4. String tableName >>>> : "+tableName);
		// 4. String tableName >>>> : emp
		// 5번은 DBPropertyConn.java 에서 출력된다.
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rsRs=null;
		
		ResultSetMetaData resultMeta=null;
		int colCount=0;
		
		StringBuffer strBuffer=new StringBuffer(XML_PROLOG);
		// XML_PROLOG >>> <?xml version='1.0' encoding='euc-kr'?> 
		// xml 선언부
		
		try{
			// /src/db.properties 화일을 읽어서 데이터소스를 만들어서 jdbc 연결을 한다. 
			con = DBPropertyConn.getConnection();
			// DBPropertyConn 클래스의 getConnection 함수 호출
			logger.info("10. con >>> : "+con);
			// 10. con >>> : oracle.jdbc.driver.T4CConnection@27ddd392
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM "+ tableName);	
			
			resultMeta = rsRs.getMetaData();

			colCount = resultMeta.getColumnCount();
			logger.info("11. colCount >>> : "+colCount);
			// 11. colCount >>> : 8
			System.out.println("12. "+tableName + " 테이블 컬럼 카운드 >>> : " + colCount);
			// 12. emp 테이블 컬럼 카운드 >>> : 8
			
			strBuffer.append("\n");	
			strBuffer.append("<" +  tableName.toUpperCase() + ">");		
			strBuffer.append("\n");	
	
			while (rsRs.next()){
				for ( int i=0; i < colCount; i++){
					strBuffer.append("<"+resultMeta.getColumnName(i+1)+ ">");
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append("</"+resultMeta.getColumnName(i+1)+ ">");
					strBuffer.append("\n");
				}				
			}		
			strBuffer.append("</" +  tableName.toUpperCase()  + ">");		
			strBuffer.append("\n");				
		}catch(SQLException e) {
			System.out.println(" getXML() : "+e);
		}finally {}			
		
		return strBuffer.toString();
	}
	
	public static boolean xmlParse(String fileName, String xmlVal){
		Logger logger = LogManager.getLogger(OracleXmlTest.class);
		logger.info("15. xmlParse 함수 시작 >>> : ");
		// 15. xmlParse 함수 시작 >>> : 
		logger.info("16. xmlParse 함수의 매개변수 fileName >>> : "+fileName);
		// 16. xmlParse 함수의 매개변수 fileName >>> : emp
		logger.info("17. xmlParse 함수의 매개변수 xmlVal >>> : "+xmlVal);
		// 17. xmlParse 함수의 매개변수 xmlVal >>> : <?xml version='1.0' encoding='euc-kr'?>
		// xml데이터가 주르륵 나온다.
		
		boolean bool = false;
		
		try {
			
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(OracleXmlTest.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			bw.write(xmlVal);
			bw.flush();
			bw.close(); //무조건 닫아줘야한다.
			
			bool = true;
		}catch(IOException e){
			System.err.println(e);
		}
		
		return bool;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Logger logger = LogManager.getLogger(OracleXmlTest.class);
			OracleXmlTest ox = new OracleXmlTest();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("테이블 이름을 KEY-IN 하시오 >>> : ");
			// emp 로 입력하였다.
			String tableName = sc.next();
			logger.info("1. tableName >>> : "+tableName);
			// 1. tableName >>> : emp
			
			logger.info("2. tableName.length >>> : "+tableName.length());
			// 2. tableName.length >>> : 3
			if(tableName.length() > 0){	
				// 아무 table 이름 값도 입력하지 않았을 시 수행되지 않는다.
				
				final String fileName = tableName; 
				// tableName이 변하지 않게 final 변수로 아예 지정한다.
				
				String xmlVal = ox.getXml(fileName);
				// OracleXmlTest 클래스에 getXml 함수에 fileName인 emp를 매개변수로 입력하라.
				
				System.out.println("13. Oralce String Data를 xml로 생성 >>> : \n" + xmlVal);
				// 13. Oralce String Data를 xml로 생성 >>> : 
				// <?xml version='1.0' encoding='euc-kr'?>
				// xml 데이터가 주르륵 나온다.
		
				logger.info("14. xmlVal >>> : "+xmlVal);
				// 14. xmlVal >>> : <?xml version='1.0' encoding='euc-kr'?>
				// xml 데이터가 주르륵 나온다.
				
				if (xmlVal !=null && xmlVal.length() > 0){
					
					boolean bool = xmlParse(fileName, xmlVal);
					// // OracleXmlTest 클래스에 xmlParse 함수에 fileName인 emp를 매개변수로 입력하라.
					// 그리고, xmlVal <?xml version='1.0' encoding='euc-kr'?>으로부터 주르륵 있는 xml문서 형식
					// 을 인수로 입력해라.
					
					logger.info("18. bool >>> : "+bool);
					// 18. bool >>> : true
					if (bool){
						System.out.println("19. "+OracleXmlTest.XML_FILE_PATH +" 디렉토리에 " + fileName +".xml 파일이 잘 생성 되었습니다. ");
						// 19. C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\kosMember_YYS2\WebContent\kos_xml 디렉토리에 emp.xml 파일이 잘 생성 되었습니다.  
						logger.info("20. fileName >>> : "+fileName);
						// 20. fileName >>> : emp
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
	}
} // end of OracleXmlTest
