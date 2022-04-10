package a.b.c.prac.emp.search.service;

import java.util.ArrayList;

import a.b.c.prac.emp.search.dao.EmpSearchDAOImpl_p;
import a.b.c.prac.emp.search.dao.EmpSearchDAO_p;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;

public class EmpSearchServiceImpl_p implements EmpSearchService_p{
	
	// 전체검색
	// 애노테이션
	@Override
	public ArrayList<EmpSearchVO_p> empSelectAll(){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectAll() 시작 >>> \n");
		
		/*
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList = esdao.empSelectAll();
		return aList;
		*/
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		
		return esdao.empSelectAll();
	}
	
	//사원 검색
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpno(EmpSearchVO_p evo){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectEmpno(EmpSearchVO_p evo) 시작 >>> \n");
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList=esdao.empSelectEmpno(evo);
		
		return aList;
	}
	
	// 이름 검색
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEname(EmpSearchVO_p evo){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectEname(EmpSearchVO_p evo) 시작 >>> \n");
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList=esdao.empSelectEname(evo);
		
		return aList;
	}
	
	//사번, 이름 검색
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(EmpSearchVO_p evo){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) 시작 >>> \n");
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList=esdao.empSelectEmpnoEname(evo);
		
		return aList;
	}
	
	// 직책 검색
	@Override
	public ArrayList<EmpSearchVO_p> empSelectJob(EmpSearchVO_p evo){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectJob(EmpSearchVO_p evo) 시작 >>> \n");
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList=esdao.empSelectJob(evo);
		
		return aList;
	}
	
	// 날짜 검색
	@Override
	public ArrayList<EmpSearchVO_p> empSelectHiredate(EmpSearchVO_p evo){
		System.out.println("<<< 1. EmpSearchServiceImpl_p :: empSelectHiredate(EmpSearchVO_p evo) 시작 >>> \n");
		
		EmpSearchDAO_p esdao=new EmpSearchDAOImpl_p();
		ArrayList<EmpSearchVO_p> aList=esdao.empSelectHiredate(evo);
		
		return aList;
	}
}
