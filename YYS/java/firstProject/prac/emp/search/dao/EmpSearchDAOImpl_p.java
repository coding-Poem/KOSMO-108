package a.b.c.prac.emp.search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

import a.b.c.prac.emp.search.sql.EmpSearchQueryMap_p;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;
import a.b.c.prac2.OracleConnProperty_p;

public class EmpSearchDAOImpl_p implements EmpSearchDAO_p{
	
	// 전체검색 =============================================================
	@Override
	public ArrayList<EmpSearchVO_p> empSelectAll(){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectAll() 시작  >>> \n");
		// 커넥션
		// 쿼리문 전달
		// 질의 결과 받고
		
		Connection conn=null;
		// Connection 클래스로 연결
		
		PreparedStatement pstmt=null;
		// 쿼리문을 작성한다.
		
		ResultSet rsRs=null;
		// 쿼리문의 결과를 받는다.
		
		EmpSearchVO_p esvo=null;
		// EmpSearchVO_p 클래스의 참조변수
		
		ArrayList<EmpSearchVO_p> aList=null;
		// 결과를 배열로 저장한다.
		
		try{
			// 커넥션 연결
			conn=OracleConnProperty_p.getConnection();
			
			// 쿼리문 전달
			String sql=EmpSearchQueryMap_p.getEmpSelectAll();
			System.out.println("sql >>> : \n"+sql);
			
			// error
			pstmt=conn.prepareStatement(sql);
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectAll() :: Result 클래스로 쿼리문  결과 가져오기 성공 >>>");
			
			pstmt.clearParameters();
			// PreparedStatement의 참조변수를 쓰고 나면 꼭 clearParameters를 붙여서 마무리 해주어야 한다.
						
			/* 
			 받은 결과를 dvo에서 service로 전달하기
			 1. 질의 결과가 있는지 확인
			 2. 질의 결과가 있으면 ArrayList 인스턴스하기
			 3. ResultSet에 있는 next 함수로 레코드 가져오기
 			 4. 가져온 레코드 VO 담기
 			 5.  VO를 ArrayList에 담기
			*/
			
			 if(rsRs != null){
				 // 2.  질의 결과가 있으면 ArrayList 인스턴스하기
				 aList = new ArrayList<EmpSearchVO_p>();
				 
				 // 3. ResultSet에 있는 next 함수로 레코드 가져오기
				 while (rsRs.next()){
					 esvo = new EmpSearchVO_p();
					 esvo.setEmpno(rsRs.getString("EMPNO"));
					 esvo.setEname(rsRs.getString("ENAME"));
					 esvo.setJob(rsRs.getString("JOB"));
					 esvo.setMgr(rsRs.getString("MGR"));
					 esvo.setHiredate(rsRs.getString("HIREDATE"));
					 esvo.setSal(rsRs.getString("SAL"));
					 esvo.setComm(rsRs.getString("COMM"));
					 esvo.setDeptno(rsRs.getString("DEPTNO"));
					 
					 aList.add(esvo);
				 }
				 System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectAll() :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
				 
			 }else{
				 System.out.println("if문 진입 실패");
				 boolean bool = rsRs != null;
				 System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: rsRs != null >>> : "+bool);
				 System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: 전체 검색 결과가 없습니다. >>>> : "+rsRs);
			 }
			 
			 
			 
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: error >>> : "+e.getMessage());
		}
		
		// 질의 결과 받기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: aList가 null로 리턴됩니다.");
		}
		
