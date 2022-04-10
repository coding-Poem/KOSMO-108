package a.b.c.prac1;

public class StringBuffer_p {
	
	public static String getBoaradSelectAllQuery() {
	StringBuffer sb=new StringBuffer();
	System.out.println("\n start sb >>> : "+sb.hashCode());
	
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
    
    System.out.println("\n end sb >>> : "+sb.hashCode());
    // append는 정보의 불변성 문제를 보완한 방법이다.
    // String.concat(String)의 경우, 
    // VELOG + _POSTING을 하면
    // VELOG 주소 하나, _POSTING 주소 하나
    // VELOG_POSTING 하나 주소가 생긴다.
    // StringBuffer 클래스의 append 메서드를 사용하면,
    // 해당 주소를 유지하면서 내용을 추가 할 수 있다.
    return sb.toString();	
    // toString() 을 사용하는 이유
    // String 클래스와 String Buffer 클래스는 다르기 때문에
    // 형 변환을 사용해주어야 한다.
}	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sqlQuery=StringBuffer_p.getBoaradSelectAllQuery();
		System.out.println("sqlQuery \n "+sqlQuery);
	}
}
