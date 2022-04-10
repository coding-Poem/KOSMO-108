package a.b.c.t6.dao;

import java.util.ArrayList;

import a.b.c.t6.vo.T6VO;

//A : Actual Practice
public interface T6DAO_A {
	public ArrayList<T6VO> t6SelectAll();
	public ArrayList<T6VO> t6SelectName(T6VO tvo);
	public ArrayList<T6VO> t6SelectDate(T6VO tvo);
	
	
	public boolean t6Insert(T6VO tvo);
	public boolean t6Update(T6VO tvo);
	public boolean t6Delete(T6VO tvo);
}
