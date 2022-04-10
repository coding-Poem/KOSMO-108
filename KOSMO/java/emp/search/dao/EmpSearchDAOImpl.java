package a.b.c.emp.search.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.common.OracleConnProperty;
import a.b.c.emp.search.sql.EmpSearchQueryMap;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchDAOImpl implements EmpSearchDAO {

	// 전체 검색 ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectAll() >>> : 진입 성공 ");
		
		//
		Connection conn = null;
		//
		PreparedStatement pstmt = null;
		//
		ResultSet rsRs = null;
		//
		ArrayList<EmpSearchVO> aList = null;
		// 
		EmpSearchVO esvo = null;
		
		
		try {
			// 커넥션 연결
			conn = OracleConnProperty.getConnection();
			
			// 쿼리문 전달
			String sql = EmpSearchQueryMap.getEmpSelectAll();
			pstmt = conn.prepareStatement(sql);
			System.out.println("전체 검색 >>> : \n" + sql);
			
			// 질의 결과 받고
			rsRs = pstmt.executeQuery();
			
			// 받은 결과를 dao 에서 service 로 전달하기 
			/*
			1. 질의 결과가 있는지 확인 
			2. 질의 결과가 있으면 ArrayList 인스턴스 하기 
			3. 리절트셋에 있는 boolean 커서 next 함수로 레코드 가져오기 
			4. 가져온 레코드 VO 담기 
			5. VO 를 ArrayList에 담기 
			*/		
			// 1. 질의 결과가 있는지 확인 
			if (rsRs !=null) {
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기 
				aList = new ArrayList<EmpSearchVO>();
				
				// 3. 리절트셋에 있는 boolean 커서 next 함수로 레코드 가져오기 
				while (rsRs.next()) {
					
					// 4. 가져온 레코드 VO 담기 
					esvo = new EmpSearchVO();
					esvo.setEmpno(rsRs.getString(1));
					esvo.setEname(rsRs.getString(2));
					esvo.setJob(rsRs.getString(3));
					esvo.setMgr(rsRs.getString(4));
					esvo.setHiredate(rsRs.getString(5));
					esvo.setSal(rsRs.getString(6));
					esvo.setComm(rsRs.getString(7));
					esvo.setDeptno(rsRs.getString(8));
					
					// 5. VO 를 ArrayList에 담기 
					aList.add(esvo);
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 전체 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: DAO :: 전체 검색중 에러가 >>> :  " + e.getMessage());
		}
		
		// ArrayList 리턴하기 
		return aList;
	}

	// 사번 검색 ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo) {		
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEmpno() >>> : 진입 성공 ");
		System.out.println("evo.getEmpno() >>> : " + evo.getEmpno()); // 7934

		// 지역변수 선언 및 default value initialization 기본값으로 초기화하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; // 7934	MILLER	CLERK	1982-01-23	10  담을 VO 
		
		/*
		커넥션
		쿼리문 전달
		질의결과 받아오기 
		*/
		try {
			// 커넥션
			conn = OracleConnProperty.getConnection();
			
			// 쿼리문 전달
			String sql = EmpSearchQueryMap.getEmpSelectEmpno();
			pstmt = conn.prepareStatement(sql);
			System.out.println("사번 검색 >>> : \n" + sql);
			
			pstmt.clearParameters();
//			sb.append(" WHERE    A.EMPNO = ?					\n"); // place holder 1
			pstmt.setString(1, evo.getEmpno()); // place holder 1  7934
			
			// 질의결과 받아오기 
			rsRs = pstmt.executeQuery();
			// 7934	MILLER	CLERK	1982-01-23	10
			
			// 받은 결과를 dao 에서 service 로 전달하기 
			/*
			1. 질의 결과가 있는지 확인 
			2. 질의 결과가 있으면 ArrayList 인스턴스 하기 
			3. 리절트셋에 있는 boolean 커서 next 함수로 레코드 가져오기 
			4. 가져온 레코드 VO 담기 
			5. VO 를 ArrayList에 담기 
			*/		
			
			// 1. 질의 결과가 있는지 확인 
			if (rsRs !=null) {
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기 
				aList = new ArrayList<EmpSearchVO>();
				
				// 3. 리절트셋에 있는 boolean 커서 next 함수로 레코드 가져오기 
				while (rsRs.next()) {
					// 4. 가져온 레코드 VO 담기 
					
					_evo = new EmpSearchVO();
					// 7934	MILLER	CLERK	1982-01-23	10
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					
					// 5. VO 를 ArrayList에 담기 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 사번 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: 사번 검색중 에러가  >>> : " + e.getMessage());
		}
		// ArrayList 리턴하기 
		return aList;
	}

	// 이름 검색 LIKE ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEname() >>> : 진입 성공 ");
		System.out.println("evo.getEname() >>> : " + evo.getEname()); 

		// 지역변수 선언 및 default value initialization 기본값으로 초기화하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectEname();
			pstmt = conn.prepareStatement(sql);
			System.out.println("이름 검색 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getEname()); // place holder 1 

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 이름 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: 이름 검색중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 사번 이름 검색 ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEmpnoEname() >>> : 진입 성공 ");
		System.out.println("evo.getEmpno() >>> : " + evo.getEmpno()); 
		System.out.println("evo.getEname() >>> : " + evo.getEname()); 

		// 지역변수 선언 및 default value initialization 기본값으로 초기화하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectEmpnoEname();
			pstmt = conn.prepareStatement(sql);
			System.out.println("사번 이름 검색 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getEmpno()); // place holder 1  
			pstmt.setString(2, evo.getEname()); // place holder 2  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 사번 이름 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: 사번 이름 검색중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 직채 검색 LIKE --------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectJob() >>> : 진입 성공 ");
		System.out.println("evo.getJob() >>> : " + evo.getJob()); 

		// 지역변수 선언 및 default value initialization 기본값으로 초기화하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectJob();
			pstmt = conn.prepareStatement(sql);
			System.out.println("직책 검색 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getJob()); // place holder 1  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 직책 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: 직책 검색중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// 날짜 검색 ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectHiredate() >>> : 진입 성공 ");
		System.out.println("evo.getFromdate() >>> : " + evo.getFromdate()); 
		System.out.println("evo.getTodate() >>> : " + evo.getTodate()); 

		// 지역변수 선언 및 default value initialization 기본값으로 초기화하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectHiredate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("날짜 검색 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getFromdate());  // place holder 1 
			pstmt.setString(2, evo.getTodate()); 	// place holder 2  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: 날씨 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: 날씨 검색중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}
	
}












