package a.b.c.kos.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.common.KosConnectivity;
import a.b.c.kos.mem.sql.MemQueryMap;
import a.b.c.kos.mem.vo.MemVO;

public class MemDAOImpl implements MemDAO{
	Logger logger = LogManager.getLogger(MemDAOImpl.class);
/********************** SELECT  ***************************/
	// **DQL :: SELECT**
	// 전체 조회
	@Override
	public ArrayList<MemVO> memSelectAll(MemVO mvo){
		logger.info("MemDAOImpl :: memSelectAll(MemVO mvo) :: Start \n");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		
		ArrayList<MemVO> aList = null;
		
		try{
			conn=KosConnectivity.getConnection();
			String sql=MemQueryMap.getMemSelectAllQuery(mvo);
			pstmt=conn.prepareStatement(sql);
			logger.info("전체조회 >>> : \n"+sql);
			
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				aList=new ArrayList<MemVO>();
				
				while(rsRs.next()){
					MemVO _mvo=new MemVO();
					
					_mvo.setMnum(rsRs.getString(1)); 		// MNUM :: 1
					_mvo.setMname(rsRs.getString(2)); 		// MNAME :: 2
					_mvo.setMid(rsRs.getString(3)); 		// MID :: 3
					_mvo.setMpw(rsRs.getString(4)); 		// MPW :: 4
					_mvo.setMhp(rsRs.getString(5)); 		// MHP :: 5
					_mvo.setMemail(rsRs.getString(6)); 		// MEMAIL :: 6
					_mvo.setMgender(rsRs.getString(7)); 	// MGENDER :: 7
					_mvo.setMhobby(rsRs.getString(8)); 		// MHOBBY :: 8
					_mvo.setMzone(rsRs.getString(9)); 		// MZONE :: 9 
					_mvo.setMroad(rsRs.getString(10));	 	// MROAD :: 10 
					_mvo.setMjibun(rsRs.getString(11)); 	// MJIBUN :: 11
					_mvo.setMmsg(rsRs.getString(12)); 		// MMSG :: 12
					_mvo.setDeleteyn(rsRs.getString(13)); 	// DELETEYN :: 13
					_mvo.setInsertdate(rsRs.getString(14)); // INSERTDATE :: 14
					_mvo.setUpdatedate(rsRs.getString(15)); 	// UPDATEDATE :: 15
					
					
					aList.add(_mvo);
				}
				
			} // if(rsRs!=null)
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			logger.info("MemDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());;
		}finally{
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	};
	
	// 회원 조건 조회
	@Override
	public ArrayList<MemVO> memSelect(MemVO mvo){
		logger.info("MemDAOImpl :: memSelect(MemVO mvo) :: Start \n");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		
		ArrayList<MemVO> aList = null;
		
		try{
			conn=KosConnectivity.getConnection();
			String sql=MemQueryMap.getMemSelectQuery();
			
			pstmt=conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n"+sql);
			logger.info("조건조회 >>> : \n"+sql);
			
			// 파라미터 클리어 꼭 하기
			pstmt.clearParameters();
			
			pstmt.setString(1, mvo.getMnum());
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				aList=new ArrayList<MemVO>();
				
				while(rsRs.next()){
					MemVO _mvo=new MemVO();
					
					_mvo.setMnum(rsRs.getString(1)); 	    // MNUM : 1
					_mvo.setMname(rsRs.getString(2)); 	    // MNAME : 2
					_mvo.setMid(rsRs.getString(3)); 	    // MID : 3
					_mvo.setMpw(rsRs.getString(4)); 	    // MPW : 4
					_mvo.setMhp(rsRs.getString(5)); 	    // MHP : 5
					_mvo.setMemail(rsRs.getString(6)); 	    // MEMAIL : 6 
					_mvo.setMgender(rsRs.getString(7)); 	// MGENDER : 7
					_mvo.setMhobby(rsRs.getString(8)); 	    // MHOBBY : 8
					_mvo.setMzone(rsRs.getString(9)); 	    // MZONE : 9
					_mvo.setMroad(rsRs.getString(10)); 	    // MROAD : 10
					_mvo.setMjibun(rsRs.getString(11)); 	    // MJIBUN : 11
					_mvo.setMmsg(rsRs.getString(12)); 	// MMSG : 12
					_mvo.setDeleteyn(rsRs.getString(13)); 		// DELETEYN : 13
					_mvo.setInsertdate(rsRs.getNString(14));  // INSERTDATE : 14
					_mvo.setUpdatedate(rsRs.getString(15)); // UPDATEDATE : 15
					
					aList.add(_mvo);
				}
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			logger.info("MemDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());;
		}finally{
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	};
/********************** INSERT  ***************************/	
	// **DML :: INSERT, UPDATE, DELETE**
	@Override
	public boolean memInsert(MemVO mvo){
		logger.info("MemDAOImpl :: memInsert(MemVO mvo) :: Start \n");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		
		try{
			conn=KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : "+conn.getAutoCommit());
			// boolean : getAutoCommit() : Retrieves the current auto-commit mode for this Connection object.
			// Returns : the current state of this Connection object's auto-commit mode
			
			String sql=MemQueryMap.getMemInsertQuery();
			pstmt=conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n"+sql);
			logger.info("조건조회 >>> : \n"+sql);
			
			// 파라미터 클리어를 꼭 하기
			pstmt.clearParameters();
			
			
			//  placeholder : 1 :: MNUM  :  1 
			//  placeholder : 2 :: MNAME :  2
			//  placeholder : 3 :: MID :    3
			//  placeholder : 4 :: MPW :    4
			//  placeholder : 5 :: MHP :    5
			//  placeholder : 6 :: MEMAIL : 6
			//  placeholder : 7 :: MGENDER :7
			//  placeholder : 8 :: MHOBBY : 8
			//  placeholder : 9 :: MZONE :  9
			//  placeholder : 10 :: MROAD :  10
			//  placeholder : 11 :: MJIBUN : 11
			//  placeholder : 12 :: MMSG :   12
			
			// 파라미터 클리어 꼭 하기
			pstmt.setString(1, mvo.getMnum());
			pstmt.setString(2, mvo.getMname());
			pstmt.setString(3, mvo.getMid());
			pstmt.setString(4, mvo.getMpw());
			pstmt.setString(5, mvo.getMhp());
			pstmt.setString(6, mvo.getMemail());
			pstmt.setString(7, mvo.getMgender());
			pstmt.setString(8, mvo.getMhobby());
			pstmt.setString(9, mvo.getMzone());
			pstmt.setString(10, mvo.getMroad());
			pstmt.setString(11, mvo.getMjibun());
			pstmt.setString(12, mvo.getMmsg());
			
			
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 등록 되었음");
			if (nCnt >0) {bool=true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e){
			logger.info("MemDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());;
		}finally{
			try {
				KosConnectivity.conClose(conn, pstmt);
			}catch(Exception e2){}
		}
		
		return bool;
	};

/*
/********************** UPDATE  ***************************/	
	@Override
	public boolean memUpdate(MemVO mvo){
		logger.info("MemDAOImpl :: memUpdate(MemVO mvo) :: Start \n");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try{
			conn=KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : "+conn.getAutoCommit());
			
			String sql=MemQueryMap.getMemUpdateQuery();
			pstmt=conn.prepareStatement(sql);
			logger.info("수정하기 >>> : \n"+sql);
			
			// 파라미터 클리어하기
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMemail());
			// placeholder : 1 :: MEMAIL
			pstmt.setString(2, mvo.getMhobby());
			// placeholder : 2 :: MHOBBY
			pstmt.setString(3, mvo.getMzone());
			// placeholder : 3 :: MZONE
			pstmt.setString(4, mvo.getMroad());
			// placeholder : 4 :: MROAD
			pstmt.setString(5, mvo.getMjibun());
			// placeholder : 5 :: MJIBUN
			pstmt.setString(6, mvo.getMnum());
			// placeholder : 6 :: MNUM
			
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			// System.out.println("nCnt >>> : "+nCnt+" 건 수정되었음");
			if(nCnt >0){ bool=true;}
			
			KosConnectivity.conClose(conn, pstmt);
			
		}catch(Exception e){
			// System.out.println("nCnt >>> : "+nCnt+"  건 수정 되었음 " );
			logger.info("MemDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());
		}finally{
			try{
				KosConnectivity.conClose(conn, pstmt);
			}catch(Exception e2){}
		}
		
		return bool;
	};
	
/********************** DELETE  ***************************/
	@Override
	public boolean memDelete(MemVO mvo){
		logger.info("MemDAOImpl :: memDelete(MemVO mvo) :: Start \n");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try{
			conn=KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : "+conn.getAutoCommit());
			
			String sql=MemQueryMap.getMemDeleteQuery();
			pstmt=conn.prepareStatement(sql);
			
			// 파라미터 클리어 꼭 하기
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMnum());
			
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 삭제 되었음");
			logger.info("nCnt >>> : "+nCnt+" 건 삭제 되었음");
			if(nCnt>0){ bool=true; }
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e){
			logger.info("MemDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());;
		}finally{
			try {
				KosConnectivity.conClose(conn, pstmt);
			}catch(Exception e2){}
		}
		
		return bool;
	};
	
}
