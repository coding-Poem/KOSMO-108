package a.b.c.t6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.common.KosmoConnProperty;
import a.b.c.t6.sql.T6QueryMap;
import a.b.c.t6.vo.T6VO;

public class T6DAOImpl implements T6DAO {

	// 전체 조회
	@Override
	public ArrayList<T6VO> t6SelectAll() {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectAll >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			String sql = T6QueryMap.getT6SelectAll();
			pstmt = conn.prepareStatement(sql);
			System.out.println("전체 조회 >>> : \n" + sql);
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();

				while (rsRs.next()) {
					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: 전체조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  전체조회중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 이름 조회
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectName >>> : ");
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6SelectName();
			pstmt = conn.prepareStatement(sql);
			System.out.println("이름 조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getT2());
			
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();
				while (rsRs.next()) {					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: 이름조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  이름조회중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 날짜 검색
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectDate >>> : ");
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6SelectDate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("날짜 조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getFromdate());
			pstmt.setString(2, tvo.getTodate());
			
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();
				while (rsRs.next()) {					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: 이름조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  이름조회중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 입력
	/*
	JDBC 를 이용해서 데이터베이스에 입력,  수정, 삭제, 조회
	
	sqlplus
	---------------
	조회 : SELECT : DQL 
	입력, 수정, 삭제 : INSERT, UPDATE, DELETE : DML : TRANSACTION : COMMIT, ROLLBACK
		DML  문장으로 데이터를 테이블에 입력하면 
		1. 메모리에 쓴다.
		2. 메모리에 저장된 내용을 확인 하고 
		   목적에 맞으면 COMMIT,  맞지않으면 ROLLBACK 
		3. COMMIT 으로 파일에 쓴 이후에는 ROLLBACK 되지 않는다.
	
	splplus 에서 하는 것이 아니고 
	jdbc 드라이버를 이용해서 자바 프로그램에서 구현하는 것 
	
	자바프로그램 - jdbc 드라이버 - 오라클 데이터베이스 
	
	1. Connection
	2. PreparedStatement 쿼리문은 데이터베이스에 전달
	3. ResultSet, int 데이베이스에서 수행된 결과를 프로그램으로 전달 받아야 한다.
	
	SELECT
		테이블에서 조회된 ROW(파일)가 프로그램으로 전달 된다.
		Connection 
		PreparedStatement
		ResultSet
		executQuery() 
	
	INSERT, UPDATE, DELETE 
		테이블에 반영된 결과를 건수로 전달된다. 
		Connection 
		PreparedStatement
		int 
		executUpdate()
		
		jdbc 드라이버에서 일을 해준다. (Oracle 에서 jdbc 만드는 개발자가 정해준다.)
		jdbc 드라이버를 이용해서 
		오라클 데이터베이스 테이블에 데이터를 입력하면 
		최소 1건은 자동으로 커밋을 해준다. <-- 버전 별로 ???
		
		커밋을 어디서 콘트롤 하는가 : jdbc 드라이버에서 역활을 하고 : 오라클 엔진에게 요청을 한다. 
		개발자가 할 수 있는 일은
		Connection 인터페이스 setAutoCommit(), getAutCommit() 두가지 함수를 가지고 
		jdbc 드라이버에게 요청을 하면 
		jdbc 드라이버가 오라클 엔진(옵티마이저)에게 요청을 한다.
		요청을 받은 오라클 엔지(옵티마이저)가 현재 그 테이블의 상태를 보고 
		요청한 정보를 수행 한다. 
		
		Connection 인터페이스를 이용해서 
			자바프로그램 - jdbc 드라이버 - 오라클 데이터베이스 가 연결되면
		Connection.setAutoCommit() true 인 상태가 된다.
		setAutoCommit 이 true 인 상태에서 최초 1건 만 자동으로 커밋을 한다. 		 
	*/	
	@Override
	public boolean t6Insert(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Insert >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			// conn = KosmoConnProperty.getConnection(); 스테이트먼트 문장이 성립되면
			// 이 상태에서 커넥션이 하나 오픈이 된다.
			// 커네션이 오픈이 되면서 setAutoCommit() true 인 상태가 된다.
			// 최초 1건이 자동 커밋이다. <-- 자동 커밋을 요청한다. 1. jdbc 드라이버, 2. 오라클 엔진 
			conn = KosmoConnProperty.getConnection();			
			
			String sql = T6QueryMap.getT6Insert();
			pstmt = conn.prepareStatement(sql);
				System.out.println("입력하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getT1());
			pstmt.setString(2, tvo.getT2());
			pstmt.setString(3, tvo.getT3());
			
			nCnt = pstmt.executeUpdate();
//			boolean b = !conn.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) conn.commit(); // <-- 이 상태가는 커밋을 한 것이 아니고 커밋을 요청을 했다. 1. jdbc 드라이버에게 
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");			
			if (nCnt > 0) { bool = true;}
			
//			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
	}

	@Override
	public boolean t6Update(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Update >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			conn = KosmoConnProperty.getConnection();			
			String sql = T6QueryMap.getT6Update();
			pstmt = conn.prepareStatement(sql);
			System.out.println("수정하기 >>> : \n" + sql);
			
			pstmt.clearParameters();			
			pstmt.setString(1, tvo.getT2()); // place holder 1 :: A.T2 = ?
			pstmt.setString(2, tvo.getT3()); // place holder 2 :: A.T3 = ?
			pstmt.setString(3, tvo.getT1()); // place holder 3 :: A.T1 = ?
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");			
			if (nCnt > 0) { bool = true;}
			
			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;	
	}

	// 삭제
	@Override
	public boolean t6Delete(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Delete >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6Delete();
			pstmt = conn.prepareStatement(sql);
			System.out.println("삭제하기 >>> : \n" + sql);
			
			pstmt.clearParameters();						
			pstmt.setString(1, tvo.getT1()); // place holder 1 :: A.T1 = ?
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");			
			if (nCnt > 0) { bool = true;}
			
			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;	
	}
}
