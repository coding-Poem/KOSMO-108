package a.b.c.t6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import a.b.c.common.OracleConnProperty;
import a.b.c.t6.sql.T6QueryMap;
import a.b.c.t6.vo.T6VO;


public class T6DAOImpl implements T6DAO{
	// Select
	/*
	 * 1. 질의 결과가 있는지 확인
	 * 2. 질의 결과가 있으면 ArrayList 인스턴스하기
	 * 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
	 * 4. 가져온 레코드 VO 담기
	 * 5. VO를 ArrayList에 담기
	 * 
	 * */
	
	@Override
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("\n T6DAOImpl :: t6SelectAll() :: 시작");
		
		// 지역변수 초기화
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		// ArrayList<T6VO> 초기화
		ArrayList<T6VO> aList=null;
		T6VO tvo=null;
		
		try{
			// 커넥션 연결
			conn=OracleConnProperty.getConnection();
			// DB연결하기
			
			// 쿼리문 받아오기
			String sql= T6QueryMap.getT6SelectAll();
			// 쿼리문 입력
			pstmt=conn.prepareStatement(sql);
			// 쿼리문 출력
			System.out.println("전체 검색 >>> : \n"+sql);
			
			
			// 질의 결과 받기
			rsRs=pstmt.executeQuery();
			
			// 1
			if(rsRs!=null){
				//2 ArrayList 인스턴스 하기
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					tvo=new T6VO();
					tvo.setT1(rsRs.getString(1));
					tvo.setT2(rsRs.getString(2));
					tvo.setT3(rsRs.getString(3));
					tvo.setT4(rsRs.getString(4));
					tvo.setT5(rsRs.getString(5));
					tvo.setT6(rsRs.getString(6));
					// T6VO setting 완료
					
					// 5
					aList.add(tvo);
				}		
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6SelectAll() :: error >>> : "+e.getMessage());
		}
		
		// aList가 null이거나 aList.size()가 0인 경우 출력
		if (aList==null || aList.size()==0){
			System.out.println("T6DAOImpl :: t6SelectAll() :: Return 되는 aList >>> : "+aList);
			System.out.println("T6DAOImpl :: t6SelectAll() :: Return 되는 aList.size() >>> : "+aList.size());
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			// OracleConnProperty.conClose(conn, pstmt, rsRs);
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		// ArrayList 리턴하기
		return aList;
	}; // t6SelectAll()
	
	
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6SelectName(T6VO tvo) :: 시작");
		System.out.println("tvo.getT2 :: (회원이름) >>> "+tvo.getT2());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo=null;
		
		try{
			// 커넥션 연결
			conn=OracleConnProperty.getConnection();
			// DB연결하기
			
			// 쿼리문 받아오기
			String sql= T6QueryMap.getT6SelectName();
			
			// 쿼리문 입력
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tvo.getT2());  // place holder 1 :: 회원이름
			System.out.println("전체 검색 >>> : \n"+sql);
			// 쿼리문 출력
			
			// 질의 결과 받기
			// System.out.println("에러체크1 통과");
			rsRs=pstmt.executeQuery(); // error 나는지 확인해보기
			// System.out.println("에러체크2 통과");
			pstmt.clearParameters();
			// System.out.println("에러체크3 통과");
			
