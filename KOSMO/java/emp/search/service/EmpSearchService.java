package a.b.c.emp.search.service;

import java.util.ArrayList;

import a.b.c.emp.search.vo.EmpSearchVO;

public interface EmpSearchService {

	// 전체 검색
	public ArrayList<EmpSearchVO> empSelectAll();
	// 사번 검색
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo);
	
	// 이름 검색 LIKE
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo);
	// 사번 이름 검색
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo);
	// 직책 검색 LIKE 
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo);
	// 날짜 검색
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo);
}
