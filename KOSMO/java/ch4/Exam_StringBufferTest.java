package a.b.c.ch4;

public class Exam_StringBufferTest {
	
	public static String getBoardSelectAllQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM 			\n");
		sb.append("		,A.BSUBJECT  	BSUBJECT 		\n");
		sb.append("		,A.BWRITER  	BWRITER 		\n");
	    sb.append("		,A.BPW  		BPW   			\n");	    	    	    
	    sb.append("		,A.BMEMO  		BMEMO			\n");
	    sb.append("		,A.BPHOTO  		BPHOTO			\n");	 
	    sb.append("		,A.DELETEYN  	DELETEYN		\n");	
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	   
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_BOARD A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC  					\n");

	    return sb.toString();	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sqlQuery = Exam_StringBufferTest.getBoardSelectAllQuery();
		System.out.println("sqlQuery \n" + sqlQuery);
	}
}
