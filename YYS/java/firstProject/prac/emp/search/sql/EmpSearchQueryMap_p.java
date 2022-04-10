package a.b.c.prac.emp.search.sql;

public abstract class EmpSearchQueryMap_p {
	// 전체 검색
	public static String getEmpSelectAll(){
	   	StringBuffer sb=new StringBuffer();
			
		sb.append("SELECT  													\n");
        sb.append("		A.EMPNO         					 AS EMPNO	    \n");
        sb.append("		,A.ENAME        					 AS ENAME 	    \n");
        sb.append("		,A.JOB                				 AS JOB 	    \n");
        sb.append("		,A.MGR              				 AS MGR		    \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE    \n");    
        sb.append("		,A.SAL                 			     AS SAL		    \n");
        sb.append("		,A.COMM           					 AS COMM	    \n");
        sb.append("		,A.DEPTNO       					 AS DEPTNO      \n");
        sb.append("FROM EMP A 												\n");
        sb.append("ORDER BY 1 DESC											\n");
        // ORDER BY 1 DESC; 이렇게 쓰면 안 됨. ;이거 빼야함.
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectAll() :: 쿼리문 작성 끝  >>> \n");
            
            return sb.toString();
	};
	
	// 사번 검색
	public static String getEmpSelectEmpno(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.EMPNO LIKE '%'||?||'%'		\n"); // place holder 1
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEmpno() :: 쿼리문 작성 끝  >>> \n");
		
		return sb.toString();
	};
	
	// 사원 이름 검색
	public static String getEmpSelectEname(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        // 내가 사용한 방식 : sb.append("WHERE  A.ENAME = UPPER(?)"); // place holder 1
        sb.append("WHERE A.ENAME	LIKE	UPPER('%'||?||'%')				 \n");
        
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEname() :: 쿼리문 작성 끝  >>> \n");
		
		return sb.toString();	
	};
	
	public static String getEmpSelectEmpnoEname(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.EMPNO LIKE '%'||?||'%'			\n"); // place holder 1
        sb.append("AND 	  A.ENAME LIKE UPPER('%'||?||'%')	\n"); // place holder 2
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEmpnoEname() :: 쿼리문 작성 끝  >>> \n");
        
		return sb.toString();
	};
	
	public static String getEmpSelectJob(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.JOB LIKE UPPER('%'||?||'%')"); // place holder 1
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectJob() :: 쿼리문 작성 끝  >>> \n");
        
		return sb.toString();
	};
	
	
	public static String getEmpSelectHiredate(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')  >= TO_CHAR(TO_DATE(?), 'YYYYMMDD')  \n");
        //  place holder 1
		sb.append("AND   TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 	<= TO_CHAR(TO_DATE(?), 'YYYYMMDD')");
		// place holder 2
		
		System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectHiredate() :: 쿼리문 작성 끝  >>> \n");
		
		return sb.toString();
	};
}