			// 1
			if(rsRs!=null){
				//2 ArrayList 인스턴스 하기
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					// T6VO setting 완료
					
					// 5
					aList.add(_tvo);
				}
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: getT6SelectName() :: error >>> : "+e.getMessage());
		}
		
		// aList가 null이거나 aList.size()가 0인 경우 출력
		if (aList==null || aList.size()==0){
			System.out.println("T6DAOImpl :: t6SelectName() :: Return 되는 aList >>> : "+aList);
			System.out.println("T6DAOImpl :: t6SelectName() :: Return 되는 aList.size() >>> : "+aList.size());
		}
		
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		
		// ArrayList 리턴하기
		return aList;
	};
	
	
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6SelectDate(T6VO tvo) :: 시작");
		System.out.println("tvo.getFromdate() :: (입사일) >>> "+tvo.getFromdate());
		System.out.println("tvo.getTodate() :: (입사일) >>> "+tvo.getTodate());

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo=null;
		
		try{
			// 커넥션 연결
			conn=OracleConnProperty.getConnection();
			// DB연결하기
			
			// 쿼리문 받아오기
			String sql= T6QueryMap.getT6SelectDate();
			
			// 쿼리문 입력
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tvo.getFromdate()); // place holder 1 :: 입사일 :: fromdate
			pstmt.setString(2, tvo.getTodate());  // place holder 2 :: 입사일  ::  todate
			System.out.println("날짜 조회 >>> : \n"+sql);
			// 쿼리문 출력
			
			// 질의 결과 받기
			// System.out.println("에러체크1 통과");
			rsRs=pstmt.executeQuery(); // error 나는지 확인해보기
			// System.out.println("에러체크2 통과");
			pstmt.clearParameters();
			// System.out.println("에러체크3 통과");
			
			// 1
			if(rsRs!=null){
				//2 ArrayList 인스턴스 하기
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					// T6VO setting 완료
					
					// 5
					aList.add(_tvo);
				}
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6SelectDate(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		
		return aList;
	};
	
	
	// Insert
	@Override
	public boolean t6Insert(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Insert(T6VO tvo) :: 시작");
		System.out.println("tvo.getT1() >>> "+tvo.getT1());
		System.out.println("tvo.getT2() >>> "+tvo.getT2());
		System.out.println("tvo.getT3() >>> "+tvo.getT3());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=OracleConnProperty.getConnection();
			// 쿼리문 입력
			String sql=T6QueryMap.getT6Insert();
			pstmt=conn.prepareStatement(sql);
			// pstmt.setString(1, ???); 회원번호가 쿼리로 날라가야 하는데
			// T6 + YYYYMMDD + 0001 형식으로 INSERT가 되야 한다.
			System.out.println("INSERT :: sql >>> \n"+sql);
		
			pstmt.setString(1, tvo.getT1()); // place holder :: 1 :: 회원번호
			pstmt.setString(2, tvo.getT2()); // place holder :: 2 :: 회원이름
			pstmt.setString(3, tvo.getT3()); // place holder :: 3 :: 회원나이
			
			nCnt=pstmt.executeUpdate();
			
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Insert(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Insert(T6VO tvo) :: return 직전 nCnt >>> : "+nCnt);
		}
		
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		
		return bool;
	};
	
	
	// Update
	@Override
	public boolean t6Update(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Update(T6VO tvo) :: 시작");
		System.out.println("tvo.getT1() >>> "+tvo.getT1());
		System.out.println("tvo.getT2() >>> "+tvo.getT2());
		System.out.println("tvo.getT3() >>> "+tvo.getT3());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;

		try {
			conn=OracleConnProperty.getConnection();
			// 쿼리문 입력
			String sql=T6QueryMap.getT6Update();
			pstmt=conn.prepareStatement(sql);
			
			System.out.println("UPDATE :: sql >>> \n"+sql);
					
			pstmt.setString(1, tvo.getT2()); // place holder :: 1 :: 회원이름
			pstmt.setString(2, tvo.getT3()); // place holder :: 2 :: 회원나이
			pstmt.setString(3, tvo.getT1()); // place holder :: 3 :: 회원번호
			
			// UPDATE TEST_T6 SET T2=?, T3=?, T6=SYSDATE WHERE T4='Y' AND T1=?
			
			nCnt=pstmt.executeUpdate();
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Update(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Update(T6VO tvo) :: return 직전 nCnt >>> : "+nCnt);
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
		}
		
		return bool;
	};
	

	// Delete
	@Override
	public boolean t6Delete(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Delete(T6VO tvo) :: 시작");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=OracleConnProperty.getConnection();
			// 쿼리문 입력
			String sql=T6QueryMap.getT6Delete();
			pstmt=conn.prepareStatement(sql);
			
			System.out.println("DELETE :: sql >>> \n"+sql);
					
			pstmt.setString(1, tvo.getT1()); // place holder :: 1 :: 회원이름		
			
			// UPDATE TEST_T6 SET T2=?, T3=?, T6=SYSDATE WHERE T4='Y' AND T1=?
			
			nCnt=pstmt.executeUpdate();
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Delete(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Delete(T6VO tvo) :: return 직전 nCnt >>> : "+nCnt);
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e){}
			}
		
		return bool;
	};

} // T6DAOImpl
