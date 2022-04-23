package a.b.c.test.xml;

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

public class OracleXmlTest_1 {
	
	// C:\00.KOSMO108\30.Web\eclipse_work_hbe_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember\kos_xml	
	public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml";
	
	// public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_work_hbe_work\\kosMember\\WebContent\\kos_xml";
	public static final String XML_PROLOG = "<?xml version='1.0' encoding='euc-kr'?>";
	
	public String getXml(final String tableName) throws Exception{
		
		// 7. 테이블 이름을 잘 받았는지 출력해본다. - 로그 찍기
		System.out.println("	String tableName 은 ?	>>> : " + tableName);
		
		// 8. 이거는 데이터베이스에 연결하기 전 null값으로 초기화 해주는 것이다.
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		// 9. ResultSetMetaData 는 SQL로 받아온 데이터의 정보를 조회 및 출력하는 용도로 사용한다.
		ResultSetMetaData resultMeta = null;
		int colCount = 0;
		
		// 원래 String 클래스의 인스턴스는 한번 생성돼면 그 값을 읽기만 하고 변경할 수 없다.
		// 그러나 StringBuffer 클래스의 인스턴스는 그 값을 변경할 수 있다.
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
		
		try {
			
			// 10. 여기서부터는 데이터베이스 SQL과 연결하는 것
			con = DBPropertyConn.getConnection();
			
		
			stmt = con.createStatement();
			// 11. 이거는 SELECT * FROM EMP - EMP 테이블 전체 검색하는 것
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);
			
			resultMeta = rsRs.getMetaData();
			
			// colCount : empno ename 등 항목이 총 몇개있는지 그 수를 적어본 것이다.
			colCount = resultMeta.getColumnCount();
			
			System.out.println("	" + tableName + " 테이블 컬럼 카운트는 ?	>>> : " + colCount);
			
			// 12. 스트링버퍼 클래스를 이용해서 문자열을 합친다.
			/*
			 	
			 	<테이블이름.대문자로> 이렇게 된다.
			 	
			 */
			strBuffer.append("\n");
			strBuffer.append("<" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
			
			while (rsRs.next()) {
				
				// 13. 여기서는 로우라는 문자를 받았다.
				strBuffer.append("\n");
				strBuffer.append("<" +  "ROW" + ">");
				
				for ( int i = 0; i < colCount; i++ ) {
					
					// 14. 여기서는 for문을 이용해서 해당 테이블에 들어가있는 컬럼의 정보를 가져온다.
					// 컬럼네임  + 해당 정보 + /컬럼네임 이렇게 나온다.
					strBuffer.append("<" + resultMeta.getColumnName(i+1) + ">");
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append("</" + resultMeta.getColumnName(i+1) + ">");
					strBuffer.append("\n");
				}
				
				// 15. 그 다음 어펜드를 통해 해당 문자열을 합쳐준다.
				// 여기서는 /row 닫는 로우를 작성했다.
				strBuffer.append("</" +  "ROW" + ">");	
				strBuffer.append("\n");
			}
				
			// 16. 그 다음에 /EMP를 통해 해당 칼럼을 닫는 문자열을 어펜드 해서 선언한다.
			strBuffer.append("</" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
			
		} catch (SQLException e) {
			
			System.out.println("	getXML() 은 ?	>>> : " + e);
			
		} finally {
			
			
		}
		
		// 17. 리턴 값으로 strBuffer값을 받아온다.
		return strBuffer.toString();
		
	}
	
	public static boolean xmlParse(String fileName, String xmlVal) {
		
		// 20. 여기서 bool 값은 false로 지정한다.
		boolean bool = false;
		
		try {
			
			// BufferedWriter는 간단하게 생각하면 System.out.println()이다.
			// 즉 버퍼를 이용하기 때문에 많은 양의 출력때 많이 사용한다.
			BufferedWriter bw = new BufferedWriter(
				
			// 21. 이거는 새로 xml파일을 만드는 것!
			// C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml
			// 이 위치 아래에 /파일이름.소문자.xml로 xml 파일을 만든다.
			new FileWriter(OracleXmlTest.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			bw.write(xmlVal);
			bw.flush();
			// 그리고 반드시 닫아줘야 한다!!
			// 이유는 몰라.
			bw.close();
			
			// 22. 처음 지정한 bool의 값을 true로 정한다.
			bool = true;
			
		} catch(IOException e) {
			
			System.out.println("	오류가 도착해슴!	>>> : " + e.getMessage());
			
		}
		
		// 23. bool 값을 리턴한다.
		return bool;
		
	}
	
	public boolean makeXml(final String tableName) {
			
			// 5. 일단 지역변수 bool은 false이다.
			boolean bool = false;
			
			try{		
				
				// 여기서 테이블의 길이가 0보다 큰 경우 = null값이 아닌 경우
				if(tableName.length() > 0){		
					
					// 6. final 상수(변하지 않는 수)로 선언한다.
					// final은 중복을 막기 위한 수단이라고 생각한다.					
					final String fileName = tableName; 
					
					System.out.println("	fileName 은 ?	>>> : " + fileName);
					
					// 18. xmlVal이 17번의 값을 받는다.
					String xmlVal = getXml(fileName);
					System.out.println("	Oralce String Data를 xml로 생성 >>> : \n" + xmlVal);
					
					// 19. 여기서는 xmlVal값이 null이 아닌지 확인한다.
					if (xmlVal !=null && xmlVal.length() > 0){
						
						// 24.  23번에서 리턴한 bool값을 받는다.
						bool = OracleXmlTest_1.xmlParse(fileName, xmlVal);
						if (bool){
							
							// 25. 참이면 제대로 생성했다는 메세지 출력
							System.out.println("	" + OracleXmlTest_1.XML_FILE_PATH +" 디렉토리에 " + fileName +".xml 파일이 잘 생성 되었습니다. ");
						}else{
							
							// 26. 그게 아니면 생성 오류나옴
							System.out.println(" 파일이 생성 되지 않았습니다. ");
						}	
					}
				}else{	
					System.out.println("	java OracleXmlTest 테이블이름 ");
					
				}				
			}catch(Exception e){
				
				System.out.println("	e.getMessage() >>> : " + e.getMessage());
			}	
			
			// 27.  그 다음 24번에서 받은 bool 값을 리턴한다.
			return bool;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LogManager.getLogger(OracleXmlTest.class);
		
		
		
		try {
			
			// 1. tableName 테이블 이름을 입력하세요.
			// 여기서 스타트를 한다.
			Scanner sc = new Scanner(System.in);
			System.out.println("	테이블의 이름을 KEY-IN 입력 하세요	>>> : ");
			
			// 2. 테이블의 이름을 tableName 지역변수가 받는다.
			String tableName = sc.next();
			logger.info("	tableName 테이블 이름은 ?	>>> : " + tableName);
			
			// 3. ot_1 참조변수를 인스턴스 한다.
			OracleXmlTest_1 ot_1 = new OracleXmlTest_1();
			
			// 4. 이거는 테이블의 이름이 null값이 아닌지를 확인한다.
			if (tableName.length() > 0) {
				
				// EMP 테이블의 이름 길이는 EMP이기 때문에 3이다.
				System.out.println("	tableName.length()는 ?	>>> : " + tableName.length());
					
					// 28. 27번에서 받은 bool값(true)를 bool이 받는다.
					boolean bool = ot_1.makeXml(tableName);
					
					// 29. bool 값을 출력한다.
					System.out.println("	bool 의 값은 ?	>>> : " + bool);
					
			}else {
			
				System.out.println("	java OracleXmlTest 테이블의 이름!");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("	에러 메세지 발견!!!! " + e.getMessage());
			
		}
		
	}
}

		//버퍼를 사용하는 이유
		// 기본 OS에서 읽고 쓰기 요청을 처리하는데 디스크 액세스, 네트워크 활동 또는 상대적으로 비용이 많이 드는
		// 기타 작업을 유발한다. 그래서 프로그램을 덜 효율적으로 만드는 경우가 발생함.
		// 이런 점을 보완하기 위해 버퍼란 것을 사용함.
		// 버퍼는 데이터를 한곳에서 다른 한곳으로 전송하는 동안 일시적으로 그 데이터를
		// 보관하는 메모리 영역임. 임시 저장소라고 함
		// I/O란 ? Input Output을 의미한다.
		// 버퍼를 사용하면 문자를 묶어서 한번에 전달할 때 전송시간이 적게 걸림. 즉 성능이 향상된다.
