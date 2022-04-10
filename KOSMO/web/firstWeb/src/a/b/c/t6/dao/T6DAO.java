package a.b.c.t6.dao;

import java.util.ArrayList;

import a.b.c.t6.vo.T6VO;

public interface T6DAO {

	public ArrayList<T6VO> t6SelectAll();
	public ArrayList<T6VO> t6SelectName(T6VO tvo);
	public ArrayList<T6VO> t6SelectDate(T6VO tvo);

	public boolean t6Insert(T6VO tvo);
	public boolean t6Update(T6VO tvo);
	public boolean t6Delete(T6VO tvo);
	
	// 회원번호 검색 추가 
	public ArrayList<T6VO> t6SelectNum(T6VO tvo);
}