		return aList;
	}
	
	// 사번 검색=============================================================
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpno(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) 시작  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: evo.getEmpno() >>> : "+evo.getEmpno());
		// 인수로 들어온 EmpSearchVO_p getEmpno() => this.empno
		// 참조변수 evo로 조회해보기 
		
		//  지역변수 선언 및 default value initialization
		//  기본값으로 초기화 하기
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		String empno=null;
		// 왜 _evo?? 들어온 인수값 evo가 있는데 여기서 EmpSearchVO_p 클래스의
		// 참조변수 evo를 null로 초기화 하면 안 되므로, _evo로 참조변수 지정
		ArrayList<EmpSearchVO_p> aList=null;
		
		/*
		 * 커넥션
		 * 쿼리문 전달
		 * 질의결과 받아오기
		 * */
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// 커넥션
			String sql=EmpSearchQueryMap_p.getEmpSelectEmpno();
			// sb.append()로 열심히 작성한 쿼리문을 String 클래스 sql 참조변수로
			// 저장
			empno=evo.getEmpno();
			
			// conn은 null인데, getConnection 함수를 통해
			// Class.forName(OracleConnProperty_p.JDBC_DRIVER)
			// 으로 JDBC_DRIVER가 있는지 확인해본다.
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: Result 클래스로 쿼리문  결과 가져오기 성공 >>> \n");
			
			pstmt.clearParameters();
			// PreparedStatement의 참조변수를 쓰고 나면 꼭 clearParameters를 붙여서 마무리 해주어야 한다.
			
			/*
			 * 1. 질의 결과가 있는 지 확인
			 * 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
			 * 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
			 * 4. 가져온 레코드 VO 담기 
			 * 5. VO를 ArrayList에 담기
			 * */
			
			// 1. 질의 결과가 있는지 확인
			if (rsRs != null){
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
				while (rsRs.next()){
					// 4. 가져온 레코드 VO 담기
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO를 ArrayList에 담기
					aList.add(_evo);
				}	
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
			}else{
				System.out.println("if문 진입 실패");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno :: rsRs==null >>> : "+bool);
				System.out.println("사번 검색 결과가 없습니다. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno :: 사번 검색중 에러가 >>> : "+e.getMessage());
		}
		
		// ArrayList  리턴하기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno() :: aList가 null로 리턴됩니다.");
		}
		
		return aList;
	}
	
	// 사원이름
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEname(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) 시작  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectEname(EmpSearchVO_p evo) :: evo.getEname() >>> "+evo.getEname());

		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String ename=null;
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// 커넥션
			String sql=EmpSearchQueryMap_p.getEmpSelectEname();
			ename=evo.getEname();
			
			// conn은 null인데, getConnection 함수를 통해
			// Class.forName(OracleConnProperty_p.JDBC_DRIVER)
			// 으로 JDBC_DRIVER가 있는지 확인해본다.
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) :: Result 클래스로 쿼리문  결과 가져오기 성공 >>>");
			
			pstmt.clearParameters();
	
			// 1. 질의 결과가 있는지 확인
			if (rsRs != null){
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
				while (rsRs.next()){
					// 4. 가져온 레코드 VO 담기
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO를 ArrayList에 담기
					aList.add(_evo);
				}
				System.out.println("<<< 7. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
			}else{
				System.out.println("if문 진입 실패");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEname :: rsRs==null >>> : "+bool);
				System.out.println("사번 검색 결과가 없습니다. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEname :: 사번 검색중 에러가 >>> : "+e.getMessage());
		}
		
		// ArrayList  리턴하기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEname() :: aList가 null로 리턴됩니다.");
		}
				
		return aList;
	}
	

	// 사원번호, 사원이름
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) 시작  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectEmpnoEname(EmpSearchVO_p evo) :: evo.getEmpno() >>> : "+evo.getEmpno());
		System.out.println("\n 2-2. EmpSearchDAOImpl_p ::  empSelectEmpnoEname(EmpSearchVO_p evo) :: evo.getEname() >>> : "+evo.getEname());
		
		//  지역변수 선언 및 default value initialization
		//  기본값으로 초기화 하기
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String empno=null;
		String ename=null;
		
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// 커넥션
			String sql=EmpSearchQueryMap_p.getEmpSelectEmpnoEname();
			empno=evo.getEmpno();
			ename=evo.getEname();
			
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empno);
			pstmt.setString(2, ename);
			
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) :: Result 클래스로 쿼리문  결과 가져오기 성공 >>>");
			
			pstmt.clearParameters();
	
			// 1. 질의 결과가 있는지 확인
			if (rsRs != null){
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
				while (rsRs.next()){
					// 4. 가져온 레코드 VO 담기
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO를 ArrayList에 담기
					aList.add(_evo);
				}
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
			}else{
				System.out.println("if문 진입 실패");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname :: rsRs==null >>> : "+bool);
				System.out.println("사번 검색 결과가 없습니다. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname :: 사번 검색중 에러가 >>> : "+e.getMessage());
		}
		
		// ArrayList  리턴하기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname() :: aList가 null로 리턴됩니다.");
		}
				
		return aList;
	}
	
	
	// 사원직책
	@Override
	public ArrayList<EmpSearchVO_p> empSelectJob(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) 시작  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectJob(EmpSearchVO_p evo) :: evo.empSelectEname() >>> : "+evo.getJob());

		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String job=null;
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// 커넥션
			String sql=EmpSearchQueryMap_p.getEmpSelectJob();
			job=evo.getJob();
			
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) :: Result 클래스로 쿼리문  결과 가져오기 성공 >>>");
			
			pstmt.clearParameters();
	
			// 1. 질의 결과가 있는지 확인
			if (rsRs != null){
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
				while (rsRs.next()){
					// 4. 가져온 레코드 VO 담기
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO를 ArrayList에 담기
					aList.add(_evo);
				}
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
			}else{
				System.out.println("if문 진입 실패");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectJob :: rsRs==null >>> : "+bool);
				System.out.println("사번 검색 결과가 없습니다. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectJob :: 사번 검색중 에러가 >>> : "+e.getMessage());
		}
		
		// ArrayList  리턴하기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectJob() :: aList가 null로 리턴됩니다.");
		}
		
		return aList;
	}
	
	// 입사일
	@Override
	public ArrayList<EmpSearchVO_p> empSelectHiredate(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) 시작  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: evo.getFromdate() >>> : "+evo.getFromdate());
		System.out.println("\n 2-2. EmpSearchDAOImpl_p ::  empSelectHiredate(EmpSearchVO_p evo) :: evo.getTodate() >>> : "+evo.getTodate());
		
		//  지역변수 선언 및 default value initialization
		//  기본값으로 초기화 하기
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String fromDate=null;
		String toDate=null;
		
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// 커넥션
			String sql=EmpSearchQueryMap_p.getEmpSelectHiredate();
			fromDate=evo.getFromdate();
			toDate=evo.getTodate();
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fromDate);
			pstmt.setString(2, toDate);
			
			
			// 질의 결과
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: Result 클래스로 쿼리문  결과 가져오기 성공 >>>");
			
			pstmt.clearParameters();
	
			// 1. 질의 결과가 있는지 확인
			if (rsRs != null){
				// 2. 질의 결과가 있으면 ArrayList 인스턴스 하기
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet에 있는 boolean 커서 next 함수로 레코드 가져오기
				while (rsRs.next()){
					// 4. 가져온 레코드 VO 담기
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO를 ArrayList에 담기
					aList.add(_evo);
				}	
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method에 this변수 입력 끝  >>> \n");
			}else{
				System.out.println("if문 진입 실패");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate :: rsRs==null >>> : "+bool);
				System.out.println("사번 검색 결과가 없습니다. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate :: 사번 검색중 에러가 >>> : "+e.getMessage());
		}
		
		// ArrayList  리턴하기
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate() :: aList가 null로 리턴됩니다.");
		}
		
		return aList;
	}
}
