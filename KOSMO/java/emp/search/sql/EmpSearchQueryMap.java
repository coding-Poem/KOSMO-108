package a.b.c.emp.search.sql;

public abstract class EmpSearchQueryMap {
	
	// 전체 검색
	public static String getEmpSelectAll() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");
		sb.append("			,A.MGR           AS MGR  		\n");
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  
		sb.append("			,A.SAL           AS SAL  		\n");
		sb.append("			,A.COMM          AS COMM  		\n");
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" ORDER BY 1 DESC							\n");
		
		return sb.toString();
	}
	
	// 사번 검색 
	public static String getEmpSelectEmpno() {
				
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");		
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  		
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" WHERE    A.EMPNO = ?					\n"); // place holder 1 7934
		
		return sb.toString();
	}

	// 이름 검색 LIKE
	public static String empSelectEname() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");
		sb.append("			,A.MGR           AS MGR  		\n");
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  
		sb.append("			,A.SAL           AS SAL  		\n");
		sb.append("			,A.COMM          AS COMM  		\n");
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" WHERE    A.ENAME LIKE '%' || ? || '%'	\n"); // place holder 1 
		
		return sb.toString();
	}
	
	// 사번 이름 검색
	public static String empSelectEmpnoEname() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");
		sb.append("			,A.MGR           AS MGR  		\n");
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  
		sb.append("			,A.SAL           AS SAL  		\n");
		sb.append("			,A.COMM          AS COMM  		\n");
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" WHERE    A.EMPNO = ?					\n"); // place holder 1 
		sb.append(" AND      A.ENAME = ?					\n"); // place holder 2 
		
		return sb.toString();
	}
	
	// 직책 검색 LIKE
	public static String empSelectJob() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");
		sb.append("			,A.MGR           AS MGR  		\n");
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  
		sb.append("			,A.SAL           AS SAL  		\n");
		sb.append("			,A.COMM          AS COMM  		\n");
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" WHERE    A.JOB LIKE '%' || ? || '%'		\n"); // place holder 1 
		
		return sb.toString();
	}
	
	// 날짜 검색
	public static String empSelectHiredate() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT  								\n"); 
		sb.append("			 A.EMPNO         AS EMP   		\n");
		sb.append("			,A.ENAME         AS ENAME 		\n");  
		sb.append("			,A.JOB           AS JOB  		\n");
		sb.append("			,A.MGR           AS MGR  		\n");
		sb.append("			,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')    AS HIREDATE \n");  
		sb.append("			,A.SAL           AS SAL  		\n");
		sb.append("			,A.COMM          AS COMM  		\n");
		sb.append("			,A.DEPTNO        AS DEPTNO  	\n");
		sb.append("	FROM     EMP A 							\n");
		sb.append(" WHERE 	 1=1							\n");
		sb.append(" AND      TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n"); // place holder 1 
		sb.append(" AND      TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n"); // place holder 2 
		
		return sb.toString();
	}
}
