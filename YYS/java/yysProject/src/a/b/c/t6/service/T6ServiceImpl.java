package a.b.c.t6.service;

import java.util.ArrayList;

import a.b.c.t6.dao.T6DAO;
import a.b.c.t6.dao.T6DAOImpl;
import a.b.c.t6.vo.T6VO;

public class T6ServiceImpl implements T6Service {
	@Override
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("\n T6ServiceImpl :: t6SelectAll() :: 시작");
		
		T6DAO td=new T6DAOImpl();
		
		return td.t6SelectAll();
	}
	
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo) {
		System.out.println("\n T6ServiceImpl :: t6SelectAll() :: 시작");
		
		T6DAO td=new T6DAOImpl();
		ArrayList<T6VO> aList=td.t6SelectName(tvo);
		
		return aList;
	}
	
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo) {
		
		T6DAO td=new T6DAOImpl();
		ArrayList<T6VO> aList=td.t6SelectDate(tvo);
		
		return aList;
	}
	
	
	@Override
	public boolean t6Insert(T6VO tvo) {
		T6DAO td=new T6DAOImpl();
		boolean bool=false;
		bool=td.t6Insert(tvo);

		return bool;
	}
	
	
	@Override
	public boolean t6Update(T6VO tvo) {
		T6DAO td=new T6DAOImpl();
		boolean bool=false;
		bool=td.t6Update(tvo);

		return bool;
	}
	
	
	@Override
	public boolean t6Delete(T6VO tvo) {
		T6DAO td=new T6DAOImpl();
		boolean bool=false;
		bool=td.t6Delete(tvo);
		
		return bool;
	}
	
} // T6ServiceImpl
