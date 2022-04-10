package a.b.c.t6.sql;

public abstract class T6QueryMap {

	// 전체 조회
	public static String getT6SelectAll() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  						\n"); 
		sb.append("			 A.T1         	AS T1   \n");
		sb.append("			,A.T2         	AS T2 	\n");  
		sb.append("			,A.T3        	AS T3  	\n");
		sb.append("			,A.T4           AS T4  	\n");		 
		sb.append("			,TO_CHAR(A.T5, 'YYYY-MM-DD') 	AS T5  \n");
		sb.append("			,TO_CHAR(A.T6, 'YYYY-MM-DD')  	AS T6  \n");		
		sb.append("	FROM     TEST_T6 A 				\n");
		sb.append("	WHERE    A.T4 = 'Y'   			\n");
		sb.append(" ORDER BY 1 DESC					\n");
		
		return sb.toString();
		
	}
	
	// 이름 검색
	public static String getT6SelectName() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  						\n"); 
		sb.append("			 A.T1         	AS T1   \n");
		sb.append("			,A.T2         	AS T2 	\n");  
		sb.append("			,A.T3        	AS T3  	\n");
		sb.append("			,A.T4           AS T4  	\n");		 
		sb.append("			,TO_CHAR(A.T5, 'YYYY-MM-DD') 	AS T5  \n");
		sb.append("			,TO_CHAR(A.T6, 'YYYY-MM-DD')  	AS T6  \n");		
		sb.append("	FROM     TEST_T6 A 				\n");
		sb.append("	WHERE    A.T4 = 'Y'   			\n");
		sb.append(" AND      A.T2 = ?				\n"); // place holder 1 
		
		return sb.toString();
	}
	
	// 날짜 검색
	public static String getT6SelectDate() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  						\n"); 
		sb.append("			 A.T1         	AS T1   \n");
		sb.append("			,A.T2         	AS T2 	\n");  
		sb.append("			,A.T3        	AS T3  	\n");
		sb.append("			,A.T4           AS T4  	\n");		 
		sb.append("			,TO_CHAR(A.T5, 'YYYY-MM-DD') 	AS T5  \n");
		sb.append("			,TO_CHAR(A.T6, 'YYYY-MM-DD')  	AS T6  \n");		
		sb.append("	FROM     TEST_T6 A 				\n");
		sb.append("	WHERE    A.T4 = 'Y'   			\n");
		sb.append(" AND      TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD') >= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n"); // place holder 1 
		sb.append(" AND      TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD') <= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n"); // place holder 2
		
		return sb.toString();
	}

	// 입력 
	public static String getT6Insert() {
		System.out.println("T6QueryMap.getT6Insert >>> :");
		
		StringBuffer sb = new StringBuffer();
		sb.append("	INSERT INTO  					\n");
		sb.append("		TEST_T6  					\n");
		sb.append("				(  					\n");
		sb.append("			 		 T1         	\n"); // place holder 1 
		sb.append("			 	  	,T2         	\n"); // place holder 2 
		sb.append("			 	  	,T3         	\n"); // place holder 3 
		sb.append("			 	  	,T4         	\n"); // 'Y'	
		sb.append("			 	  	,T5         	\n"); // SYSDATE
		sb.append("			 	  	,T6         	\n"); // SYSDATE
		sb.append("				)  					\n");
		sb.append("		VALUES  					\n");
		sb.append("				(  					\n");
		sb.append("			 		 ?         		\n"); // place holder 1 :: T1
		sb.append("			 	  	,?         		\n"); // place holder 2 :: T2
		sb.append("			 	  	,?         		\n"); // place holder 3 :: T3
		sb.append("			 	  	,'Y'         	\n"); // T4
		sb.append("			 	  	,SYSDATE        \n"); // T5
		sb.append("			 	  	,SYSDATE        \n"); // T6
		sb.append("				)  					\n");
		
		return sb.toString();
	}
	
	// 수정
	public static String getT6Update() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE TEST_T6   				\n");
		sb.append("		SET	  						\n");
		sb.append("			 T2 = ?         	 	\n"); // place holder 1 :: T2
		sb.append("			,T3 = ?        	 		\n"); // place holder 2 :: T3  		
		sb.append("			,T6 = SYSDATE       	\n");		 
		sb.append("	WHERE    T4 = 'Y'   			\n");
		sb.append(" AND      T1 = ?					\n"); // place holder 3 :: T1
		
		return sb.toString();
	}
	
	// 삭제
	public static String getT6Delete() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE TEST_T6   				\n");
		sb.append("		SET	  						\n");
		sb.append("			 T4 = 'N'         		\n"); // place holder 1 :: T2	  	
		sb.append("			,T6 = SYSDATE       	\n");		 
		sb.append("	WHERE    T4 = 'Y'   			\n");
		sb.append(" AND      T1 = ?					\n"); // place holder 3 :: T1
		
		return sb.toString();
	}
}
