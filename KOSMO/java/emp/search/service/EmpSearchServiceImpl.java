package a.b.c.emp.search.service;

import java.util.ArrayList;

import a.b.c.emp.search.dao.EmpSearchDAO;
import a.b.c.emp.search.dao.EmpSearchDAOImpl;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchServiceImpl implements EmpSearchService {

	// 전체 검색 
	// 어노테이션
	@Override
	public ArrayList<EmpSearchVO> empSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectAll() 함수 시작 >>> : ");
		/*
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList = esdao.empSelectAll();		
		return aList;
		*/
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();			
		return esdao.empSelectAll();
	}

	// 사번 검색
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEmpno() 함수 시작 >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEmpno(evo);
		
		return aList;
	}

	// 이름 검색 LIKE
	@Override
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEname() 함수 시작 >>> : ");
		System.out.println("EmpSearchServiceImpl.empSelectEname() evo.getEname() >>> : " + evo.getEname());
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEname(evo);
		
		return aList;
	}

	// 사번 이름 검색
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEmpnoEname() 함수 시작 >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEmpnoEname(evo);
		
		return aList;
	}

	// 직채 검색 LIKE
	@Override
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectJob() 함수 시작 >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectJob(evo);
		
		return aList;

	}

	// 날짜 검색
	@Override
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectHiredate() 함수 시작 >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectHiredate(evo);
		
		return aList;

	}
}
