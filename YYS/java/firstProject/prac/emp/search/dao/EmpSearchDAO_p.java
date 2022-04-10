package a.b.c.prac.emp.search.dao;

import java.util.ArrayList;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;

public interface EmpSearchDAO_p {
	public ArrayList<EmpSearchVO_p> empSelectAll();
	public ArrayList<EmpSearchVO_p> empSelectEmpno(EmpSearchVO_p evo);
	
	public ArrayList<EmpSearchVO_p> empSelectEname(EmpSearchVO_p evo);
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(EmpSearchVO_p evo);
	public ArrayList<EmpSearchVO_p> empSelectJob(EmpSearchVO_p evo);
	public ArrayList<EmpSearchVO_p> empSelectHiredate(EmpSearchVO_p evo);
}
