package a.b.c.kos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import a.b.c.common.KosmoConnProperty;
import a.b.c.kos.sql.MemQueryMap;
import a.b.c.kos.vo.MemVO;


public class MemDAOImpl implements MemDAO{
	
/*************************************************************/	
	// **DQL :: SELECT**
	@Override
	public ArrayList<MemVO> memSelectAll(){
		System.out.println("MemDAOImpl :: memSelectAll() :: Start ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemVO> aList = null;		
		MemVO _mvo = null;
		
		try {
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemSelectAll();
			pstmt = conn.prepareStatement(sql);
			System.out.println("전체 조회 >>> : \n" + sql);
			// 질의 결과 받기
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<MemVO> ();
							
				// rsRs.next() >>> : true
				while (rsRs.next()) {
					
					_mvo = new MemVO();
					/* Java™ Platform Standard Ed. 8 API
					 * java.sql
					 * Interface ResultSet
					 * String :: getString(int columnIndex)
					 * Returns: the column value
					 * 
					 * String :: getString(String columnLabel)
					 * Returns :: the column value					  // ORACLE SQL DEVELOPER >> 테이블  >> KOS_MEMBER >> 열
					 */												  //  			   COLUMN_NAME						 COLUMN_ID
					_mvo.setMnum(rsRs.getString("MNUM")); 			  // <COLUMN_NAME :: MNUM   --회원번호>     :: COLUMN_ID :: 1
					_mvo.setMname(rsRs.getString("MNAME")); 		  // <COLUMN_NAME :: MNAME --회원이름>	  :: COLUMN_ID :: 2
					_mvo.setMid(rsRs.getString("MID")); 			  // <COLUMN_NAME :: MID --아이디>          :: COLUMN_ID :: 3
					_mvo.setMpw(rsRs.getString("MPW")); 			  // <COLUMN_NAME :: MPW --패스워드>	      :: COLUMN_ID :: 4 
					_mvo.setMhp(rsRs.getString("MHP")); 			  // <COLUMN_NAME :: MHP --핸드폰번호>	      :: COLUMN_ID :: 5
					_mvo.setMemail(rsRs.getString("MEMAIL")); 		  // <COLUMN_NAME :: MEMAIL --이메일>	      :: COLUMN_ID :: 6
					_mvo.setMgender(rsRs.getString("MGENDER")); 	  // <COLUMN_NAME :: MGENDER --성별>	      :: COLUMN_ID :: 7
					_mvo.setMhobby(rsRs.getString("MHOBBY")); 		  // <COLUMN_NAME :: MHOBBY --취미>	      :: COLUMN_ID :: 8
					_mvo.setMlocal(rsRs.getString("MLOCAL")); 		  // <COLUMN_NAME :: MLOCAL --지역>	      :: COLUMN_ID :: 9
					_mvo.setMmsg(rsRs.getString("MMSG")); 			  // <COLUMN_NAME :: MMSG --내용>          :: COLUMN_ID :: 10
					_mvo.setDeleteyn(rsRs.getString("DELETEYN")); 	  // <COLUMN_NAME :: DELETEYN --회원여부>   :: COLUMN_ID :: 11
					_mvo.setInsertdate(rsRs.getString("INSERTDATE")); // <COLUMN_NAME :: INSERTDATE --등록일>   :: COLUMN_ID :: 12
					_mvo.setUpdatedate(rsRs.getString("UPDATEDATE")); // <COLUMN_NAME :: UPDATEDATE --수정일>   :: COLUMN_ID :: 13
					
					aList.add(_mvo);
				 }
			}else {
				System.out.println("MemDAOImpl :: memSelectAll() ::  전체조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("MemDAOImpl :: memSelectAll() ::  전체조회중 에러가  >>> : " + e.getMessage());
		}
		System.out.println("MemDAOImpl :: memSelectAll() :: return되는 aList >>> : "+aList);
		
		return aList;
	}; // end of memSelectAll()
	
	@Override
	public ArrayList<MemVO> memSelectNum(MemVO mvo){
		System.out.println("MemDAOImpl :: memSelectNum(MemVO mvo) :: Start ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemVO> aList = null;		
		MemVO _mvo = null;
		
		try {
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemSelectNum();
			pstmt = conn.prepareStatement(sql);
			System.out.println("회원번호 조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			
			pstmt.setString(1, mvo.getMnum());
			rsRs=pstmt.executeQuery();
			
			if (rsRs !=null) { 
				aList = new ArrayList<MemVO> ();
				
				// rsRs.next() >>> : true
				while (rsRs.next()) {
					_mvo = new MemVO();
					/* Java™ Platform Standard Ed. 8 API
					 * java.sql
					 * Interface ResultSet
					 * String :: getString(int columnIndex)
					 * Returns: the column value
					 * 
					 * String :: getString(String columnLabel)
					 * Returns :: the column value					  // ORACLE SQL DEVELOPER >> 테이블  >> KOS_MEMBER >> 열
					 */												  //  			   COLUMN_NAME						 COLUMN_ID
					_mvo.setMnum(rsRs.getString("MNUM")); 			  // <COLUMN_NAME :: MNUM   --회원번호>     :: COLUMN_ID :: 1
					_mvo.setMname(rsRs.getString("MNAME")); 		  // <COLUMN_NAME :: MNAME --회원이름>	  :: COLUMN_ID :: 2
					_mvo.setMid(rsRs.getString("MID")); 			  // <COLUMN_NAME :: MID --아이디>          :: COLUMN_ID :: 3
					_mvo.setMpw(rsRs.getString("MPW")); 			  // <COLUMN_NAME :: MPW --패스워드>	      :: COLUMN_ID :: 4 
					_mvo.setMhp(rsRs.getString("MHP")); 			  // <COLUMN_NAME :: MHP --핸드폰번호>	      :: COLUMN_ID :: 5
					_mvo.setMemail(rsRs.getString("MEMAIL")); 		  // <COLUMN_NAME :: MEMAIL --이메일>	      :: COLUMN_ID :: 6
					_mvo.setMgender(rsRs.getString("MGENDER")); 	  // <COLUMN_NAME :: MGENDER --성별>	      :: COLUMN_ID :: 7
					_mvo.setMhobby(rsRs.getString("MHOBBY")); 		  // <COLUMN_NAME :: MHOBBY --취미>	      :: COLUMN_ID :: 8
					_mvo.setMlocal(rsRs.getString("MLOCAL")); 		  // <COLUMN_NAME :: MLOCAL --지역>	      :: COLUMN_ID :: 9
					_mvo.setMmsg(rsRs.getString("MMSG")); 			  // <COLUMN_NAME :: MMSG --내용>          :: COLUMN_ID :: 10
					_mvo.setDeleteyn(rsRs.getString("DELETEYN")); 	  // <COLUMN_NAME :: DELETEYN --회원여부>   :: COLUMN_ID :: 11
					_mvo.setInsertdate(rsRs.getString("INSERTDATE")); // <COLUMN_NAME :: INSERTDATE --등록일>   :: COLUMN_ID :: 12
					_mvo.setUpdatedate(rsRs.getString("UPDATEDATE")); // <COLUMN_NAME :: UPDATEDATE --수정일>   :: COLUMN_ID :: 13
					
					aList.add(_mvo);
				 }
			}else {
				System.out.println("MemDAOImpl ::  memSelectNum(MemVO mvo) ::  회원번호 조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memSelectNum(MemVO mvo) ::  회원번호 조회 중 에러가  >>> : " + e.getMessage());
		}
		System.out.println("MemDAOImpl :: memSelectNum(MemVO mvo) :: return되는 aList >>> : "+aList);
		
		return aList;
	}; // end of memSelectNum()
	
	@Override
	public ArrayList<MemVO> memSelectName(MemVO mvo){
		System.out.println("MemDAOImpl :: memSelectName(MemVO mvo) :: Start ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemVO> aList = null;		
		MemVO _mvo = null;
		
		try{
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemSelectName();
			pstmt = conn.prepareStatement(sql);
			System.out.println("회원이름 조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			
			pstmt.setString(1, mvo.getMname());
			rsRs=pstmt.executeQuery();
			
			if (rsRs !=null) { 
				aList = new ArrayList<MemVO> ();
				
				// rsRs.next() >>> : true
				while (rsRs.next()) {
					_mvo = new MemVO();
					/* Java™ Platform Standard Ed. 8 API
					 * java.sql
					 * Interface ResultSet
					 * String :: getString(int columnIndex)
					 * Returns: the column value
					 * 
					 * String :: getString(String columnLabel)
					 * Returns :: the column value					  // ORACLE SQL DEVELOPER >> 테이블  >> KOS_MEMBER >> 열
					 */												  //  			   COLUMN_NAME						 COLUMN_ID
					_mvo.setMnum(rsRs.getString("MNUM")); 			  // <COLUMN_NAME :: MNUM   --회원번호>     :: COLUMN_ID :: 1
					_mvo.setMname(rsRs.getString("MNAME")); 		  // <COLUMN_NAME :: MNAME --회원이름>	  :: COLUMN_ID :: 2
					_mvo.setMid(rsRs.getString("MID")); 			  // <COLUMN_NAME :: MID --아이디>          :: COLUMN_ID :: 3
					_mvo.setMpw(rsRs.getString("MPW")); 			  // <COLUMN_NAME :: MPW --패스워드>	      :: COLUMN_ID :: 4 
					_mvo.setMhp(rsRs.getString("MHP")); 			  // <COLUMN_NAME :: MHP --핸드폰번호>	      :: COLUMN_ID :: 5
					_mvo.setMemail(rsRs.getString("MEMAIL")); 		  // <COLUMN_NAME :: MEMAIL --이메일>	      :: COLUMN_ID :: 6
					_mvo.setMgender(rsRs.getString("MGENDER")); 	  // <COLUMN_NAME :: MGENDER --성별>	      :: COLUMN_ID :: 7
					_mvo.setMhobby(rsRs.getString("MHOBBY")); 		  // <COLUMN_NAME :: MHOBBY --취미>	      :: COLUMN_ID :: 8
					_mvo.setMlocal(rsRs.getString("MLOCAL")); 		  // <COLUMN_NAME :: MLOCAL --지역>	      :: COLUMN_ID :: 9
					_mvo.setMmsg(rsRs.getString("MMSG")); 			  // <COLUMN_NAME :: MMSG --내용>          :: COLUMN_ID :: 10
					_mvo.setDeleteyn(rsRs.getString("DELETEYN")); 	  // <COLUMN_NAME :: DELETEYN --회원여부>   :: COLUMN_ID :: 11
					_mvo.setInsertdate(rsRs.getString("INSERTDATE")); // <COLUMN_NAME :: INSERTDATE --등록일>   :: COLUMN_ID :: 12
					_mvo.setUpdatedate(rsRs.getString("UPDATEDATE")); // <COLUMN_NAME :: UPDATEDATE --수정일>   :: COLUMN_ID :: 13
					
					aList.add(_mvo);
				 }
			}else {
				System.out.println("MemDAOImpl ::   memSelectName(MemVO mvo) ::  회원번호 조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}		
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memSelectName(MemVO mvo) ::  회원이름 조회 중 에러가  >>> : " + e.getMessage());
		}
		System.out.println("MemDAOImpl :: memSelectName(MemVO mvo) :: return되는 aList >>> : "+aList);
		
		return aList;
	}; // end of memSelectName()
	
	@Override
	public ArrayList<MemVO> memSelectDate(MemVO mvo){
		System.out.println("MemDAOImpl :: memSelectDate(MemVO mvo) :: Start ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemVO> aList = null;		
		MemVO _mvo = null;
		
		try{
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemSelectDate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("날짜 조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			
			pstmt.setString(1, mvo.getFromdate());
			// place holder 1 :: mvo.getFromdate()
			pstmt.setString(2, mvo.getTodate());
			// place holder 2 :: mvo.getTodate()
			
			System.out.println("mvo.getFromdate >>> : "+mvo.getFromdate());
			System.out.println("mvo.getTodate >>> : "+mvo.getTodate());
			
			rsRs=pstmt.executeQuery();
			
			if (rsRs !=null) { 
				aList = new ArrayList<MemVO> ();
				
				// rsRs.next() >>> : true
				while (rsRs.next()) {
					_mvo = new MemVO();
					/* Java™ Platform Standard Ed. 8 API
					 * java.sql
					 * Interface ResultSet
					 * String :: getString(int columnIndex)
					 * Returns: the column value
					 * 
					 * String :: getString(String columnLabel)
					 * Returns :: the column value					  // ORACLE SQL DEVELOPER >> 테이블  >> KOS_MEMBER >> 열
					 */												  //  			   COLUMN_NAME						 COLUMN_ID
					_mvo.setMnum(rsRs.getString("MNUM")); 			  // <COLUMN_NAME :: MNUM   --회원번호>     :: COLUMN_ID :: 1
					_mvo.setMname(rsRs.getString("MNAME")); 		  // <COLUMN_NAME :: MNAME --회원이름>	  :: COLUMN_ID :: 2
					_mvo.setMid(rsRs.getString("MID")); 			  // <COLUMN_NAME :: MID --아이디>          :: COLUMN_ID :: 3
					_mvo.setMpw(rsRs.getString("MPW")); 			  // <COLUMN_NAME :: MPW --패스워드>	      :: COLUMN_ID :: 4 
					_mvo.setMhp(rsRs.getString("MHP")); 			  // <COLUMN_NAME :: MHP --핸드폰번호>	      :: COLUMN_ID :: 5
					_mvo.setMemail(rsRs.getString("MEMAIL")); 		  // <COLUMN_NAME :: MEMAIL --이메일>	      :: COLUMN_ID :: 6
					_mvo.setMgender(rsRs.getString("MGENDER")); 	  // <COLUMN_NAME :: MGENDER --성별>	      :: COLUMN_ID :: 7
					_mvo.setMhobby(rsRs.getString("MHOBBY")); 		  // <COLUMN_NAME :: MHOBBY --취미>	      :: COLUMN_ID :: 8
					_mvo.setMlocal(rsRs.getString("MLOCAL")); 		  // <COLUMN_NAME :: MLOCAL --지역>	      :: COLUMN_ID :: 9
					_mvo.setMmsg(rsRs.getString("MMSG")); 			  // <COLUMN_NAME :: MMSG --내용>          :: COLUMN_ID :: 10
					_mvo.setDeleteyn(rsRs.getString("DELETEYN")); 	  // <COLUMN_NAME :: DELETEYN --회원여부>   :: COLUMN_ID :: 11
					_mvo.setInsertdate(rsRs.getString("INSERTDATE")); // <COLUMN_NAME :: INSERTDATE --등록일>   :: COLUMN_ID :: 12
					_mvo.setUpdatedate(rsRs.getString("UPDATEDATE")); // <COLUMN_NAME :: UPDATEDATE --수정일>   :: COLUMN_ID :: 13
					
					aList.add(_mvo);
				 }
			}else {
				System.out.println("MemDAOImpl ::   memSelectDate(MemVO mvo) ::  날짜 조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}		
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memSelectDate(MemVO mvo) ::  날짜 조회 중 에러가  >>> : " + e.getMessage());
		}
		System.out.println("MemDAOImpl :: memSelectDate(MemVO mvo) :: return되는 aList >>> : "+aList);
			
		return aList;
	}; // end of memSelectDate()

/*************************************************************/
	// **DML :: INSERT, UPDATE, DELETE**
	@Override
	public boolean memInsert(MemVO mvo){
		System.out.println("\n MemDAOImpl :: memInsert(MemVO mvo) :: Start ");
		MemVO.printlnMemVO(mvo);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemInsert();
			pstmt = conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMnum()); 
			// place holder 1  :: 	  MNUM 		:: NOT NULL
			
			pstmt.setString(2, mvo.getMname());
			// place holder 2  :: 	  MNAME
			
			pstmt.setString(3, mvo.getMid());
			// place holder 3  :: 	  MID  	    :: NOT NULL		
			
			pstmt.setString(4, mvo.getMpw());
			// place holder 4  :: 	  MPW  	    :: NOT NULL
			
			pstmt.setString(5, mvo.getMhp());
			// place holder 5  ::     MHP       :: NOT NULL
			
			pstmt.setString(6, mvo.getMemail());
			// place holder 6  ::     MEMAIL    :: NOT NULL
			
			pstmt.setString(7, mvo.getMgender());
			// place holder 7  ::     MGENDER
			
			pstmt.setString(8, mvo.getMhobby());
			// place holder 8  ::     MHOBBY
			
			pstmt.setString(9, mvo.getMlocal());
			// place holder 9  ::     MLOCAL
			
			pstmt.setString(10, mvo.getMmsg());
			// place holder 10 ::      MMSG
			
			nCnt=pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 등록 되었음");
			if (nCnt > 0) {bool=true;}
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memInsert(MemVO mvo) :: error >>> : "+e.getMessage());
		}finally{
			KosmoConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}; // end of memInsert()
	
	@Override
	public boolean memUpdate(MemVO mvo){
		System.out.println("MemDAOImpl :: memUpdate(MemVO mvo) :: Start ");
		MemVO.printlnMemVO(mvo);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemUpdate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("수정하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMname());
			// place holder 1  :: 	  MNAME
			
			pstmt.setString(2, mvo.getMid());
			// place holder 2 ::  	  MID     :: NOT NULL
			
			pstmt.setString(3, mvo.getMpw());
			// place holder 3	:: 	  MPW     :: NOT NULL
			
			pstmt.setString(4, mvo.getMhp());
			// place holder 4 ::  	  MHP     :: NOT NULL
			
			pstmt.setString(5, mvo.getMemail());
			// place holder 5 :: 	  MEMAIL  :: NOT NULL
			
			pstmt.setString(6, mvo.getMgender());
			// place holder 6 ::  	  MGENDER
			
			pstmt.setString(7, mvo.getMhobby());
			// place holder 7 :: 	  MHOBBY
			
			pstmt.setString(8, mvo.getMlocal());
			// place holder 8 :: 	  MLOCAL
			
			pstmt.setString(9, mvo.getMmsg());
			// place holder 9 ::	  MMSG
			
			pstmt.setString(10, mvo.getMnum());
			// place holder 10 :: 	   MNUM  :: NOT NULL

			nCnt=pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 수정 되었음");
			if (nCnt > 0) {bool=true;}
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memUpdate(MemVO mvo) :: error >>> : "+e.getMessage());
		}finally{
			KosmoConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}; // end of memUpdate()
	
	@Override
	public boolean memDelete(MemVO mvo){
		System.out.println("MemDAOImpl :: memDelete(MemVO mvo) :: Start ");
		System.out.println("\n MemDAOImpl :: 삭제할 회원 번호 >>> : "+mvo.getMnum());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn = KosmoConnProperty.getConnection();
			String sql = MemQueryMap.getMemDelete();
			pstmt = conn.prepareStatement(sql);
			System.out.println("삭제하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMnum());
			// place holder 1 :: 	  MNUM :: NOT NULL
			
			nCnt=pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 삭제 되었음");
			if (nCnt > 0) {bool=true;}
		}catch(Exception e){
			System.out.println("MemDAOImpl :: memDelete(MemVO mvo) :: error >>> : "+e.getMessage());
		}finally{
			KosmoConnProperty.conClose(conn, pstmt);
			}
		return bool;
	}; // end of memDelete()
	
/*************************************************************/
} // end of class MemDAOImpl
