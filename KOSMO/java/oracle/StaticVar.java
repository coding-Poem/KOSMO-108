package a.b.c.oracle;

public class StaticVar {

	public static final short SQLQUERY_1 = 0;
	public static final short SQLQUERY_2 = 1;
	
	// sql Query 
	public static String[] sqlQuery = {
		"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE '%' || ? || '%' ",	
		"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE ? "
	};
	
	public void sTest() {
		
		System.out.println("StaticVar.SQLQUERY_1 >>> : " + StaticVar.SQLQUERY_1);
		System.out.println("StaticVar.SQLQUERY_2 >>> : " + StaticVar.SQLQUERY_2);
		
		System.out.println("StaticVar.sqlQuery[0] >>> : " + StaticVar.sqlQuery[0]);
		System.out.println("StaticVar.sqlQuery[1] >>> : " + StaticVar.sqlQuery[1]);
		
		
		System.out.println("StaticVar.sqlQuery[StaticVar.SQLQUERY_1] >>> : " 
								+ StaticVar.sqlQuery[StaticVar.SQLQUERY_1]);
		System.out.println("StaticVar.sqlQuery[StaticVar.SQLQUERY_2] >>> : " 
								+ StaticVar.sqlQuery[StaticVar.SQLQUERY_2]);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StaticVar().sTest();
	}

}
