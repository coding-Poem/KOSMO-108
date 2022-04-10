package a.b.c.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ChabunQuery {
	
	public static final short CHABUN_QUERY_MEMBER=0;
	
	public static String chabun_query[]={
		"SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) +1 AS COMM_NUM FROM KOS_MEMBER A"	
	};
	
	public static String getMemChabunQuery(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		String commNum="";
		
		try {
			conn=KosConnectivity.getConnection();
			
			String sql=ChabunQuery.chabun_query[CHABUN_QUERY_MEMBER];
			pstmt=conn.prepareStatement(sql);
			System.out.println("Chabun Query >>> : \n"+sql);
			
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				while(rsRs.next()){
					commNum=rsRs.getString("COMM_NUM");
				}
			}else{
				System.out.println("ChabunQuery :: 검색결과가 없습니다. :: rsRs >>> : "+rsRs);
			}
			
		}catch(Exception e){
			System.out.println("ChabunQuery :: getMemChabunQuery() :: error >>> : "+e.getMessage());
		}
		return commNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
